package com.mystore.testcases;

import com.mystore.pageobject.LoginPage;

public class TC_IndexPage extends BaseClass{
	
	public void VerifyRegistrationAndLogin()
	{
		//open url	
		driver.get(url);
		logger.info("url opened");
		
		LoginPage pg=new LoginPage(driver);
	}

}
