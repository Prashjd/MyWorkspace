package StepDefinition;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import PageObject.LoginPage;
import PageObject.NewAccountPage;
import PageObject.NewCustomerPage;
import Utilities.ReadConfig;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;

public class StepDefin extends BaseClass {

	@Before
	public void setup() throws IOException
	{	
		System.out.println("Setup method executed..");

		//Initialize ReadConfig() class to read data from config.properties
		readConfig = new ReadConfig();
		String browser = readConfig.getBrowser();

		//create an object of logger class
		log = LogManager.getLogger("StepDefin");

		//launch browser
		switch(browser.toLowerCase())
		{
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			break;

		case "msedge":
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			//driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			break;

		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			//driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			break;

		default:
			driver=null;
			break;		
		}
	}

	@Given("User launch chrome browser")
	public void user_launch_chrome_browser() {
		//Below 3 steps are executed in above setup method so no need to create again

		//WebDriverManager.chromedriver().setup();
		//driver = new ChromeDriver();
		//driver.manage().window().maximize();
		
//Initialise the page object with driver as a parameter
		
		loginPg = new LoginPage(driver);
		newcustpg = new NewCustomerPage(driver);
		newaccntpg =new NewAccountPage(driver);
		
		log.info("chrome browser launched..");  //log msg 

	}

	@When("User opens URL {string}")
	public void user_opens_url(String url) {
		driver.get(url);

		log.info("URL opened.");   //log msg

	}

	@When("User enters userID as {string} and password as {string}")
	public void user_enters_user_id_as_and_password_as(String uid, String passowrd){

		loginPg.enteruserID(uid);
		loginPg.enterpassword(passowrd);
		//loginPg.enteruserID(uid);
		//loginPg.enterpassword(passowrd);

		log.info("emailAdd And password entered..");  //log msg
	}

	@When("click on login")
	public void click_on_login() {

		loginPg.cliclOnLoginButton();

		log.info("login button clicked.");      //log msg
	}

	//******************************Login Feature of Guru99************************//

	@Then("Page Title should be {string}")
	public void page_title_should_be(String expectedTitle) {

		String actualTitle=driver.getTitle();

		if(actualTitle.equals(expectedTitle))
		{
			Assert.assertTrue(true); //pass
		}
		else
		{
			Assert.assertTrue(false);  //fail
		}   
	}

	@When("User click on Logout link")
	public void user_click_on_logout_link() throws InterruptedException {
		loginPg.cliclOnLogoutButton();
		Thread.sleep(2000);
	}

	@When("Accept Alert")
	public void accept_alert() {

		driver.switchTo().alert().accept();  //Alert is accepted-alert is a class
	}

	@Then("close browser")
	public void close_browser() {
		driver.close();
		//driver.quit();
	}

//***********************************New Customer***********************************************//
	@When("User click on  New Customer menu")
	public void user_click_on_new_customer_menu() throws InterruptedException
	{
		newcustpg.clickOnNewCustomer(); 
		Thread.sleep(3000);
	}

	@Then("User can view Add new customer page")
	public void user_can_view_add_new_customer_page()
	{
		String actualTitle=newcustpg.getPageTitle();
		String expectedTitle="Guru99 Bank New Customer Entry Page";

		if(actualTitle.equals(expectedTitle))
		{
			//log.info("user can veiw dashboard test passed");
			Assert.assertTrue(true);
		}
		else
		{
			Assert.assertTrue(false);
			//log.info("user can veiw dashboard test failed");
		}
	}

	@When("User enters customer info")
	public void user_enters_customer_info() 
	{
		newcustpg.enterCustomerName("Prashant");
		newcustpg.selectGender("Male");
		newcustpg.selectDate("12/01/1990");
		newcustpg.enterAddress("india");
		newcustpg.enterCity("jaysingpur");
		newcustpg.enterState("Goa");
		newcustpg.enterPIN("461110");
		newcustpg.enterMobile("1234567899");
		newcustpg.enterEmail(generateEmailID() +"@gmail.com");
		newcustpg.enterPassword("112244");	
	}

	@When("click on Submit button")
	public void click_on_submit_button() throws InterruptedException 
	{
		newcustpg.clickOnSubmit();
		//Thread.sleep(1000);
	}

	@Then("User can view confirmation message {string}")
	public void user_can_view_confirmation_message(String expectedText) 
	{

		String bodyTagText = driver.findElement(By.tagName("Body")).getText();
		if(bodyTagText.contains(expectedText))
		{
			Assert.assertTrue(true);  //tc will pass
		}
		else
		{
			Assert.assertTrue(false);	// tc will fail
		}	
	}
	
//********************************Add New Account************************************************//
	
	
	@When("User click on  New Account Menu Item")
	public void user_click_on_new_account_menu_item() throws InterruptedException 
	{
		newaccntpg.clickOnNewAccount();
		Thread.sleep(3000);
	}

	@Then("User can view Add new account page")
	public void user_can_view_add_new_account_page() 
	{
	    String actualTitle= newaccntpg.getPageTitle();
	    String expectedTitle="Guru99 bank add new account";
	    
	    if(actualTitle.equals(expectedTitle))
	    {
			Assert.assertTrue(true);
		}
		else
		{
			Assert.assertTrue(false);
		}    
	}

	@When("User enters details")
	public void user_enters_details() 
	{
		newaccntpg.entercustomerid("33456");
		newaccntpg.selectAccountType();
		newaccntpg.enterDeposit("5000");
		newaccntpg.entersubmitbutton();
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
//***********************For Screenshot "After" Annotation*******************************************//
	@After
	public void teardown(Scenario sc) //Here Scenario is class in cucumber
	{
		System.out.println("Teardown method executed..");

		if(sc.isFailed()==true)
		{
			Date d=new Date();
			SimpleDateFormat sdf=new SimpleDateFormat("MM-dd-yyyy HH-mm-ss");
			//Convert web driver object to TakeScreenshot

			//String fileWithPath = "C:\\Users\\admin\\eclipse-workspace\\com.Guru99\\Screenshots";
			String filewithpath=".\\Screenshots\\" + sdf.format(d) + " failed_SS.png";

			TakesScreenshot scrShot =((TakesScreenshot)driver);

			//Call getScreenshotAs method to create image file
			File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);

			//Move image file to new destination
			File DestFile=new File(filewithpath);

			//Copy file at destination
			try 
			{
				FileUtils.copyFile(SrcFile, DestFile);
			}
			catch (IOException e) 
			{
				e.printStackTrace();
			}
			driver.quit();
		}
	}
}