package com.eBanking.Utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.eBanking.Testcases.BaseClass;

public class Reporting extends TestListenerAdapter {
	public ExtentSparkReporter sparkreporter;
	public ExtentReports extent;
	public ExtentTest loggertest;
	
	public void onStart(ITestContext itestcontext) {
		
		String timestamp= new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		String repName="Test-Report-"+ timestamp+".html";
		
		
		sparkreporter=new ExtentSparkReporter(System.getProperty("user.dir")+"/test-output/"+repName);
		
		try {
			sparkreporter.loadXMLConfig(System.getProperty("user.dir")+"/extent-config.xml");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		extent=new ExtentReports();
		extent.attachReporter(sparkreporter);
		extent.setSystemInfo("HostName", "LocalHost");
		extent.setSystemInfo("Environment", "QA");
		extent.setSystemInfo("user", "Sabreen");
		
		sparkreporter.config().setDocumentTitle("eBanking Test Project");
		sparkreporter.config().setReportName("Functional Test Report");
		sparkreporter.config().setTheme(Theme.DARK);
	}
		public void onTestSuccess(ITestResult tr)
		{
			loggertest=extent.createTest(tr.getName());
			loggertest.log(Status.PASS, MarkupHelper.createLabel(tr.getName(), ExtentColor.GREEN));
			//extent.flush();
		}
		
		public void onTestFailure(ITestResult tr) {
		
			loggertest=extent.createTest(tr.getName());
			loggertest.log(Status.FAIL, MarkupHelper.createLabel(tr.getName(), ExtentColor.RED));
try {
	BaseClass.CaptureScreen(tr.getName()+ tr.getStartMillis())	;
} catch (IOException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}	

            String screenshotpath=System.getProperty("user.dir")+"/ScreenShots/"+tr.getName()+tr.getStartMillis()+".png";
			File f=new File(screenshotpath);
			if(f.exists()==true) 
			{
			loggertest.fail("Screenshot is Below" +loggertest.addScreenCaptureFromPath(screenshotpath) );
			
				
			}
			
		}
		
		public void onTestSkipped(ITestResult tr) {
			loggertest=extent.createTest(tr.getName());
			loggertest.log(Status.SKIP, MarkupHelper.createLabel(tr.getName(), ExtentColor.ORANGE));
			
		}
		
		public void onFinish(ITestContext itestcontext) {

			extent.flush();
			
		}
		
		
			
	

}

 