package com.test.infinite;

import org.apache.http.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.test.infinite.base.BaseTest;
import com.test.infinite.base.Path;
import com.test.infinite.common.utility.RespUtils;
import com.test.infinite.common.utility.RestClientHelper;


public class TakeHomeTest extends BaseTest{	

	RestClientHelper restClientHelper = new RestClientHelper();
	
	@Test (groups="regression")
	public void testSearchFirstItem() {	

		String query = "iphone 15 pro";
		RespUtils apiResponse = restClientHelper.get(Path.SEARCH, query);
		Assert.assertEquals(apiResponse.getStatusCode(), HttpStatus.SC_OK);
		Assert.assertTrue(apiResponse.verifyResult("iphone 15 pro"));
	}
	
	@Test (groups="regression")
	public void testSearchAllItems() {	

		String query = "iphone 15 pro";
		RespUtils apiResponse = restClientHelper.get(Path.SEARCH, query);
		Assert.assertEquals(apiResponse.getStatusCode(), HttpStatus.SC_OK);
		Assert.assertTrue(apiResponse.verifyAllResults("iphone 15 pro"));
	}
	
}
