package com.streamlinity.ct.restService.challenge;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.streamlinity.ct.model.Item;

import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.annotation.PostConstruct;

/*
 * Provide your implementation of the SearchSvcImpl here.
 * Also annotate your methods with Rest end point wrappers as required in the problem statement
 *
 * You can create any auxiliary classes or interfaces in this package if you need them.
 *
 * Do NOT add annotations as a Bean or Component or Service.   This is being handled in the custom Config class
 * PriceAdjustConfiguration
 */


public class SearchSvcImpl implements SearchSvcInterface {
	
	
	private List<Item> itemsInMemory;
	
	private ObjectMapper mapper;
	
	@PostConstruct
	public void init() {
		this.mapper = new ObjectMapper();
	}
    @Override
    public void init(String itemPriceJsonFileName) {
      try {
		this.itemsInMemory =  mapper.readValue(itemPriceJsonFileName, new TypeReference() {});
	  } catch (IOException e) {
		e.printStackTrace();
	  }
    }

    @Override
    public void init(File itemPriceJsonFile) {

    	try {
    		this.itemsInMemory =  mapper.readValue(itemPriceJsonFile, new TypeReference() {});
    	  } catch (IOException e) {
    		e.printStackTrace();
    	  }
    }

    @Override
    public List<Item> getItems() {
        return null;
    }

    @Override
    public List<Item> getItems(String category) {
        return null;
    }

    @Override
    public List<Item> getItem(String itemShortName) {
        return null;
    }
}
