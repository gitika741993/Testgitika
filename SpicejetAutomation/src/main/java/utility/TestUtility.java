package utility;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.Set;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.Select;


public class TestUtility {
	
	
	public void waitForElementToAppear(WebElement ele,WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOf(ele));
		
	}
	
	public void waitforElementtobeClickable(WebElement ele1,WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.elementToBeClickable(ele1));
	}
	
	public void ScrollDown(WebDriver driver)
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1000)"); //Scroll vertically down by 1000 pixels
	}
	
	public void ScrollDownuntilVisible(WebElement Element,WebDriver driver)
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", Element);
	}
	
	public void ScrollDownElement(WebDriver driver, WebElement Element)
	{
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].click();", Element);
	}
	
	public static String getScreenshots(String testcasename,WebDriver driver) throws IOException
	{	  
		TakesScreenshot ts = (TakesScreenshot)driver;
        File srcFile = ts.getScreenshotAs(OutputType.FILE);
        File file = new File(System.getProperty("user.dir")+"/reports/" + testcasename + ".png");
        FileUtils.copyFile(srcFile, file);
        return System.getProperty("user.dir")+"/reports/"+ testcasename + ".png";
	}
    
	/*
	 * public void elementdatatoenter(WebDriver driver, WebElement test) {
	 * JavascriptExecutor jse = (JavascriptExecutor) driver;
	 * jse.executeScript("document.getElementById(test).value='Virender Testing
	 * sending'");
	 * 
	 * }
	 */
	
	
	public void Select(WebElement selectelement,String text)
	{
		Select select = new Select(selectelement); 
		select.selectByValue(text);
			
	}

	
	public void switchWindow(WebDriver driver)
	{
	Set <String> handles =driver.getWindowHandles();
	Iterator<String> it = handles.iterator();
	//iterate through your windows
	while (it.hasNext()){
	String parent = it.next();
	String newwin = it.next();
	driver.switchTo().window(newwin);
		
	}}
	
	
	
	
	public  void  selectMonth(WebElement dob,String dateofbirth) {
		
        Select select = new Select(dob);
		
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat dobdateformat = new SimpleDateFormat("dd-MM-yyyy");
		Date formatteddate;
		
		try
		{
			dobdateformat.setLenient(false);
			formatteddate = dobdateformat.parse(dateofbirth);
			calendar.setTime(formatteddate);
			
	
			int month = calendar.get(Calendar.MONTH);
			
			String monthofdob = String.valueOf(month);
	        select.selectByValue(monthofdob);
		}
	        
	        catch(Exception e)
	        {
	        e.fillInStackTrace();	
	        }

			
		}
		

public  void  selectyear(WebElement dob,String dateofbirth) {
		
        Select select = new Select(dob);
		
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat dobdateformat = new SimpleDateFormat("dd-MM-yyyy");
		Date formatteddate;
		
		try
		{
			dobdateformat.setLenient(false);
			formatteddate = dobdateformat.parse(dateofbirth);
			calendar.setTime(formatteddate);
			
			int year = calendar.get(Calendar.YEAR);
			String yearofdob = String.valueOf(year);		
			select.selectByValue(yearofdob);
					
		}
		catch(Exception e)
		{
			e.fillInStackTrace();
			System.out.println("Invalid date format in year, please enter date in format dd-mm-yyyy");
			
		}
	
	}


	
}
	


	
