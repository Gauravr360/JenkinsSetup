package practice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

	public static WebDriver driver;
	static String browser;
	
	@BeforeMethod
	public void beforeMethod(){
		String browser= System.getProperty("browser");
		if(browser.equals("chrome")){
			System.setProperty("webdriver.chrome.driver", "D://Automation Projects//Mobizio_AppiumPractice//Mobizio//src//test//resources//webdriver/chromedriver.exe");
			driver= new ChromeDriver();
		}
		
		else{
			System.setProperty("webdriver.gecko.driver", "D://Automation Projects//Mobizio_AppiumPractice//Mobizio//src//test//resources//webdriver/geckodriver.exe");
			driver= new FirefoxDriver();
		}
	}
	
	@AfterMethod
	public void afterMethod(){
		driver.close();
	}
}
