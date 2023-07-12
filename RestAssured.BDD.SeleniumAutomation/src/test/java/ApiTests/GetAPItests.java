package ApiTests;

/*import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.annotations.Listeners;*/
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import apiConfigs.ApiPath;
import apiVerifications.APIVerification;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import restAssuredTests.BaseTest;
import utils.TestListeners;

public class GetAPItests extends BaseTest{

	@Test
	public void getAPITest()
	{
		   TestListeners.test.log(Status.INFO, "Test Started");
		   Response response = RestAssured.given().when().get(ApiPath.apiPath.GetListOfPosts);
		   APIVerification.responseCodeValidation(response,200);
		   APIVerification.responseTimeValidation(response);
		   APIVerification.responsekeyValidationArray(response,"id");
	
}}
