package com.sillycat.analyzerjava.perf;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class DFAAnalyzerBenchmark extends PerfTestApp {

	protected final static Log log = LogFactory
			.getLog(DFAAnalyzerBenchmark.class);

	public static void main(String args[]) {
		log.info("==========================================");
		log.info("DFA Perf");
		rockAndRoll(log, "dfa-perf-context.xml",1000 * 1000);
		log.info("===========================================");
	}
}
