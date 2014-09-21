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
public class ResourceFetchHeroTest {
	
	@Autowired  
    @Qualifier("resourceFetchHero")  
    private ResourceFetchHero resourceFetchHero; 
	
	/**
	 * "url": "http://www.nbcolympics.com",
     * "title": "NBC Olympics | 2014 NBC Olympics in Sochi Russia"
     * Just fetch the title from homepage
	 */
	@Test
	public void homepage(){
		//TODO
		Assert.assertTrue(true);
	}
	
	/**
	 * "url": "https://twitter.com/jdorfman/status/430511497475670016",
     * "title": "Twitter / jdorfman: nice @littlebigdetail from ..."
	 */
	@Test
	public void detailpage(){
		//TODO
		Assert.assertTrue(true);
	}
}
