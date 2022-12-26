package com.mystore.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	WebDriver ldriver;

	public LoginPage(WebDriver rdriver) 
	{
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(linkText = "Continue")
	WebElement btnconti;
	
	@FindBy(id = "input-email")
	WebElement enterReturningEmail;
	
	@FindBy(id = "input-password")
	WebElement enterReturningPassword;
	
	@FindBy(xpath="//input[@type='submit']")
	WebElement btnLogin;

	public void clickonContinueButton()
	{
		btnconti.click();
	}
		
	public void enterReturningEmailID(String emailAdd)
	{
		enterReturningEmail.sendKeys(emailAdd);
	}
	
	public void enterReturningaPassword(String pwd)
	{
		enterReturningPassword.sendKeys(pwd);
	}
	
	public void clickOnLoginBtnForRegistered()
	{
		btnLogin.click();
	}
	
	

}