package com.sillycat.analyzerjava.model;

import java.util.List;

/**
 * Content labels parsed from the content
 * @author sillycat
 */
public class ContentLabel {
	
	private List<String> mentions;
	
	private List<String> emoticons;
	
	private List<LinkLabel> links;

	public List<String> getMentions() {
		return mentions;
	}

	public void setMentions(List<String> mentions) {
		this.mentions = mentions;
	}

	public List<String> getEmoticons() {
		return emoticons;
	}

	public void setEmoticons(List<String> emoticons) {
		this.emoticons = emoticons;
	}

	public List<LinkLabel> getLinks() {
		return links;
	}

	public void setLinks(List<LinkLabel> links) {
		this.links = links;
	}

	@Override
	public String toString() {
		return "ContentLabel [mentions=" + mentions + ", emoticons="
				+ emoticons + ", links=" + links + "]";
	}
	
}
