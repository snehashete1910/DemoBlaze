package testCases;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class Base_class_Test {
	public Logger logger;
	public static WebDriver driver;
	public Properties p;
	
	@Parameters({"browser"})
	@BeforeClass(groups = {"master","regression","sanity","datadriven"})
	public void setup(@Optional("chrome") String br) throws IOException
	{
		FileReader file=new FileReader("D:\\Project_Site\\DemoBlaze\\src\\test\\resources\\config.properties");
		 p=new Properties();
		p.load(file);
		
		
		logger=LogManager.getLogger(this.getClass());
		switch(br.toLowerCase())
		{
		case "chrome": driver=new ChromeDriver();break;
		case "edge": driver=new EdgeDriver();break;
		case "firefox": driver=new FirefoxDriver();break;
		default:System.out.println("invalid browser name"); return;
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.MILLISECONDS);
		driver.manage().deleteAllCookies();
		driver.get(p.getProperty("appurl"));
	}
	@AfterClass(groups = {"master","regression","sanity","datadriven"})
public void teardown()
{
	driver.close();
}
	public String randomstring()
	{
		String randomstring=RandomStringUtils.randomAlphabetic(5);
		return randomstring;
	}
	public String randalphanumeric()
	{
		String alphanumeric=RandomStringUtils.randomAlphanumeric(5);
				return alphanumeric;
	}
	public String numeric()
	{
		String randnumeric=RandomStringUtils.randomNumeric(3);
				return randnumeric;
	}
	
	public String capturescreen(String tname)
	{
		String timestamp=new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		
		TakesScreenshot takescreenshot=(TakesScreenshot)driver;
		File sourcefile=takescreenshot.getScreenshotAs(OutputType.FILE);
		
		String targetfilepath="D:\\Project_Site\\DemoBlaze\\Screenshots\\"+tname+"-"+timestamp+".png";
		
		File targetfile=new File(targetfilepath);
		
		sourcefile.renameTo(targetfile);
		return targetfilepath;
		
		
	}
}
