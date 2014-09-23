package com.sillycat.analyzerjava.service;

import junit.framework.Assert;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.sillycat.analyzerjava.base.BaseTest;

public class ResourceFetchHeroTest extends BaseTest {

	@Autowired
	@Qualifier("resourceFetchHero")
	private ResourceFetchHero resourceFetchHero;

	/**
	 * "url": "http://www.nbcolympics.com", "title":
	 * "NBC Olympics | Home of the 2016 Olympic Games in Rio" Just fetch the title
	 * from homepage
	 */
	@Test
	public void homepage() {
		Assert.assertEquals(
				resourceFetchHero.getTitlefromURL("http://www.nbcolympics.com"),
				"NBC Olympics | Home of the 2016 Olympic Games in Rio");
	}

	/**
	 * "url": "https://twitter.com/jdorfman/status/430511497475670016", "title":
	 * "Justin Dorfman on Twitter: &quot;nice @littlebigdetail from @HipChat (shows hex colors when pasted in chat). http://t.co/7cI6Gjy5pq&quot;"
	 */
	@Test
	public void detailpage() {
		Assert.assertEquals(
				resourceFetchHero
						.getTitlefromURL("https://twitter.com/jdorfman/status/430511497475670016"),
				"Justin Dorfman on Twitter: \"nice @littlebigdetail from @HipChat (shows hex colors when pasted in chat). http://t.co/7cI6Gjy5pq\"");
	}
}
