package com.qa.gorest.tests;

import java.util.HashMap;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import static org.hamcrest.Matchers.equalTo;
import com.qa.gorest.base.BaseTest;
import com.qa.gorest.client.RestClient;
import com.qa.gorest.constants.APIHttpsStatus;

import io.qameta.allure.Description;


public class GetUserTest extends BaseTest {
	@BeforeMethod
	public void getUserSetUp() {
		restClient = new RestClient(prop, baseURI);
	}
	@Description("This test is in progress")//-- this annotation coming from allure
	@Test(enabled = true , priority=3 , description ="This test is in progress" )
	public void getAllUsersTest() {
		
		restClient.get(GOREST_ENDPOINT,true, true)
			.then().log().all()
				.assertThat()
					.statusCode(APIHttpsStatus.OK_200.getCode());
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>");
	}
	
	@Test(enabled = true ,priority = 2)
	public void getSpecificUserTest() {
		restClient.get(GOREST_ENDPOINT+ 4478859,true, true)
			.then().log().all()
				.assertThat()
					.statusCode(APIHttpsStatus.OK_200.getCode())
						.and()
							.body("id", equalTo(4478859));
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>");
	}
	@Test(enabled = true, priority=1)
	public void getAllUserWithQueryParamsTest() {
		HashMap<String, String> queryParams = new HashMap<String, String>();
		queryParams.put("status", "active");
		queryParams.put("name", "Rita Shah");
		restClient.get(GOREST_ENDPOINT, null, queryParams, true, true)
			.then().log().all()
				.assertThat()
					.statusCode(APIHttpsStatus.OK_200.getCode());
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>");
						
								
	}

}
