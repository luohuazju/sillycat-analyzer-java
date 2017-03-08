package com.sillycat.analyzerjava.service.impl;

import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.impl.ConcurrentUpdateSolrClient;
import org.apache.solr.common.SolrInputDocument;

import com.sillycat.analyzerjava.service.SolrClientHero;


public class SolrJClientHeroImpl implements SolrClientHero {
	
	
	private SolrClient solrClient = null;
	
	public void init(){
		this.solrClient = new ConcurrentUpdateSolrClient("",100000,100);
	}
	
	
	public void addDocuments(){
		SolrInputDocument doc = new SolrInputDocument();
		doc.addField("id", "9527");
		
	}

}
