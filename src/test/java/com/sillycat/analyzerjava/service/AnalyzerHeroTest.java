package com.sillycat.analyzerjava.service;

import java.util.Arrays;

import junit.framework.Assert;

import org.codehaus.jackson.map.ObjectMapper;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.sillycat.analyzerjava.base.BaseTest;
import com.sillycat.analyzerjava.model.ContentLabel;


public class AnalyzerHeroTest extends BaseTest{

	@Autowired  
    @Qualifier("analyzerHero")  
    private AnalyzerHero analyzerHero;  
	
	/**
	 * Input: "@chris you around?"
	 * Return (string):
	 * {
  	 *   "mentions": [
     *      "chris"
     *   ]
     * }
	 */
	@Test
	public void mentionsOnly(){
		Assert.assertEquals(jsonstring_mentions, analyzerHero.analyzerAll("@chris you around?"));
	}
	
	/**
	 * Input: "Good morning! (megusta) (coffee)"
	 * Return (string):
     * {
  	 *    "emoticons": [
     *       "megusta",
     *       "coffee"
     *      ]
     * }
	 */
	@Test
	public void emoticonsOnly(){
		//TODO
		Assert.assertTrue(true);
	}
	
	/**
	 * Input: "Olympics are starting soon; http://www.nbcolympics.com"
     * Return (string):
     * {
     *    "links": [
     *       {
     *         "url": "http://www.nbcolympics.com",
     *         "title": "NBC Olympics | Home of the 2016 Olympic Games in Rio"
     *       }
     *    ]
     * }
	 */
	@Test
	public void urlsOnly(){
		//TODO
		Assert.assertTrue(true);
	}

	/**
	 * Input: "@bob @john (success) such a cool feature; https://twitter.com/jdorfman/status/430511497475670016"
     * Return (string):
     * {
     *   "mentions": [
     *      "bob",
     *      "john"
     *    ],
     *   "emoticons": [
     *      "success"
     *    ]
     *   "links": [
     *     {
     *       "url": "https://twitter.com/jdorfman/status/430511497475670016",
     *       "title": "Twitter / jdorfman: nice @littlebigdetail from ..."
     *     }
     *   ]
     * }
	 */
	@Test
	public void all(){
		//TODO
		Assert.assertTrue(true);
	}
	
}

