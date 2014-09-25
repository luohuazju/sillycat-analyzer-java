package com.sillycat.analyzerjava.perf;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class SeparateRegexAnalyzerBenchmark extends PerfTestApp {

	protected final static Log log = LogFactory
			.getLog(SeparateRegexAnalyzerBenchmark.class);

	public static void main(String args[]) {
		log.info("==========================================");
		log.info("Separate Regex Perf");
		rockAndRoll(log, "separateregex-perf-context.xml",1000 * 1000);
		log.info("===========================================");
	}

}
