package com.sillycat.analyzerjava.service;

import java.util.concurrent.Callable;

/**
 * 
 * @author sillycat
 *
 */
public interface CacheHero {
	
	public Object load(String key, Callable<?> callable);
	
}
