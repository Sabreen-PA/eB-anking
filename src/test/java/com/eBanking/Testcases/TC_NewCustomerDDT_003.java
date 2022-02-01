package com.eBanking.Testcases;

import java.io.IOException;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.eBanking.Pageobjects.LoginPage;
import com.eBanking.Pageobjects.NewCustomer;
import com.eBanking.Utilities.XLUtils;

public class TC_NewCustomerDDT_003 extends BaseClass{
	
	@BeforeClass
	public void login() {
		
		
		logger.info("url is opened");
		
		LoginPage lp=new LoginPage(driver);
		
		lp.SetUsrname(username);
		logger.info("usename is entered");
		
		lp.Setpassword(password);
		logger.info("password is entered");
		
		lp.Clicklogin();
		logger.info("submit button is clicked");
	}
	
	@Test(dataProvider="customerdata")
	public void NewCustomerDDT(String[] customer_data) throws InterruptedException{
					
    NewCustomer cust=new NewCustomer(driver);
	
	cust.Clicknewcustomer();

	driver.switchTo().activeElement().click();
	driver.navigate().back();
	
	//driver.switchTo().defaultContent();
	cust.Clicknewcustomer();
	cust.SetCustname(customer_data[0]);
	cust.SetGender(customer_data[1]);
	cust.Dob(String.valueOf(customer_data[2]));
	logger.info(customer_data[2]);
	Thread.sleep(5000);
	cust.SetAddress(customer_data[3]);
	cust.SetCity(customer_data[4]);
	cust.SetState(customer_data[5]);
	cust.SetPin(customer_data[6]);
	cust.SetMobileno(customer_data[7]);
	cust.SetEmail(customer_data[8]);
	cust.SetPassword(customer_data[9]);
	
	cust.Clicksubmit();
		
		if(driver.getPageSource().contains("Customer Registered Successfully!!!")) {
			
			Assert.assertTrue(true);
			cust.Clicknewcustomer();
			
			
		}
		else {
			
            Assert.assertTrue(false);
            cust.Clicknewcustomer();
			
			
		}
		
		
	}
	
	
	@DataProvider(name="customerdata")
	String[][] getCustomerData() throws IOException {
		
		String path=System.getProperty("user.dir")+"\\src\\test\\java\\com\\eBanking\\Testdata\\Customerdata.xlsx";
		int rowcount=XLUtils.getRowCount(path,"Sheet1");
		int cellcount=XLUtils.getCellCount(path,"Sheet1" , 1);
		
		String[][] custdata= new String[rowcount][cellcount];
		
		for(int i=1; i<=rowcount;i++) {
			
			for(int j=0; j<cellcount;j++) {
				
				custdata[i-1][j]=XLUtils.getCellData(path, "sheet1", i, j);
			}
		}
		return custdata;
	}

}
