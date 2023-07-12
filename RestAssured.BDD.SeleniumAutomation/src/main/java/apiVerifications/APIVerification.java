package apiVerifications;


import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.Assert;
import com.aventstack.extentreports.Status;

import io.restassured.response.Response;
import utils.TestListeners;

public class APIVerification  {

	
	public static void responseCodeValidation(Response response, int statusCode)
	{
		try
		{
			Assert.assertEquals(statusCode, response.getStatusCode());
			System.out.println(response.getStatusCode());
			TestListeners.test.log(Status.INFO,String.valueOf(response.getStatusCode()));
			
			
			
		}
		catch(Exception e)
		{
			
			
		}
	}
	public static void responsekeyValidationArray(Response response, String key)
	{
		try
		{
			JSONArray array = new JSONArray(response.getBody().asString());
			
			for(int i = 0; i< array.length();i++)
			{
				JSONObject obj = array.getJSONObject(i);
				System.out.println(obj.get("id"));
				TestListeners.test.log(Status.PASS,"Validated values are:"+obj.get(key)); 
			}
		
		}
		catch(Exception e)
		{
			TestListeners.test.log(Status.FAIL,e.fillInStackTrace()); 
			
		}
	}
	
	public static void responsekeyValidationFromJSONObject(Response response, String key)
	{
		try
		{
			JSONObject obj = new JSONObject(response.getBody().asString());
			
			if(obj.has(key)&& obj.get(key)!=null)
			{
				
				TestListeners.test.log(Status.INFO, "Object key is validated"+key+ "Value is:"+obj.get(key));
			}	
			else {
				
				TestListeners.test.log(Status.FAIL,"Key is not available");
			}
		
		}
		catch(Exception e)
		{
			TestListeners.test.log(Status.FAIL,e.fillInStackTrace()); 
			
		}
	}
	
	public static void responseTimeValidation(Response response)
	{
		try
		{
			long time = response.time();
			TestListeners.test.log(Status.INFO, "API time taken is:"+time);
			
		}
		catch(Exception e)
		{
			TestListeners.test.log(Status.FAIL,e.fillInStackTrace()); 
		}
		
	}
	}
