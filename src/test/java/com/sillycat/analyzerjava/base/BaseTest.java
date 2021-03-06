package com.sillycat.analyzerjava.base;

import java.util.Arrays;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.sillycat.analyzerjava.model.ContentLabel;
import com.sillycat.analyzerjava.model.LinkLabel;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/test/resources/test-context.xml" })
public abstract class BaseTest {

	protected final Log log = LogFactory.getLog(this.getClass());

	protected String jsonstring_mentions;
	protected String jsonstring_emoticons;
	protected String jsonstring_links;
	protected String jsonstring_all;

	protected String rawstring_mentions;
	protected String rawstring_emoticons;
	protected String rawstring_links;
	protected String rawstring_all;

	protected ContentLabel obj_mentions;
	protected ContentLabel obj_emoticons;
	protected ContentLabel obj_links;
	protected ContentLabel obj_all;

	@Before
	public void setUp() {
		rawstring_mentions = "@chris you around?";
		jsonstring_mentions = "{" + "\"mentions\":[\"chris\"]" + "}";
		obj_mentions = new ContentLabel();
		obj_mentions.setMentions(Arrays.asList("chris"));

		rawstring_emoticons = "Good morning! (megusta) (coffee)";
		jsonstring_emoticons = "{" + "\"emoticons\":[\"megusta\",\"coffee\"]"
				+ "}";
		obj_emoticons = new ContentLabel();
		obj_emoticons.setEmoticons(Arrays.asList("megusta", "coffee"));

		rawstring_links = "Olympics are starting soon; http://www.nbcolympics.com";
		jsonstring_links = "{"
				+ "\"links\":["
				+ "{"
				+ "\"url\":\"http://www.nbcolympics.com\","
				+ "\"title\":\"NBC Olympics | Home of the 2016 Olympic Games in...\""
				+ "}" + "]" + "}";
		obj_links = new ContentLabel();
		obj_links.setLinks(Arrays.asList(new LinkLabel(
				"http://www.nbcolympics.com",
				"NBC Olympics | Home of the 2016 Olympic Games in...")));

		rawstring_all = "@bob @john (success) such a cool feature; https://twitter.com/jdorfman/status/430511497475670016";
		jsonstring_all = "{"
				+ "\"mentions\":[\"bob\",\"john\"],"
				+ "\"emoticons\":[\"success\"],"
				+ "\"links\":["
				+ "{"
				+ "\"url\":\"https://twitter.com/jdorfman/status/430511497475670016\","
				+ "\"title\":\"Justin Dorfman on Twitter: \\\"nice @littlebigdetai...\"" + "}" + "]"
				+ "}";
		obj_all = new ContentLabel();
		obj_all.setMentions(Arrays.asList("bob", "john"));
		obj_all.setEmoticons(Arrays.asList("success"));
		obj_all.setLinks(Arrays.asList(new LinkLabel(
				"https://twitter.com/jdorfman/status/430511497475670016",
				"Justin Dorfman on Twitter: \"nice @littlebigdetai...")));
	}

}
