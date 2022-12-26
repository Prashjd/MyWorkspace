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
	
	@FindBy(id="input-firstname")
	WebElement txtfirstname;
	
	@FindBy(id="input-lastname")
	WebElement txtlastname;
	
	@FindBy(id="input-email")
	WebElement enetrEmail;
	
	@FindBy(id="input-telephone")
	WebElement txttelephone;
	
	@FindBy(id="input-password")
	WebElement txtpassword;
	
	@FindBy(id="input-confirm")
	WebElement txtcnfpassword;
	
	@FindBy(xpath="(//input[@name='newsletter'])[1]")
	WebElement selectRadioBtnYes;
	
	@FindBy(xpath="(//input[@name='newsletter'])[2]")
	WebElement selectRadioBtnNo;
	
	@FindBy(name="agree")
	WebElement selectcheckbox;
	
	@FindBy(xpath="(//input[@value='Continue'])")
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
	
	public void selectNewsletterRadio(String value)
	{
		if(value.equals("1"))
		{
			selectRadioBtnYes.click();
		}
		else if (value.equals("0"))
		{
			selectRadioBtnNo.click();
		}
		else                      //set default to No
		{
			selectRadioBtnNo.click();
		}	
	}
	
	public void clickOncheckBox()
	{
		selectcheckbox.click();
	}
	
	public void clickOnContine()
	{
		btncontinue.click();
	}

}
