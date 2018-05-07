package practice;

import java.lang.reflect.Method;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class ExtentReportDemo {

	public static ExtentReports extent;
	public static ExtentTest test;
	public static WebDriver driver;
	
	@BeforeMethod
	public void beforeMethod(Method method){
		extent = new ExtentReports("D://Report.html", true);
		test= extent.startTest(method.getName(),this.getClass().getName());
		test.assignAuthor("Gaurav Rajput");
		test.assignCategory(this.getClass().getSimpleName());
		System.setProperty("webdriver.chrome.driver", "E://AutomatedTesting//Mobizio//src//test//resources//webdriver/chromedriver.exe");
		driver = new ChromeDriver();
		test.log(LogStatus.PASS, "browser launched successfully");
	}
	
	@Test
	public void methodName(){
		System.out.println("test executed");
		
	}
	
	@AfterMethod
	public void afterMethod(ITestResult result){
		if(result.getStatus() == ITestResult.FAILURE){
			System.out.println("add method to take screen shot");
		}
		driver.close();
		test.log(LogStatus.PASS, "browser closed successfully");
		extent.endTest(test);
		extent.flush();
		extent.close();
	}
	
	
	
}
