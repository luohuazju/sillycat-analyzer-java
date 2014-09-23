package com.sillycat.analyzerjava.model;


/**
 * Link and related info
 * @author sillycat
 */
public class LinkLabel {

	private String url;
	
	private String title;
	
	public LinkLabel(){
		
	}
	
	public LinkLabel(String url, String title){
		this.url = url;
		this.title = title;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Override
	public String toString() {
		return "LinkLabel [url=" + url + ", title=" + title + "]";
	}
	
}
