package com.eBanking.Pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NewCustomer {
	
	
	WebDriver ldriver;

	public NewCustomer(WebDriver rdriver){
		
		ldriver=rdriver;
		PageFactory.initElements(rdriver,this);
	}
	
	@FindBy(name="name")
	WebElement customername;

	@FindBy(xpath="/html/body/table/tbody/tr/td/table/tbody/tr[5]/td[2]/input[1]")
	WebElement male;

	@FindBy(xpath="/html/body/table/tbody/tr/td/table/tbody/tr[5]/td[2]/input[2]")
	WebElement female;
	
	@FindBy(name="dob")
	WebElement dob;
	
	@FindBy(name="addr")
	WebElement address;
	
	@FindBy(name="city")
	WebElement city;
	
	@FindBy(name="state")
	WebElement state;
	
	@FindBy(name="pinno")
	WebElement pin;
	
	@FindBy(name="telephoneno")
	WebElement mobile;
	
	@FindBy(name="emailid")
	WebElement emailid;
	
	@FindBy(name="password")
	WebElement password;
	
	
	@FindBy(name="sub")
	WebElement submit;
	
	@FindBy(xpath="/html/body/div[3]/div/ul/li[2]/a")
	WebElement newcustomer;
	
	
	public void SetCustname(String custname) {
		customername.sendKeys(custname);
		
	}
	public void SetGender(String gender) {
		if(gender.equals("M")==true) {
			male.click();
		}
		else {
			female.click();
		}
		
	}
		
		
	public void Dob(String DateofBirth) throws InterruptedException {
	dob.sendKeys("05");
	dob.sendKeys("29");
	dob.sendKeys("1992");
	
	}	
	
	
	public void SetAddress(String addr) {
		address.sendKeys(addr);
		
	}
	
	public void SetCity(String cityname) {
		city.sendKeys(cityname);
		
	}
	
	public void SetState(String statename) {
		state.sendKeys(statename);
		
	}
	
	public void SetPin(String pinno) {
	pin.sendKeys(String.valueOf(pinno));
		
	}
	
	public void SetMobileno(String mobileno) {
		mobile.sendKeys(String.valueOf(mobileno));
		
	}
	
	public void SetEmail(String email) {
		emailid.sendKeys(email);
		
	}
	
	public void SetPassword(String pass) {
		password.sendKeys(pass);
		
	}
	public void Clicksubmit() {
	submit.click();
	}	

	public void Clicknewcustomer() {
	newcustomer.click();
	}	

}
