package com.sillycat.analyzerjava;

import junit.framework.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)  
@ContextConfiguration(locations = {"file:src/test/resources/test-context.xml" }) 
public class AnalyzerHeroTest {

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
		//TODO
		Assert.assertTrue(true);
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
     *         "title": "NBC Olympics | 2014 NBC Olympics in Sochi Russia"
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

