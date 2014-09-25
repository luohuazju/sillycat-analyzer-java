package com.sillycat.analyzerjava.perf;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class SingleRegexAnalyzerBenchmark extends PerfTestApp {

	protected final static Log log = LogFactory
			.getLog(SingleRegexAnalyzerBenchmark.class);

	public static void main(String args[]) {
		log.info("==========================================");
		log.info("Single Regex Perf");
		rockAndRoll(log, "singleregex-perf-context.xml",1000 * 1000);
		log.info("===========================================");
	}

}
