package utilities;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.ImageHtmlEmail;
import org.apache.commons.mail.resolver.DataSourceUrlResolver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import testCases.Base_class_Test;

public class ExtendReport implements ITestListener{
	
	public ExtentSparkReporter sparkreporter;
	public ExtentReports extents;
	public ExtentTest test;
	
	String repName;
	
	public void onStart(ITestContext testContext) 
	{
		/*SimpleDateFormat df=new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss");
		Date dt=new Date();
		String currentdatetimestamp=df.format(dt);*/
		
		String timestamp=new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		repName="Test-Report"+timestamp+".html";
		sparkreporter=new ExtentSparkReporter("D:\\Project_Site\\DemoBlaze\\Reports\\"+repName);
		
		sparkreporter.config().setDocumentTitle("Demo Blaze Automation Report");
		sparkreporter.config().setReportName("Functional Testing");
		sparkreporter.config().setTheme(Theme.DARK);
		
		extents=new ExtentReports();
		extents.attachReporter(sparkreporter);
		extents.setSystemInfo("Application", "demoblaze");
		extents.setSystemInfo("module", "admin");
		extents.setSystemInfo("submodule", "category");
		extents.setSystemInfo("user name", System.getProperty("user.name"));
		extents.setSystemInfo("Environment", "QA");
		
		String os=testContext.getCurrentXmlTest().getParameter("os");
		extents.setSystemInfo("operating system", os);
		
		String browser=testContext.getCurrentXmlTest().getParameter("broswer")	;
		extents.setSystemInfo("browser", browser);
		
		List<String> includergroups=testContext.getCurrentXmlTest().getIncludedGroups();
		if(!includergroups.isEmpty())
		{
			extents.setSystemInfo("groups", includergroups.toString());
		}
	}
	public void onTestSuccess(ITestResult result)
	{
		test=extents.createTest(result.getTestClass().getName());
		test.assignCategory(result.getMethod().getGroups());
		test.log(Status.PASS, result.getName()+"got successfully excuted");	
	}
	public void OnTestFailure(ITestResult result)
	{
		test=extents.createTest(result.getTestClass().getName());
		test.assignCategory(result.getMethod().getGroups());
		
		test.log(Status.FAIL, result.getName()+"got failed");
		test.log(Status.INFO, result.getThrowable().getMessage());
	try
		{
			String imgpath=new Base_class_Test().capturescreen(result.getName());
			test.addScreenCaptureFromPath(imgpath);
		}
	catch(Exception e1)
	{
		 e1.printStackTrace();
	}
	}
	
	public void onTestSkipped(ITestResult result)
	{
		test=extents.createTest(result.getTestClass().getName());
		test.assignCategory(result.getMethod().getGroups());
		test.log(Status.FAIL, result.getName()+"got skipped");
		test.log(Status.INFO, result.getThrowable().getMessage());
	}
	
	
	public void OnFinish(ITestResult result)
	{
		extents.flush();
		String pathofextentreport="D:\\Project_Site\\DemoBlaze\\Reports\\"+repName;
		File extentreport=new File(pathofextentreport);
		 try
		 {
			 Desktop.getDesktop().browse(extentreport.toURI());
		 }
		 catch(IOException e)
		 {
			 e.printStackTrace();
		 }
	
/*	try{
		URL url=new URL("file://"+"D:\\Project_Site\\DemoBlaze\\Reports\\"+repName);
		//create the email message
		ImageHtmlEmail email=new ImageHtmlEmail();
		email.setDataSourceResolver(new DataSourceUrlResolver(url));
		email.setHostName("smtp.googlemail.com");
		email.setSmtpPort(465);
		email.setAuthenticator(new DefaultAuthenticator("sneha0@gmail.com", "58635"));
		email.setSSLOnConnect(true);
		email.setFrom("sneha0@gmail.com");
		email.setSubject("test results");
		email.setMsg("please find attached message");
		email.addTo("sneha5@gmail.com");
		email.attach(url, "extent report", "please check report");
		email.send();
	}
	catch(Exception e2)
	{
		 e2.printStackTrace();
	}*/
}}

