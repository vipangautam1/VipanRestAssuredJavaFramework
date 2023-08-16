package com.qa.gorest.tests;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.gorest.base.BaseTest;
import com.qa.gorest.client.RestClient;
import com.qa.gorest.constants.APIHttpsStatus;
import com.qa.gorest.pojo.User;
import com.qa.gorest.utils.StringUtils;

public class APISchemaValidationTest extends BaseTest {
	@BeforeMethod
	public void getUserSetUp() {
		restClient = new RestClient(prop, baseURI);
	} 
	
	@Test(enabled = true, description = "validate schema")
	public void createUserAPISchemaTest() {
		//post 
		User user = new User("TomJerry", StringUtils.getRandomEmailId(),"male" ,"active");
		restClient.post(GOREST_ENDPOINT, "json", user, true,true)
				.then().log().all()
					.assertThat()
						.statusCode(APIHttpsStatus.CREATED_201.getCode())
						.body(matchesJsonSchemaInClasspath("createuser.json"));

			
		
	}
}
