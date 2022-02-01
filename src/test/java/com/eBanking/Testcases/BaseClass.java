package com.eBanking.Testcases;




import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.eBanking.Utilities.Readconfig;

public class BaseClass {
	
	Readconfig readconfig= new Readconfig();

	public String baseurl=readconfig.getApplicationurl();
	public String username=readconfig.getUsername();
	public String password=readconfig.getPassword();
	public static WebDriver driver;
	public static Logger logger;
	
	@Parameters("browser")
	
	@BeforeClass
	public void setup(String br){
		
		
		 logger=Logger.getLogger("eBanking");
		PropertyConfigurator.configure("Log4j.properties");
		
	
		if(br.equals("firefox")) {
			
			System.setProperty("webdriver.gecko.driver",readconfig.getFirepath());
			 driver = new FirefoxDriver(); 
		}
		
		else {
			System.setProperty("webdriver.chrome.driver",readconfig.getChromepath());
			 ChromeOptions opt=new ChromeOptions();
			 opt.setExperimentalOption("excludeSwitches", Arrays.asList("disable-popup-blocking"));
			 driver = new ChromeDriver(opt);
		}
		
			 driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get(baseurl);
	}
	
	public static void CaptureScreen(String tname) throws IOException
	{
		TakesScreenshot ts=(TakesScreenshot)driver;
		File source=ts.getScreenshotAs(OutputType.FILE);
		File target=new File(System.getProperty("user.dir")+"/ScreenShots/"+tname+".png");
		FileUtils.copyFile(source, target);
		System.out.println("Screenshot is taken");
		
	}
	@AfterClass
	public void teardown() {
	driver.quit();
		
	}
}
