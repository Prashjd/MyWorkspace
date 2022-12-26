package com.mystore.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.mystore.pageobject.IndexPage;
import com.mystore.pageobject.LoginPage;
import com.mystore.pageobject.MyAccountInformation;
import com.mystore.pageobject.MyAccountPage;
import com.mystore.pageobject.RegistrationPage;



import com.mystore.pageobject.RegSuccesPage;

public class TC_001 extends BaseClass{

	//TC_001: verify new user can create account successfully

	@Test(enabled=false)
	public void VerifyRegistrationAndLogin()
	{
		//open url	
		driver.get(url);
		log.info("url opened");

		//click on my account btn & register btn
		IndexPage indexpg=new IndexPage(driver);

		indexpg.clickOnMyAccount();
		indexpg.clickOnLogin();

		//*****************login page *******************
		LoginPage loginpg=new LoginPage(driver);

		loginpg.clickonContinueButton();

		//******************************************************************
		RegistrationPage registarionpg =new RegistrationPage(driver);

		registarionpg.enterFirstName(generateRandomName());
		registarionpg.enterLatName("Jadhav");
		registarionpg.enterEmailID(generateRandomName() +"@gmail.com");
		registarionpg.enterTelephoneno("1234567890");
		registarionpg.enterPassword("123456");
		registarionpg.enterConfirmPassword("123456");
		registarionpg.selectNewsletterRadio("No");
		registarionpg.clickOncheckBox();
		registarionpg.clickOnContine();

		log.info("user details entered");

		//********************success page**************************************
		RegSuccesPage successpg =new RegSuccesPage(driver);

		String actualmsg= successpg.getSuccessMSg();
		Assert.assertEquals(actualmsg,"Your Account Has Been Created!");
		successpg.clickOnLogout();

	}

	//*************************************TC_002*****************************//


	@Test(enabled=true)
	public void VerifyLoginOfRegisteredCustomer ()
	{

		//open url	
		driver.get(url);
		log.info("url opened");
		log.info("***VerifyLoginOfRegisteredCustomer test execution started***");


		//click on my account btn & register btn
		IndexPage indexpg=new IndexPage(driver);

		indexpg.clickOnMyAccount();
		log.info("clicked On MyAccount Btn");

		indexpg.clickOnLogin();

		//*****************login page *******************

		LoginPage loginpg=new LoginPage(driver);

		loginpg.enterReturningEmailID("test420@gmail.com");
		loginpg.enterReturningaPassword("Tester@123");
		loginpg.clickOnLoginBtnForRegistered();

		log.info("Testing log********************");

		//***********************My Acct pg*************************

		MyAccountPage myaccntpg = new MyAccountPage(driver);
		myaccntpg.clcikOnEditLink();
		
		log.info("successfully clicked on my aacount page");
		
		//***********************My AcctInfo Page*************************

		MyAccountInformation myaccntinfopg =new MyAccountInformation(driver);
		String actualEmailID = myaccntinfopg.enterRegisteredEmailId();
		//System.out.println(actualEmailID);
		Assert.assertEquals(actualEmailID, "test420@gmail.com");
		myaccntinfopg.clickOnLogoutBtn();

	}

}
