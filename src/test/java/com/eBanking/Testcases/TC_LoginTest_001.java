package com.eBanking.Testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.eBanking.Pageobjects.LoginPage;



public class TC_LoginTest_001 extends BaseClass {
	
	
	@Test
	
	public void loginTest()
	{
		
		
		LoginPage lp=new LoginPage(driver);
		
		lp.SetUsrname(username);
		logger.info("usename is entered");
		
		lp.Setpassword(password);
		logger.info("password is entered");
		
		lp.Clicklogin();
		logger.info("submit button is clicked");
		
		if(driver.getTitle().equals("Guru99 Bank Manager HomePage")) {
			Assert.assertTrue(true);
			logger.info("test is passed");

		}
		else {
			Assert.assertTrue(false);
			logger.info("test failed");


		}
		
	}
}
