package com.xdf.femisnsb.service;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

@Service
public class MyJsonMapper extends ObjectMapper {

	/**
	 * 
	 */ 
	private static final long serialVersionUID = 1L;
	

	public MyJsonMapper(){
		this.setSerializationInclusion(JsonInclude.Include.NON_NULL);
		this.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS,false);
	}
}
