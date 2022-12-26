package com.mystore.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyAccountInformation {

	WebDriver ldriver;

	public MyAccountInformation(WebDriver rdriver) 
	{
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(id = "input-email")
	WebElement registeredUserEmailId;
	
	@FindBy (linkText="Logout")
	WebElement logoutBtn;

	public String enterRegisteredEmailId() 
	{
		String text = registeredUserEmailId.getAttribute("value");
		return text;
	}
	
	public void clickOnLogoutBtn ()
	{
		logoutBtn.click();
	}
}
