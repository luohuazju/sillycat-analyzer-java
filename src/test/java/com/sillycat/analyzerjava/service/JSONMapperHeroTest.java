package com.sillycat.analyzerjava.service;

import junit.framework.Assert;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.sillycat.analyzerjava.base.BaseTest;
import com.sillycat.analyzerjava.model.ContentLabel;

public class JSONMapperHeroTest extends BaseTest{

	@Autowired  
    @Qualifier("jsonMapperHero")  
    private JSONMapperHero<ContentLabel> jsonMapperHero; 
	
	/**
	 * JSON string 
	 * {
  	 *   "mentions": [
     *      "chris"
     *   ]
     * }
	 */
	@Test
	public void toJSONMentions(){
		Assert.assertEquals(jsonMapperHero.toJSON(obj_mentions),jsonstring_mentions);
	}
	
	/**
	 * JSON string
	 * {
  	 *    "emoticons": [
     *       "megusta",
     *       "coffee"
     *      ]
     * }
	 */
	@Test
	public void toJSONemoticons(){
		Assert.assertEquals(jsonMapperHero.toJSON(obj_emoticons),jsonstring_emoticons);
	}
	
	/**
	 * JSON string
	 * {
     *    "links": [
     *       {
     *         "url": "http://www.nbcolympics.com",
     *         "title": "NBC Olympics | Home of the 2016 Olympic Games in..."
     *       }
     *    ]
     * }
	 */
	@Test
	public void toJSONLinks(){
		Assert.assertEquals(jsonMapperHero.toJSON(obj_links),jsonstring_links);
	}
	
	/**
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
     *       "title": "Justin Dorfman on Twitter: "nice @littlebigdetai..."
     *     }
     *   ]
     * }
	 */
	@Test
	public void toJSON(){
		Assert.assertEquals(jsonMapperHero.toJSON(obj_all),jsonstring_all);
	}
	
	@Test
	public void toObject(){
		//TODO
		Assert.assertTrue(true);
	}
	
}
