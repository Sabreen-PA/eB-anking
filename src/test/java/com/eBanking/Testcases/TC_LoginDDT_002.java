package com.eBanking.Testcases;

import java.io.IOException;

import org.junit.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.eBanking.Pageobjects.LoginPage;
import com.eBanking.Utilities.XLUtils;

public class TC_LoginDDT_002 extends BaseClass{
	
	@Test(dataProvider="logindata")
	public void loginDDTTest(String user, String pwd){
		
		LoginPage lp=new LoginPage(driver);
		
		lp.SetUsrname(user);
		lp.Setpassword(pwd);
		lp.Clicklogin();
		
		if(driver.getTitle().equals("Guru99 Bank Manager HomePage")) {
			
			Assert.assertTrue(true);
			lp.Clicklogout();
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
		}
		else {
			
            Assert.assertTrue(false);
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
			
		}
		
		
	}
	@DataProvider(name="logindata")
	String[][] getData() throws IOException {
		//C:\Users\sabre\eclipse-workspace\eBankingv1\src\test\java\com\eBanking\Testdata
		String path="C:\\Users\\sabre\\eclipse-workspace\\eBankingv1\\src\\test\\java\\com\\eBanking\\Testdata\\Logindata.xlsx";
		int rowcount=XLUtils.getRowCount(path,"Sheet1");
		int cellcount=XLUtils.getCellCount(path,"Sheet1" , 1);
		
		String[][] Logindata= new String[rowcount][cellcount];
		
		for(int i=1; i<=rowcount;i++) {
			
			for(int j=0; j<cellcount;j++) {
				
				Logindata[i-1][j]=XLUtils.getCellData(path, "sheet1", i, j);
			}
		}
		return Logindata;
	}
		
		
	}


