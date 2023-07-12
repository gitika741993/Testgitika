package ApiTests;

import org.testng.annotations.Test;

import apiConfigs.ApiPath;
import apiConfigs.HeaderConfigs;
import io.restassured.RestAssured;
import pojo.PostAPIPojo;
import restAssuredTests.BaseTest;
import utils.JavaUtils;
import io.restassured.response.Response;

public class SerializiationTests extends BaseTest {

	@Test
	public void SerTest()
	{
		HeaderConfigs header = new HeaderConfigs();
		PostAPIPojo pojo = new PostAPIPojo(JavaUtils.randomNumber(),JavaUtils.randomString(),JavaUtils.randomString());
		
		
		System.out.println(pojo.toString());
		Response response = RestAssured.given().when().headers(header.defalutHeaders()).body(pojo).post(ApiPath.apiPath.CreatePost);
		System.out.println(response.getBody().asString());
		System.out.println(pojo.getId());
		System.out.println(pojo.getAuthor());
		System.out.println(pojo.getTitle());
	}
	
}
