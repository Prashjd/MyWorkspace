package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class NewAccountPage {
	
	WebDriver ldriver;
	
	public NewAccountPage(WebDriver rdriver)
	{
		ldriver=rdriver;
		
		PageFactory.initElements(rdriver,this );
	}

	@FindBy(linkText="New Account")
	WebElement btnNewAccount;
	
	@FindBy(name="cusid")
	WebElement txtnewcustid;
	
	@FindBy(name="selaccount")
	WebElement selectacctype;
	
	@FindBy(name="inideposit")
	WebElement txtdeposit;
	
	@FindBy(name="button2")
	WebElement butnsubmit;
	
	
//***************************************action methods*****************************************//
	public String getPageTitle()
	{
		return ldriver.getTitle();
	}
	
	public void clickOnNewAccount()
	{
		btnNewAccount.click();
	}
	
	public void entercustomerid(String custid)
	{
		txtnewcustid.sendKeys(custid);
	}
	
	public void selectAccountType()
	{
		Select dropdwn= new Select(selectacctype);
		dropdwn.selectByVisibleText("Savings");
	}
	
	public void enterDeposit(String depoamount)
	{
		butnsubmit.sendKeys(depoamount);
	}
	
	public void entersubmitbutton()
	{
		butnsubmit.click();
	}
}
