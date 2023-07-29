package Practice.SpicejetAutomation;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;

public class WebDriverManager  {

	private static WebDriver driver;
	private static Properties prop;
	static Duration duration;
	
	private static Logger logger;
    static {
        try {   
               // you need to do something like below instaed of Logger.getLogger(....);
                logger = LogManager.getLogger(WebDriverManager.class); 
          } catch (Throwable th) {
             //   throw new HRException("Cannot load the log property file", th);
        }
    }
	  
	public static Properties getProp() {
		return prop;
	}



	public static void setProp(Properties prop) {
		WebDriverManager.prop = prop;
	}



	public static void setDriver(WebDriver driver) {
		WebDriverManager.driver = driver;
	}



	public static WebDriver getDriver()
	{
		if(driver==null)
		{
			driver = new ChromeDriver();
			
		}
		return driver;
		
	}
	

	
	public  WebDriverManager() throws IOException
	{
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream("C:\\Users\\gitika\\eclipse-workspace\\SpicejetAutomation\\db.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	

	}
	
	public static void initialization() throws IOException
	{    
		ChromeOptions options = new ChromeOptions();
	    options.addArguments("--remote-allow-origins=*");
		String browsername = getProp().getProperty("browser");
		if(browsername.equals("chrome"))
		{
		logger.log(Level.INFO, "Chrome initiated");
		   driver= new ChromeDriver(options);
		
		}
			
		if(browsername.equals("FF"))
		{
			logger.info("Initialized Firefox driver");
			driver= new FirefoxDriver();
		}
		
		if(browsername.equals("IE"))
		{   logger.info("Initialized IE driver");
			driver= new FirefoxDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
		driver.get(getProp().getProperty("url"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(7));
		
		
	}


	
}
