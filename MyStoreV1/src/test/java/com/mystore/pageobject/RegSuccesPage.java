package com.mystore.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegSuccesPage {
	
	WebDriver ldriver;
	
	public RegSuccesPage(WebDriver rdriver)
	{
		ldriver=rdriver;
		
		PageFactory.initElements(rdriver,this);
		
	}
	
	@FindBy(xpath="//h1[contains(text(),'Your Account Has Been Created!')]")
	WebElement successmsg;
	
	@FindBy(linkText="Logout")
	WebElement btnlogout;
		
	public String getSuccessMSg()
	{
		String text=successmsg.getText();
		return text;
	}
	
	public void clickOnLogout()
	{
		btnlogout.click();
	}

}
