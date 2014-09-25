package com.sillycat.analyzerjava.service.impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.sillycat.analyzerjava.common.Constants;
import com.sillycat.analyzerjava.model.ContentLabel;
import com.sillycat.analyzerjava.model.LinkLabel;
import com.sillycat.analyzerjava.service.AnalyzerHero;
import com.sillycat.analyzerjava.service.CacheHero;
import com.sillycat.analyzerjava.service.JSONMapperHero;
import com.sillycat.analyzerjava.service.ResourceFetchHero;
import com.sillycat.analyzerjava.service.base.BaseHero;

public class AnalyzerHeroDFAImpl extends BaseHero implements AnalyzerHero {

	@SuppressWarnings("rawtypes")
	private Map emMap = null;

	@SuppressWarnings("rawtypes")
	private Map nameMap = null;
	
	private final String URL_PATTERN_REGEX = "(?<url>(https|http)://[-a-zA-Z0-9+&@#/%?=~_|!:,.;]*[-a-zA-Z0-9+&@#/%=~_|])";
	
	private Pattern urlPattern;
	
	@Autowired
	@Qualifier("resourceFetchHero")
	private ResourceFetchHero resourceFetchHero;

	@Autowired
	@Qualifier("jsonMapperHero")
	private JSONMapperHero<ContentLabel> jsonMapperHero;

	@Autowired
	@Qualifier("cacheHero")
	private CacheHero cacheHero;

	@SuppressWarnings("unused")
	private void init() {
		Set<String> emSet = readSensitiveWordFile("ems.properties");
		log.debug("init the ems keywords size = " + emSet.size());
		addSensitiveWordToHashMap(emSet,Constants.MAP_EMS);
		log.debug("init the ems Map size = " + emMap.size());
		
		Set<String> nameSet = readSensitiveWordFile("names.properties");
		log.debug("init the names keywords size = " + nameSet.size());
		addSensitiveWordToHashMap(nameSet,Constants.MAP_NAMES);
		log.debug("init the names Map size = " + nameMap.size());
		
		urlPattern = Pattern.compile(URL_PATTERN_REGEX);
	}

	

	public String analyzerAll(String sourceString) {
		String result = null;
		ContentLabel contentLabel = new ContentLabel();
		
		List<String> names = getSensitiveWord(sourceString, Constants.MIN_MATCH_TYPE, Constants.MAP_NAMES);
		if(!names.isEmpty()){
			contentLabel.setMentions(names);
		}
		
		List<String> ems = getSensitiveWord(sourceString, Constants.MIN_MATCH_TYPE, Constants.MAP_EMS);
		if(!ems.isEmpty()){
			contentLabel.setEmoticons(ems);
		}
		
		List<LinkLabel> links = new ArrayList<LinkLabel>();
		Matcher urlMatcher = urlPattern.matcher(sourceString);
		while (urlMatcher.find()) {
			final String keyURL = urlMatcher.group("url");
			if (keyURL != null) {
				log.debug("getting link=" + keyURL);
				links.add(new LinkLabel(keyURL, (String) cacheHero.load(keyURL,
						new Callable<String>() {
							public String call() {
								return resourceFetchHero
										.getTitlefromURL(keyURL);
							}
						})));
			}
		}
		if (!links.isEmpty()) {
			contentLabel.setLinks(links);
		}
		result = jsonMapperHero.toJSON(contentLabel);
		return result;
	}
	
	private List<String> getSensitiveWord(String txt , int matchType, int mapType){
		List<String> sensitiveWordList = new ArrayList<String>();
		
		for(int i = 0 ; i < txt.length() ; i++){
			int length = CheckSensitiveWord(txt, i, matchType, mapType);    
			if(length > 0){    
				if(Constants.MAP_EMS == mapType){
					sensitiveWordList.add(txt.substring(i+1, i+length-1));
				}else{
					sensitiveWordList.add(txt.substring(i+1, i+length));
				}
				i = i + length - 1;   
			}
		}
		
		return sensitiveWordList;
	}
	
	@SuppressWarnings("rawtypes")
	private int CheckSensitiveWord(String txt,int beginIndex,int matchType, int mapType){
		boolean  flag = false;    
		int matchFlag = 0;     
		char word = 0;
		Map nowMap = null;
		if(Constants.MAP_EMS == mapType){
			nowMap = emMap;
		}else{
			nowMap = nameMap;
		}
		
		for(int i = beginIndex; i < txt.length() ; i++){
			word = txt.charAt(i);
			nowMap = (Map) nowMap.get(word);     
			if(nowMap != null){     
				matchFlag++;     
				if("1".equals(nowMap.get("isEnd"))){       
					flag = true;       
					if(Constants.MIN_MATCH_TYPE == matchType){    
						break;
					}
				}
			}
			else{     
				break;
			}
		}
		if(matchFlag < 2 || !flag){        
			matchFlag = 0;
		}
		return matchFlag;
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private void addSensitiveWordToHashMap(Set<String> keyWordSet, int mapType) {
		if(Constants.MAP_EMS == mapType){
			emMap = new HashMap<String, Map>(keyWordSet.size());
		}else{
			nameMap = new HashMap<String, Map>(keyWordSet.size());
		}
		
		String key = null;
		Map nowMap = null;
		Map<String, String> newWorMap = null;
		Iterator<String> iterator = keyWordSet.iterator();
		while (iterator.hasNext()) {
			key = iterator.next();
			if(Constants.MAP_EMS == mapType){
				nowMap = emMap;
			}else{
				nowMap = nameMap;
			}
			for (int i = 0; i < key.length(); i++) {
				char keyChar = key.charAt(i);
				Object wordMap = nowMap.get(keyChar);

				if (wordMap != null) {
					nowMap = (Map) wordMap;
				} else {
					newWorMap = new HashMap<String, String>();
					newWorMap.put("isEnd", "0");
					nowMap.put(keyChar, newWorMap);
					nowMap = newWorMap;
				}

				if (i == key.length() - 1) {
					nowMap.put("isEnd", "1");
				}
			}
		}
	}

	private Set<String> readSensitiveWordFile(String fileName) {
		Set<String> set = null;
		InputStream is = getClass().getResourceAsStream("/" + fileName);
		Reader reader = new InputStreamReader(is);
		try {
			set = new HashSet<String>();
			BufferedReader bufferedReader = new BufferedReader(reader);
			String txt = null;
			while ((txt = bufferedReader.readLine()) != null) {
				set.add(txt);
			}
		} catch (Exception e) {
			log.error("Exception:" + e);
		} finally {
			try {
				reader.close();
			} catch (IOException e) {
				log.error("Exception:" + e);
			}
		}
		return set;
	}

}
