package com.mystore.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class RegistrationPage {
	
	WebDriver ldriver;
	
	public RegistrationPage(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(name="input-firstname")
	WebElement txtfirstname;
	
	@FindBy(name="input-lastname")
	WebElement txtlastname;
	
	@FindBy(name="input-email")
	WebElement enetrEmail;
	
	@FindBy(name="input-telephone")
	WebElement txttelephone;
	
	@FindBy(name="input-password")
	WebElement txtpassword;
	
	@FindBy(name="input-confirm")
	WebElement txtcnfpassword;
	
	@FindBy(xpath="input-confirm")
	WebElement selectradio;
	
	@FindBy(name="agree")
	WebElement selectcheckbox;
	
	@FindBy(name="btn btn-primary")
	WebElement btncontinue;
	
	//**************action methods**********************//
	
	public void enterFirstName(String fname)
	{
		txtfirstname.sendKeys(fname);
	}
	
	public void enterLatName(String lname)
	{
		txtlastname.sendKeys(lname);
	}
	
	public void enterEmailID(String emailAdd)
	{
		enetrEmail.sendKeys(emailAdd);
	}
	
	public void enterTelephoneno(String phone)
	{
		txttelephone.sendKeys(phone);
	}
	
	public void enterPassword(String pwd)
	{
		txtpassword.sendKeys(pwd);
	}
	
	public void enterConfirmPassword(String cnfpwd)
	{
		txtcnfpassword.sendKeys(cnfpwd);
	}
	
	public void selectNewsletterRadio()
	{
		
		selectradio.click();
	}
	
	public void selectcheckBox()
	{
		selectcheckbox.click();
	}
	
	public void clickOnContine()
	{
		btncontinue.click();
	}

}
