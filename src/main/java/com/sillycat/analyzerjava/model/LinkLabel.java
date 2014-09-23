package com.sillycat.analyzerjava.model;

import com.sillycat.analyzerjava.common.Constants;

/**
 * Link and related info
 * 
 * @author sillycat
 */
public class LinkLabel {

	private String url;

	private String title;

	public LinkLabel() {

	}

	public LinkLabel(String url, String title) {
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
		if (title != null && !title.isEmpty()) {
			return title.length() > Constants.MAX_LENGTH_TITLE ? title
					.substring(0, Constants.MAX_LENGTH_TITLE)
					+ Constants.TITLE_SUFFIX : title;
		}
		return null;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Override
	public String toString() {
		return "LinkLabel [url=" + url + ", title=" + title + "]";
	}

}
