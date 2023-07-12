package restAssuredTests;

import org.testng.annotations.BeforeClass;
import io.restassured.RestAssured;
//import io.restassured.specification.RequestSpecification;
import utils.FileAndEnvironment;


public class BaseTest {

	@BeforeClass
	public void baseTest()
	{
				 
		RestAssured.baseURI= FileAndEnvironment.envAndFile().get("ServerUrl");
		
	}

	
	
}
