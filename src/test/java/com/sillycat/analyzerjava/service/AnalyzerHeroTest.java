//package com.sillycat.analyzerjava.service;
//
//import junit.framework.Assert;
//
//import org.junit.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
//
//import com.sillycat.analyzerjava.base.BaseTest;
//
//
//public class AnalyzerHeroTest extends BaseTest{
//
//	@Autowired  
//    @Qualifier("analyzerHero")  
//    private AnalyzerHero analyzerHero;  
//	
//	/**
//	 * Input: "@chris you around?"
//	 * Return (string):
//	 * {
//  	 *   "mentions": [
//     *      "chris"
//     *   ]
//     * }
//	 */
//	@Test
//	public void mentionsOnly(){
//		Assert.assertEquals(jsonstring_mentions, analyzerHero.analyzerAll(rawstring_mentions));
//	}
//	
//	/**
//	 * Input: "Good morning! (megusta) (coffee)"
//	 * Return (string):
//     * {
//  	 *    "emoticons": [
//     *       "megusta",
//     *       "coffee"
//     *      ]
//     * }
//	 */
//	@Test
//	public void emoticonsOnly(){
//		Assert.assertEquals(jsonstring_emoticons, analyzerHero.analyzerAll(rawstring_emoticons));
//	}
//	
//	/**
//	 * Input: "Olympics are starting soon; http://www.nbcolympics.com"
//     * Return (string):
//     * {
//     *    "links": [
//     *       {
//     *         "url": "http://www.nbcolympics.com",
//     *         "title": "NBC Olympics | Home of the 2016 Olympic Games in..."
//     *       }
//     *    ]
//     * }
//	 */
//	@Test
//	public void urlsOnly(){
//		Assert.assertEquals(jsonstring_links, analyzerHero.analyzerAll(rawstring_links));
//	}
//
//	/**
//	 * Input: "@bob @john (success) such a cool feature; https://twitter.com/jdorfman/status/430511497475670016"
//     * Return (string):
//     * {
//     *   "mentions": [
//     *      "bob",
//     *      "john"
//     *    ],
//     *   "emoticons": [
//     *      "success"
//     *    ]
//     *   "links": [
//     *     {
//     *       "url": "https://twitter.com/jdorfman/status/430511497475670016",
//     *       "title": "Justin Dorfman on Twitter: "nice @littlebigdetai..."
//     *     }
//     *   ]
//     * }
//	 */
//	@Test
//	public void all(){
//		Assert.assertEquals(jsonstring_all, analyzerHero.analyzerAll(rawstring_all));
//	}
//	
//}
//
