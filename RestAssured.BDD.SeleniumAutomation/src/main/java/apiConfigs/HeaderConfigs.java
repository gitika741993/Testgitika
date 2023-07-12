package apiConfigs;

import java.util.HashMap;
import java.util.Map;

public class HeaderConfigs {

	public Map<String, String> defalutHeaders()
	{
		Map<String, String> defaultHeaders = new HashMap<String, String>(); 
		defaultHeaders.put("Content-Type", "application/json");	
		return defaultHeaders;
		
		
	}
	
	public Map<String, String> headersWithToken()
	{
		Map<String, String> defaultHeaders = new HashMap<String, String>(); 
		defaultHeaders.put("Content-Type", "application/json");	
		defaultHeaders.put("Access_Token", "whgeuwiwjiwjiq");
		defaultHeaders.put("jwt_token", "tokenjwt");	
		defaultHeaders.put("Tenet_user", "test");
		return defaultHeaders;
		
		
	}
	
}
