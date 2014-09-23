package com.sillycat.analyzerjava.service.impl;

import java.io.IOException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.annotate.JsonSerialize.Inclusion;

import com.sillycat.analyzerjava.service.JSONMapperHero;
import com.sillycat.analyzerjava.service.base.BaseHero;

/**
 * JSON mapper based on jackson
 * 
 * @author sillycat
 */
public class JSONMapperHeroJacksonImpl<T> extends BaseHero implements JSONMapperHero<T> {

	private ObjectMapper jsonMapper;

	/**
	 * will be called by spring framework
	 */
	@SuppressWarnings("unused")
	private void init() {
		log.debug("init the jackson mapping.");
		jsonMapper = new ObjectMapper();
		log.debug("hide the null objects during JSON Mapping");
		jsonMapper.setSerializationInclusion(Inclusion.NON_NULL);
	}

	/**
	 * mapping the object to JSON String
	 */
	public String toJSON(T objClass) {
		String result = null;
		try {
			log.debug("===============================================");
			log.debug("mapping the object:" + objClass.toString());
			result = jsonMapper.writeValueAsString(objClass);
			log.debug("mapping the string:" + result);
		} catch (JsonGenerationException e) {
			log.error("Exception:" + e);
		} catch (JsonMappingException e) {
			log.error("Exception:" + e);
		} catch (IOException e) {
			log.error("Exception:" + e);
		}
		return result;
	}

}
