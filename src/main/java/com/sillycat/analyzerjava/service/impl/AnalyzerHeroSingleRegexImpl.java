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

public class AnalyzerHeroSingleRegexImpl extends BaseHero implements
		AnalyzerHero {

	private final String PATTER_SINGLE_REGEX = "([@]{1}(?<name>[a-zA-Z0-9]+)[ ]{1})|(?<url>(https|http)://[-a-zA-Z0-9+&@#/%?=~_|!:,.;]*[-a-zA-Z0-9+&@#/%=~_|])|([(](?<em>\\w+)[)])";

	private Pattern singlePattern;

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
		singlePattern = Pattern.compile(PATTER_SINGLE_REGEX);
	}

	public String analyzerAll(String sourceString) {
		String result = null;
		Matcher matcher = singlePattern.matcher(sourceString);
		List<String> mentions = new ArrayList<String>();
		List<LinkLabel> links = new ArrayList<LinkLabel>();
		List<String> emoticons = new ArrayList<String>();
		while (matcher.find()) {
			if (matcher.group("name") != null) {
				log.debug("getting mention=" + matcher.group("name"));
				mentions.add(matcher.group("name"));
			}
			final String keyURL = matcher.group("url");
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
			if (matcher.group("em") != null) {
				log.debug("getting em=" + matcher.group("em"));
				emoticons.add(matcher.group("em"));
			}
		}
		if (!mentions.isEmpty() || !links.isEmpty() || !emoticons.isEmpty()) {
			ContentLabel contentLabel = new ContentLabel();
			if (!mentions.isEmpty()) {
				contentLabel.setMentions(mentions);
			}
			if (!links.isEmpty()) {
				contentLabel.setLinks(links);
			}
			if (!emoticons.isEmpty()) {
				contentLabel.setEmoticons(emoticons);
			}
			result = jsonMapperHero.toJSON(contentLabel);
		}
		return result;
	}

}
