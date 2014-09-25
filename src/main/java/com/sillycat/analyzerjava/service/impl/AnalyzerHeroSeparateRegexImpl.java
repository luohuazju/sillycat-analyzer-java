package com.sillycat.analyzerjava.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.sillycat.analyzerjava.model.ContentLabel;
import com.sillycat.analyzerjava.model.LinkLabel;
import com.sillycat.analyzerjava.service.AnalyzerHero;
import com.sillycat.analyzerjava.service.CacheHero;
import com.sillycat.analyzerjava.service.JSONMapperHero;
import com.sillycat.analyzerjava.service.ResourceFetchHero;
import com.sillycat.analyzerjava.service.base.BaseHero;

public class AnalyzerHeroSeparateRegexImpl extends BaseHero implements
		AnalyzerHero {

	private final String NAME_PATTERN_REGEX = "([@]{1}(?<name>[a-zA-Z0-9]+)[ ]{1})";

	private final String URL_PATTERN_REGEX = "(?<url>(https|http)://[-a-zA-Z0-9+&@#/%?=~_|!:,.;]*[-a-zA-Z0-9+&@#/%=~_|])";

	private final String EM_PATTERN_REGEX = "([(](?<em>\\w+)[)])";

	private Pattern namePattern;

	private Pattern urlPattern;

	private Pattern emPattern;

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
		namePattern = Pattern.compile(NAME_PATTERN_REGEX);
		urlPattern = Pattern.compile(URL_PATTERN_REGEX);
		emPattern = Pattern.compile(EM_PATTERN_REGEX);
	}

	public String analyzerAll(String sourceString) {
		String result = null;
		List<String> mentions = new ArrayList<String>();
		List<LinkLabel> links = new ArrayList<LinkLabel>();
		List<String> emoticons = new ArrayList<String>();
		ContentLabel contentLabel = new ContentLabel();

		//bad codes to repeat and copy/paste here, but anyway, I will not use this solution
		//because it is slow
		
		Matcher nameMatcher = namePattern.matcher(sourceString);
		while (nameMatcher.find()) {
			if (nameMatcher.group("name") != null) {
				log.debug("getting mention=" + nameMatcher.group("name"));
				mentions.add(nameMatcher.group("name"));
			}
		}
		if (!mentions.isEmpty()) {
			contentLabel.setMentions(mentions);
		}

		Matcher emMatcher = emPattern.matcher(sourceString);
		while (emMatcher.find()) {
			if (emMatcher.group("em") != null) {
				log.debug("getting em=" + emMatcher.group("em"));
				emoticons.add(emMatcher.group("em"));
			}
		}
		if (!emoticons.isEmpty()) {
			contentLabel.setEmoticons(emoticons);
		}

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

}
