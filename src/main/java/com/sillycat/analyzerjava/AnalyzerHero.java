package com.sillycat.analyzerjava;

/**
 * Analyze the string based on certain pattern to required JSON content
 * @author sillycat
 *
 */
public interface AnalyzerHero {

	/**
	 * 1. @mentions - A way to mention a user. 
	 * Always starts with an '@' and ends when hitting a non-word character. 
	 * (http://help.hipchat.com/knowledgebase/articles/64429-how-do-mentions-work-)
	 * 
	 * 2. Emoticons - 
	 *    For this exercise, you only need to consider 'custom' emoticons which are ASCII strings, 
	 *    no longer than 15 characters, contained in parenthesis. 
	 *    You can assume that anything matching this format is an emoticon. 
	 *    (http://hipchat-emoticons.nyh.name)
	 * 
	 * 3. Links - Any URLs contained in the message, along with the page's title.
	 * 
	 * @param sourceString, Just normal string contains certain pattern
	 * @return JSON content
	 */
	public String analyzerAll(String sourceString);
	
}
