package com.eBanking.Pageobjects;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
WebDriver ldriver;

public LoginPage(WebDriver rdriver){
	
	ldriver=rdriver;
	PageFactory.initElements(rdriver,this);
}

@FindBy(name="uid")
WebElement username;

@FindBy(name="password")
WebElement password;

@FindBy(name="btnLogin")
WebElement login;

@FindBy(xpath="/html/body/div[3]/div/ul/li[15]/a")
WebElement logout;

public void SetUsrname(String uname) {
	username.sendKeys(uname);
	
}
public void Setpassword(String pass) {
	password.sendKeys(pass);
	
}
	
	
public void Clicklogin() {
login.click();
}	
public void Clicklogout() {
logout.click();
}	
	
	
}	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	


