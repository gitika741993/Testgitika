package utils;

import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

//import utils.ExtentReportListener;


public class TestListeners implements ITestListener , ISuiteListener{
	
	private ExtentReports extentReports ;
	public static ExtentTest test;
    
   	
	public  void onStart(ISuite suite) {
		extentReports = new ExtentReports();
		String path = System.getProperty("user.dir")+"/reports/index.html";
        ExtentSparkReporter reporter = new ExtentSparkReporter(path);
        reporter.config().setReportName("Extent Report");
        reporter.config().setTheme(Theme.STANDARD);
        extentReports.attachReporter(reporter);
        extentReports.setSystemInfo("Blog Name", "Learning Rest Assured");
        extentReports.setSystemInfo("Author", "Gitika Jindal");
    
	  }
	
	
	@Override		
    public void onFinish(ITestContext arg0) {					
        // TODO Auto-generated method stub	
		
		System.out.println("Test Finished successfully");
		extentReports.flush();
        		
    }		

    @Override		
    public void onStart(ITestContext arg0) {					
        // TODO Auto-generated method stub	
    	
        	    }		

    @Override		
    public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {					
        // TODO Auto-generated method stub				
        		
    }		

    @Override		
    public void onTestFailure(ITestResult result) {					
        // TODO Auto-generated method stub
    	 
    	test.log(Status.FAIL, "Test Failed");
		/*
		 * test.fail(result.getThrowable());
		 * 
		 * if (ITestResult.FAILURE == result.getStatus()) { String testCaseName =
		 * result.getMethod().getMethodName();
		 * 
		 * try { System.out.println("Test Finished successfully"); String filepath =
		 * TestUtil.getScreenshots(testCaseName); //
		 * test.addScreenCaptureFromPath(filepath,testCaseName);
		 * test.addScreenCaptureFromPath(filepath); } catch (IOException e) { // TODO
		 * Auto-generated catch block e.printStackTrace(); } }
		 */
        
       	
        		
    }		

    @Override		
    public void onTestSkipped(ITestResult arg0) {					
        // TODO Auto-generated method stub				
        		
    }		

    @Override		
    public void onTestStart(ITestResult result) {					
        // TODO Auto-generated method stub		
    	
    	System.out.println("Test Started successfully");
    		test = extentReports.createTest(result.getName());		
    }		

    @Override		
    public void onTestSuccess(ITestResult arg0) {					
        // TODO Auto-generated method stub				
        	test.log(Status.PASS, "Test Passed successfully");
        	
    }		
	
	
}
