package com.qa.gorest.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import static org.hamcrest.Matchers.equalTo;

import com.qa.gorest.base.BaseTest;
import com.qa.gorest.client.RestClient;
import com.qa.gorest.constants.APIHttpsStatus;
import com.qa.gorest.pojo.User;
import com.qa.gorest.utils.StringUtils;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

public class CreateUserTest extends BaseTest {
	@BeforeMethod
	public void getUserSetUp() {
		restClient = new RestClient(prop, baseURI);
	}
	@DataProvider
	public Object [][] getUserTestData() {
		return new Object[][] {
			{"AbeerBansh","male","Active"},
			{"SantandarBank","female","Active"},
			{"JanamMasoom","Male","inactive"}
		};
	}
	
	@Test(enabled = true, dataProvider = "getUserTestData")
	public void createUserTest(String name, String gender,String status) {
		//post 
		User user = new User(name, StringUtils.getRandomEmailId(),gender ,status);
		Integer userId = restClient.post(GOREST_ENDPOINT, "json", user, true,true)
				.then().log().all()
					.assertThat()
						.statusCode(APIHttpsStatus.CREATED_201.getCode())
								.extract().path("id");
		System.out.println("User Id " + userId);
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>.");
		
		//GET
		RestClient ClientGet= new RestClient(prop, baseURI);
		ClientGet.get(GOREST_ENDPOINT+userId, true,true)
		.then().log().all()
		.assertThat().statusCode(APIHttpsStatus.OK_200.getCode())
		.assertThat()
		.body("id", equalTo(userId));
			
		
	}
	
	

}
