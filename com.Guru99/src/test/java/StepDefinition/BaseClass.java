package StepDefinition;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.apache.commons.lang.RandomStringUtils;
import org.apache.logging.log4j.*;

import PageObject.LoginPage;
import PageObject.NewAccountPage;
import PageObject.NewCustomerPage;
import Utilities.ReadConfig;

public class BaseClass {

	public static WebDriver driver;
	public static LoginPage loginPg;
	public static NewCustomerPage newcustpg;
	public static NewAccountPage newaccntpg;
	public ReadConfig readConfig;
	public static Logger log;
	

	//generate unique email id
	public String generateEmailID()
	{
		return(RandomStringUtils.randomAlphabetic(5));
	}
	
}
