package com.sillycat.analyzerjava.service;

public interface JSONMapperHero<T> {
	
	/**
	 * convert that object into JSON string
	 * @param objClass
	 * @return
	 */
	public String toJSON(T objClass);
	
}
