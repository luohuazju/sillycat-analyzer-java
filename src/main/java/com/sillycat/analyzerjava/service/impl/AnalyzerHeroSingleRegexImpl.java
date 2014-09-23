package com.sillycat.analyzerjava.service.impl;

import java.util.regex.Pattern;

import com.sillycat.analyzerjava.service.AnalyzerHero;
import com.sillycat.analyzerjava.service.base.BaseHero;

public class AnalyzerHeroSingleRegexImpl extends BaseHero implements
		AnalyzerHero {

	private final String PATTER_SINGLE_REGEX = "([@]{1}(?<name>[a-zA-Z0-9]+)[ ]{1})|(?<url>(https|http)://[-a-zA-Z0-9+&@#/%?=~_|!:,.;]*[-a-zA-Z0-9+&@#/%=~_|])|([{](?<em>\\w+)[}])";
	private Pattern singlePattern;
	
	
	@SuppressWarnings("unused")
	private void init(){
		singlePattern = Pattern.compile(PATTER_SINGLE_REGEX);
	}
	
	public String analyzerAll(String sourceString) {
		String result = null;
//		Matcher matcher = singlePattern.matcher(sourceString);
//		List<String> mentions = new ArrayList<String>();
//		List<LinkLabel> links = new ArrayList<LinkLabel>(); 
//		List<String> emoticons = new ArrayList<String>();
//		while(matcher.find()){
//			if(matcher.group("name") != null){
//				mentions.add(matcher.group("name"));
//			}
//			if(matcher.group("url") != null){
//				links.add(new LinkLabel(matcher.group("url"),""));
//			}
//			if(matcher.group("em") != null){
//				emoticons.add(matcher.group("em"));
//			}
//		}
		return result;
	}

}
