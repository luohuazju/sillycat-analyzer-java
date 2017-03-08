package com.sillycat.analyzerjava;

import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.ConcurrentUpdateSolrClient;
import org.apache.solr.common.SolrInputDocument;

public class SolrMainApp {

	public static void main(String[] args) throws SolrServerException, IOException {

		System.out.println("-----------------start job-------------");
		
		long start = System.currentTimeMillis();
		String solrURL = "http://172.23.2.245:8983/job";
		ExecutorService executorService = 
				  new ThreadPoolExecutor(50, 200, 0L, TimeUnit.MILLISECONDS,   
				  new LinkedBlockingQueue<Runnable>());
		SolrClient solrClient = new ConcurrentUpdateSolrClient.Builder(solrURL)
			.withThreadCount(100)
			.withQueueSize(1000)
			.withExecutorService(executorService).build();
		
		for(int i = 1;i<50000; i++){
			SolrInputDocument doc = new SolrInputDocument();
			doc.addField("id", i);
			doc.addField("customer_id", "1");
			doc.addField("pool_id", 9528);
			doc.addField("source_id", 1);
			doc.addField("campaign_id", 1);
			doc.addField("segment_id", 1);
			doc.addField("job_reference", "referenceId1");
			doc.addField("title", "title1");
			doc.addField("description", "COMMERCIAL ROOFING SALESMEN, ESTIMATORS & INSTALLERS <br /> <br /> <br />Tired of living on a small draw and commission when you know the business inside out? <br /> <br />Been waiting for the opportunity to run your own show? <br /> <br />Well now you can. And withthe backing of an 82-year old leader in the business. <br /> <br />Company Description: <br /> <br />Southwestern Petroleum Corporation is a Texas-based oil company founded in 1933. Our ISO 9001 certified Coating Technology Division manufactures a full line of industrial and commercial protective coatings and waterproofing systems at manufacturing facilities in the US, Canada and Belgium. We pride ourselves on our track record of helping motivated people establish successful building maintenance companies in 75 countries around the world. <br /> <br /> Total independence be your own boss sell when where and how you want <br /> Keep all the profit from the jobs you sell <br /> Our top people earn six figures consistently <br /> Uncapped, industry leading product commission rate plus high margin profit on installation <br /> Competitive, world-class, industry leading products & systems <br /> Professional factory & ongoing training <br /> Responsive, experienced sales, marketing & technical support <br /> Financially stable, 82-year old private family-owned business <br /> <br />Why Our Company Is Unique: <br /> <br /> Our company was started by sales professionals <br /> Our sales professionals earn the highest commissions in our industry <br /> Our sales program offers true independence and freedom from sales quotas, reports and collections <br /> We treat our sales professionals with respect and integrity and dont downsize their territories or reduce their commissions when they start earning too much <br /> We provide sales tools to make your sales job easier <br /> We provide software tools to cut the paperwork and get more impressive estimates/proposals out fast <br /> Many of our sales professionals have been with us for 20, 30, 40 years and more <br /> Our sales professionals represent the best protective coatings and waterproofing systems in the world, used by Customers like Goodyear, Kraft, Hilton, O'Reilly Auto Parts, Siemens, Honeywell, General Electric, Nestle, Intercontinental Hotels, British Petroleum, Bosch, DuPont, Toyota, Hewlett Packard, Sheraton, Bridgestone, Ingersoll-Rand, Sara Lee and thousands of smaller businesses who demand the best <br /> Our sales professionals enjoy the security and sales potential of a vast, diversified market virtually every commercial, industrial or institutional building has a need for our products hotels, office buildings, manufacturing plants, apartment buildings, government buildings, airports, universities, food stores, shopping centers, hospitals, warehouses, garages, barns, stadiums, storage facilities, distribution centers and terminals and every other type of building you can think of <br /> <br />You Will Be a Perfect Fit for Our Company If: <br /> <br /> You are experienced in sales and enjoy helping business people solve problems and save money <br /> You would like the independence of owning your own business <br /> You prefer to sell a quality product you can be proud of instead of the cheapest one available <br /> You don't like paperwork and don't really need a boss to tell you what to do <br /> You are super competitive, hate losing at anything and prefer setting your own goals instead of dealing with company quotas or call reports <br /> You are a problem solver, good at overcoming obstacles <br /> You are confident in your abilities, make friends easily and have a great sense of humor <br /> You are organized and manage time well enough to work from a home office <br /> You can be demanding at times because you insist on excellent service from the company you represent <br /> You know how important high activity levels are to sales success <br /> You don't mind working hard and getting your hands dirty, if it translates into income <br /> You prefer to spend your days working with prospects and Customers instead of sitting in an office <br /> You would like more control over your own future <br /> You know you are capable of earning much more if given the right training, support and freedom to do it your way <br /> <br />Qualifications: <br /> <br /> Minimum 1 year of successful business to business sales experience <br /> Background in roofing, flooring, paving, construction materials, construction trades, engineering or contracting a plus <br /> <br />If you would like to know more about taking that first step towards financial independence and a secure future, please respond with your name, city, state and email address.");
			doc.addField("url", "http://url1");
			doc.addField("company_id", 1);
			doc.addField("company", "company1");
			doc.addField("cities", "austin");
			doc.addField("cities", "dallas");
			doc.addField("cpc", 12);
			doc.addField("reg_cpc",10);
			doc.addField("posted","2016-06-23T22:00:00Z");
		    doc.addField("created","2016-05-23T22:00:00Z");
		    doc.addField("experience", 1);
		    doc.addField("salary", 1);
		    doc.addField("education", 1);
		    doc.addField("jobtype", 1);
		    doc.addField("industry", 1);
		    doc.addField("quality_score", 1.0);
		    doc.addField("boost_factor",1.0);
		    doc.addField("paused", false);
		    doc.addField("budget", 100);
		    doc.addField("email", "cluo@jobs2careers.com");
		    doc.addField("phone", "5127850000");
		    doc.addField("srcseg_id", 1);
		    doc.addField("srccamp_id", 1);
		    doc.addField("tags", "tag1");
		    doc.addField("tags", "tag2");
		    doc.addField("searchtags", "searchtags1");
		    doc.addField("searchtags", "searchtags2");
		    doc.addField("daily_capped", false);
		    doc.addField("qq_multiplier", 1.2);
		    doc.addField("j2c_apply", false);
		    doc.addField("reranker_info" , "rerankerInfo1");
		    doc.addField("major_category","100016");
		    doc.addField("major_category", "100017");
		    doc.addField("minor_category", "100016");
		    doc.addField("minor_category", "111017");
		    doc.addField("excluded_company", false);
			solrClient.add(doc);
			if(i%100 == 0){
				System.out.println("process " + i + "/50000");
			}
		}
		
		long end = System.currentTimeMillis();
		
		System.out.println("total time is " + (end - start) + " ms");
		System.out.println("total time is " + 50000 * 1000 / (end - start) + " jobs/s");
		solrClient.commit();
	}

}
