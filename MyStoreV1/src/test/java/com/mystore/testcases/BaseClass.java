package com.mystore.testcases;

import java.time.Duration;

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

public class BaseClass {

	Readconfig readconfig = new Readconfig();

	String url = readconfig.getBaseUrl();
	String browser = readconfig.getBrowser();

	public static WebDriver driver; // webdriver initialize
	public static Logger logger;
	
	@BeforeClass
	public void setup() {

		switch (browser.toLowerCase()) {
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
		logger = LogManager.getLogger("MyStoreV1");
	}
	
	@AfterClass
	public void teaDown() 
	{
		driver.close();
		driver.quit();
	}

}
