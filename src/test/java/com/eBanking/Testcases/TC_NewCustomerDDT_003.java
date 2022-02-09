package com.eBanking.Testcases;


import java.io.IOException;
import java.util.List;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.eBanking.Pageobjects.LoginPage;
import com.eBanking.Pageobjects.NewCustomer;
import com.eBanking.Utilities.XLUtils;

import net.bytebuddy.utility.RandomString;

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
	try {
	List<WebElement> iframes = driver.findElements(By.tagName("iframe"));
	if(iframes.size()>0) {
WebElement iframe=driver.findElement(By.id("google_ads_iframe_/24132379/INTERSTITIAL_DemoGuru99_0"));

driver.switchTo().frame(iframe).navigate().refresh();
cust.Clicknewcustomer();
	}
	}
	catch(Exception e)
	{
	e.printStackTrace();	
	}
	
	cust.SetCustname(customer_data[0]);
	cust.SetGender(customer_data[1]);
	cust.Dob(String.valueOf(customer_data[2]));
	//Thread.sleep(3000);
	cust.SetAddress(customer_data[3]);
	cust.SetCity(customer_data[4]);
	cust.SetState(customer_data[5]);
	cust.SetPin(customer_data[6]);
	cust.SetMobileno(customer_data[7]);
	cust.SetEmail(RandomString.make(8)+"@gmail.com");
	cust.SetPassword(customer_data[8]);
	logger.info("Credentials are entered");

	cust.Clicksubmit();
	logger.info("submit button is clicked");

		if(driver.getPageSource().contains("Customer Registered Successfully!!!")) {
			
			Assert.assertTrue(true);
			logger.info("test is passed");
			driver.switchTo().defaultContent();
			
			
		}
		else {
		
            Assert.assertTrue(false);
			logger.info("test is failed");
            driver.switchTo().defaultContent();
			
			
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
