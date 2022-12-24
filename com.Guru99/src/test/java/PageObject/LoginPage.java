package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	WebDriver ldriver;
	
	public LoginPage(WebDriver rdriver)
	{
		ldriver=rdriver;
		
		PageFactory.initElements(rdriver, this);	
	}
	
	@FindBy(name="uid")
	WebElement userid;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(name="btnLogin")
	WebElement Loginbtn;
	
	@FindBy(linkText="Log out")
	WebElement Logoutbtn;
	
	public void enteruserID(String usrid)
	{
		userid.clear();
		userid.sendKeys(usrid);
	}
	
	public void enterpassword(String pwd)
	{
		password.clear();
		password.sendKeys(pwd);
	}
	
	public void cliclOnLoginButton()
	{
		Loginbtn.click();
	}
	
	public void cliclOnLogoutButton()
	{
		Logoutbtn.click();
	}
}
