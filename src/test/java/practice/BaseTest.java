package practice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

	public static WebDriver driver;
	String browser;
	
	@BeforeClass
	public void beforeMethod(){
		browser= System.getProperty("browser");
		if(browser == null){
			browser= "chrome";
		}
		if(browser.equals("chrome")){
			System.out.println("running script on chrome");
			System.setProperty("webdriver.chrome.driver", "D://Automation Projects//Mobizio_AppiumPractice//Mobizio//src//test//resources//webdriver/chromedriver.exe");
			driver= new ChromeDriver();
		}
		
		else{
			System.out.println("running script on firefox");
			System.setProperty("webdriver.gecko.driver", "D://Automation Projects//Mobizio_AppiumPractice//Mobizio//src//test//resources//webdriver/geckodriver.exe");
			driver= new FirefoxDriver();
		}
	}
	
	@AfterClass
	public void afterMethod(){
		driver.close();
	}
}
