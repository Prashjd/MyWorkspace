package com.mystore.testcases;

import java.time.Duration;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.mystore.utilities.Readconfig;

import io.github.bonigarcia.wdm.WebDriverManager;
import net.bytebuddy.utility.RandomString;

public class BaseClass {

	Readconfig readconfig = new Readconfig();

	String url = readconfig.getBaseUrl();
	String browser = readconfig.getBrowser();

	public static WebDriver driver; // webdriver initialize
	public static Logger log;		// logger initialize
	
	//generate random name or emailId
	public String generateRandomName()
	{
		return RandomStringUtils.randomAlphanumeric(5);
	}
	
	@BeforeClass
	public void setup() {

		switch (browser.toLowerCase())
		{
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;

		case "msedge":
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			break;

		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;

		default:
			driver = null;
			break;
		}

		// implicit wait for 10 secs
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		// for logging
		log = LogManager.getLogger("MyStoreV1");
	}
	
	@AfterClass
	public void tearDown() 
	{
		//driver.close();
		driver.quit();
	}

}
