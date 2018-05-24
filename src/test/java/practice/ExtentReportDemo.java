package practice;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class ExtentReportDemo {

	public static WebDriver driver;
	static String browser;
	
	@BeforeMethod
	public void beforeMethod(){
		String browser= System.getProperty("browser");
		if(browser.equals("chrome")){
			System.out.println("running on chrome");
			System.setProperty("webdriver.chrome.driver", "D://Automation Projects//Mobizio_AppiumPractice//Mobizio//src//test//resources//webdriver/chromedriver.exe");
			driver= new ChromeDriver();
		}
		
		else{
			System.out.println("running on firefox");
			System.setProperty("webdriver.gecko.driver", "D://Automation Projects//Mobizio_AppiumPractice//Mobizio//src//test//resources//webdriver/geckodriver.exe");
			driver= new FirefoxDriver();
		}
	}
	
	@Test
	public void methodName(){
		driver.get("https://www.google.com/");
		
	}
	
	@AfterMethod
	public void afterMethod(){
		driver.close();
	}
	
	
	
}
