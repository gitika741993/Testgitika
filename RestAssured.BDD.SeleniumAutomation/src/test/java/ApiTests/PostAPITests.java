package ApiTests;

import org.testng.annotations.Test;

import apiBuilders.PostAPIBuilder;
import apiConfigs.ApiPath;
import apiConfigs.HeaderConfigs;
import apiVerifications.APIVerification;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import restAssuredTests.BaseTest;
import utils.JavaUtils;


public class PostAPITests extends BaseTest {
	
	@Test
	public void validPostAPITest()
	{
		HeaderConfigs header = new HeaderConfigs();
		PostAPIBuilder builder = new PostAPIBuilder();
	
				
		Response response= RestAssured.given().when().headers(header.defalutHeaders())
		.body(builder.postRequestBody(JavaUtils.randomNumber(),JavaUtils.randomString(),JavaUtils.randomString())).when().post(ApiPath.apiPath.CreatePost);
		
		
		APIVerification.responseCodeValidation(response,response.getStatusCode());
		APIVerification.responsekeyValidationFromJSONObject(response, "title");
		APIVerification.responseTimeValidation(response);
		
		System.out.println(response.getBody().asString());
		System.out.println(response.getStatusCode());
		
		 
		 
	}

}
