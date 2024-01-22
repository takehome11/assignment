package com.test.infinite.common.utility;

import com.jayway.jsonpath.JsonPath;
import io.restassured.response.Response;
import net.minidev.json.JSONArray;

public class RespUtils {

	Response response = null;
	String pathToProductTypeAll = "$.loansInReview.[*].productType";
	String pathToItems = "$.items[*].title";
	String pathToItem = "$.items[0].title";

	public RespUtils(Response rest) {
		this.response = rest;
	}

	public int getStatusCode() {
		return response.getStatusCode();
	}

	public String getResponse() {
		if(this.response != null) {
			return response.asString();
		}
		return null;
	}

	public JSONArray getProductType() {
		JSONArray records = (JSONArray) JsonPath.read(getResponse(), pathToProductTypeAll);
		return records;
	}
	
	public JSONArray getResults() {
		JSONArray records = (JSONArray) JsonPath.read(getResponse(), pathToItems);
		return records;
	}
	
	public String getResult() {
		String record = JsonPath.read(getResponse(), pathToItem);
		System.out.println("record: "+record);
		return record;
	}
	
	public boolean verifyAllProductType() {
		JSONArray records = getProductType();
		boolean found = false;
		for (int i = 0; i < records.size(); i++) 
			if (records.get(i).equals("PERSONAL_LOAN"))
				found = true;
		return found;
	}
	
	public boolean verifyAllResults(String searchTerm) {
		JSONArray records = getResults();
		System.out.println("records.size(): "+records.size());
		boolean found = false;
		for (int i = 0; i < records.size(); i++) {
			System.out.println("each record: "+records.get(i).toString().toLowerCase());
			if (records.get(i).toString().toLowerCase().equals(searchTerm))
				found = true;
		}
		return found;
	}
	
	public boolean verifyResult(String searchTerm) {
		boolean b = true;
		b = getResult().toLowerCase().contains(searchTerm);
		return b;
		
	}
}
