package utils;

import java.util.Random;

import org.apache.commons.lang.RandomStringUtils;

public class JavaUtils {

	public static String randomNumber() {
	
	Random random = new Random();
	int randomnumber = random.nextInt(100);
	String id = Integer.toString(randomnumber);
	
	return id; 
	
}
	
	
	public static String randomString() {
		
		String randomString =RandomStringUtils.randomAlphabetic(5);
		
		return randomString;
		
	}
}
