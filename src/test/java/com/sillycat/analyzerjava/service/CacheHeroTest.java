package com.sillycat.analyzerjava.service;

import java.util.concurrent.Callable;

import junit.framework.Assert;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.sillycat.analyzerjava.base.BaseTest;

public class CacheHeroTest extends BaseTest{

	@Autowired  
    @Qualifier("cacheHero")  
    private CacheHero cacheHero;  
	
	private int flag;
	
	@Test
	public void load(){
		Assert.assertEquals(flag, 0);
		Assert.assertEquals(cacheHero.load("key1", new Callable<String>(){
			public String call() throws Exception {
				addFlag();
				return "value1";
			}
		}), "value1" );
		Assert.assertEquals(flag, 1);
		for(int i = 0;i<10; i++){
			Assert.assertEquals(cacheHero.load("key1", new Callable<String>(){
				public String call() throws Exception {
					addFlag();
					return "value1";
				}
			}), "value1" );
		}
		Assert.assertEquals(flag, 1);
	}
	
	private void addFlag(){
		flag = flag + 1;
	}
}
