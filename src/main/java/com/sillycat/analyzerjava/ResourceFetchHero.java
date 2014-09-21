package com.sillycat.analyzerjava;

/**
 * Just a simple class to fetch the Title from URL
 * @author sillycat
 *
 */
public interface ResourceFetchHero {

	/**
	 * Fetch the title of the URL, return "" if it fails to get one
	 * @param url
	 * @return title of the content
	 */
	public String getTitlefromURL(String url);
	
	
}
