package com.sillycat.analyzerjava;

import java.io.IOException;

import org.apache.solr.client.solrj.SolrServerException;

import com.sillycat.analyzerjava.perf.DFAAnalyzerBenchmark;
import com.sillycat.analyzerjava.perf.SeparateRegexAnalyzerBenchmark;
import com.sillycat.analyzerjava.perf.SingleRegexAnalyzerBenchmark;

public class ExecutorApp {

	public static void main(String[] args) throws SolrServerException, IOException {
		/*
		 * Regex may not match all the requirement in the future
		 */
		SingleRegexAnalyzerBenchmark.main(args);
		SeparateRegexAnalyzerBenchmark.main(args);
		
		/**
		 * DFA, put all the keyword in the dictionary
		 */
		DFAAnalyzerBenchmark.main(args);
		//SolrMainApp.main(args);
	}

}
