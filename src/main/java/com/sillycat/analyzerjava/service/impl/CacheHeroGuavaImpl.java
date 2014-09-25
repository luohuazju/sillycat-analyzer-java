package com.sillycat.analyzerjava.service.impl;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.sillycat.analyzerjava.service.CacheHero;
import com.sillycat.analyzerjava.service.base.BaseHero;

public class CacheHeroGuavaImpl extends BaseHero implements CacheHero {

	Cache<String, Object> localCache;

	@SuppressWarnings("unused")
	private void init() {
		localCache = CacheBuilder.newBuilder()
				.expireAfterWrite(24, TimeUnit.HOURS).build();
	}

	public Object load(String key, Callable<?> callable) {
		try {
			return localCache.get(key, callable);
		} catch (ExecutionException e) {
			log.error("Exception:" + e);
		}
		return null;
	}

}
