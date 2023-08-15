package com.qa.gorest.tests;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.jayway.jsonpath.JsonPath;
import com.qa.gorest.base.BaseTest;
import com.qa.gorest.client.RestClient;
import com.qa.gorest.constants.APIHttpsStatus;
import com.qa.gorest.utils.JsonPathValidator;

import io.restassured.response.Response;

public class CircuitTest extends BaseTest {
	@BeforeMethod
	public void getUserSetUp() {
		restClient = new RestClient(prop, baseURI);
	}
	@Test
	public void getAllUsersTest() {
	Response jsonResponse =	restClient.get(CIRCUIT_ENDPOINT +"/2017/circuits.json",false, true);
	
	JsonPathValidator js = new JsonPathValidator();
			
	List<String> countryList =	js.readList(jsonResponse, "$.MRData.CircuitTable.Circuits[?(@.circuitId == 'shanghai')].Location.country");
		System.out.println("countryList: "+countryList);
		Assert.assertTrue(countryList.contains("China"));
	}
	@Test
	public void getAllUsersTest2() {
	Response circuitResponse =	restClient.get(CIRCUIT_ENDPOINT +"/2017/circuits.json",false, true);
	
	circuitResponse.then()
						.assertThat()
							.statusCode(APIHttpsStatus.OK_200.getCode())
								.and()
									.header("Connection", "keep-alive");
			
	}

}
