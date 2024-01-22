package com.test.infinite.common.utility;

import static io.restassured.RestAssured.*;
import io.restassured.response.Response;

public class RestClientHelper{
	
	public RespUtils get(String path, String query) {
		
		Response resp =
		given().log().all().
			queryParams("key", "AIzaSyBBnXdl5jLBS_XwgY88cgqvrW4NabVTJG0").
			queryParam("cx", "17b11cafad78d4ea9").
			queryParam("q", query).
		when().
			get(path).
		then().
			assertThat().statusCode(200).log().all().extract().response();

		return new RespUtils(resp);
	}

}
