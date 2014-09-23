package com.sillycat.analyzerjava.service.impl;

import java.io.IOException;

import org.jsoup.Jsoup;

import com.sillycat.analyzerjava.service.ResourceFetchHero;
import com.sillycat.analyzerjava.service.base.BaseHero;


public class ResourceFetchHeroJsoupImpl extends BaseHero implements ResourceFetchHero{

	public String getTitlefromURL(String url) {
		String result = null;
		try {
			log.debug("====================================");
			log.debug("searching title for url:" + url);
			result = Jsoup.connect(url).get().title();
			log.debug("title:" + result);
			log.debug("====================================");
		} catch (IOException e) {
			log.error("Exception:" + e);
		}
		return result;
	}

}
