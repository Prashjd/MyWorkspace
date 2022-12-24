package CodeStudio.MavenStudio;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import io.github.bonigarcia.wdm.WebDriverManager;



public class TestNGDemo1 {

	@Test
	public void verifyPageTitle()
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.get("https://www.google.co.in/");
		
		String expectedtitle ="Google";
		String actualtitle = driver.getTitle();
		
		System.out.println("Actual title Is: "+actualtitle);
		
		Assert.assertEquals(actualtitle, expectedtitle);
		
		driver.quit();
		
		
	}

}
