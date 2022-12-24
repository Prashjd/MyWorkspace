package CodeStudio.MavenStudio;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestNGDemo {

	
		public void verifyPageTitle()
		{
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver= new ChromeDriver();

		driver.manage().window().maximize();
		driver.get("https://www.flipkart.com/");
		}
}
