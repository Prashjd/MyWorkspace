package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NewCustomerPage {
	
	WebDriver ldriver;
	
	public NewCustomerPage(WebDriver rdriver)
	{
		ldriver=rdriver;
		
		PageFactory.initElements(rdriver, this);	
	}

	@FindBy(linkText="New Customer")
	WebElement btnnewcustomer;
	
	@FindBy(name="name")
	WebElement txtCustomerName;
	
	@FindBy(xpath="//input[@value='m']")
	WebElement selectGender;
	
	@FindBy(xpath="//input[@name='dob']")
	WebElement selectDate;
	
	@FindBy(name="addr")
	WebElement txtAddress;
	
	@FindBy(name="city")
	WebElement txtCity;
	
	@FindBy(name="state")
	WebElement txtState;
	
	@FindBy(name="pinno")
	WebElement txtPincode;
	
	@FindBy(name="telephoneno")
	WebElement txtMobile;
	
	@FindBy(name="emailid")
	WebElement txtEmail;
	
	@FindBy(name="password")
	WebElement txtpassword;
	
	@FindBy(name="sub")
	WebElement btnsubmit;
	
	//actions method
	
	public String getPageTitle()
	{

		return ldriver.getTitle();
	}
	
	public void clickOnNewCustomer()
	{
		
		btnnewcustomer.click();
	}
	
	public void enterCustomerName(String name)
	{
		txtCustomerName.sendKeys(name);
	}
	
	public void selectGender(String gender)
	{
		selectGender.sendKeys(gender);
	}
	
	public void selectDate(String date)
	{
		selectDate.sendKeys(date);
	}
	
	public void enterAddress(String addrs)
	{
		txtAddress.sendKeys(addrs);
	}
	
	public void enterCity(String cityname)
	{
		txtCity.sendKeys(cityname);
	}
	
	public void enterState(String statename)
	{
		txtState.sendKeys(statename);
	}
	
	public void enterPIN(String pincode)
	{
		txtPincode.sendKeys(pincode);
	}
	
	public void enterMobile(String mobno)
	{
		txtMobile.sendKeys(mobno);
	}
	
	public void enterEmail(String emailadd)
	{
		txtEmail.sendKeys(emailadd);
	}
	
	public void enterPassword(String pswd)
	{
		txtpassword.sendKeys(pswd);
	}
	
	public void clickOnSubmit()
	{
		btnsubmit.click();;
	}
}
