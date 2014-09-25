package com.sillycat.analyzerjava.perf;

import org.apache.commons.logging.Log;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sillycat.analyzerjava.service.AnalyzerHero;

public abstract class PerfTestApp {

	protected static AnalyzerHero analyzerHero;

	protected static String jsonstring_all;

	protected static String rawstring_all;

	public static void setup(String fileName) {
		final ApplicationContext context = new ClassPathXmlApplicationContext(
				fileName);
		analyzerHero = (AnalyzerHero) context.getBean("analyzerHero");

		rawstring_all = "@bob @john (success) such a cool feature; https://twitter.com/jdorfman/status/430511497475670016";
		jsonstring_all = "{"
				+ "\"mentions\":[\"bob\",\"john\"],"
				+ "\"emoticons\":[\"success\"],"
				+ "\"links\":["
				+ "{"
				+ "\"url\":\"https://twitter.com/jdorfman/status/430511497475670016\","
				+ "\"title\":\"Justin Dorfman on Twitter: \\\"nice @littlebigdetai...\""
				+ "}" + "]" + "}";
	}

	public static void rockAndRoll(Log log, String confFile, int numbers) {
		long start = System.currentTimeMillis();
		setup(confFile);
		long end = System.currentTimeMillis();
		long time1 = (end - start);
		log.info("Init the ENV in " + time1 + " ms");

		start = System.currentTimeMillis();
		analyzerHero.analyzerAll(rawstring_all);
		end = System.currentTimeMillis();
		long time2 = (end - start);
		log.info("First Analyzer Hero Test Done in " + time2 + " ms");

		start = System.currentTimeMillis();
		for (int i = 0; i < numbers; i++) {
			analyzerHero.analyzerAll(rawstring_all);
		}
		end = System.currentTimeMillis();
		long time3 = (end - start);
		log.info(numbers + " Analyzer Hero Test Done in " + time3 + " ms");
	}

}
