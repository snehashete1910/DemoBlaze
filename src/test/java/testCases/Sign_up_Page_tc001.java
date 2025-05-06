package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObject.Home_Page;
import pageObject.Sign_up_page;

public class Sign_up_Page_tc001 extends Base_class_Test{
	
@Test(groups = { "sanity","master"})
public void verifyabletoaddsignup() throws InterruptedException
{
	logger.info("*************verifyabletoaddsignup*******************");
	try
	{
	Home_Page hp=new Home_Page(driver);
	logger.info("*************click on signup and enter details******************");
    hp.signup();
    Sign_up_page s=new Sign_up_page(driver);
	s.setusername(randomstring().toUpperCase()+"@gmail.com");
	s.setpass(randalphanumeric());
	s.clicksignup();
	Thread.sleep(2000);
	driver.switchTo().alert().accept();
	logger.info("**********check category assert true or not***********");
	String buttonlabel=s.buttonlabelis();
	if(buttonlabel.equals("CATEGORIES"))
	{
	Assert.assertTrue(true);
	}
	else
	{
		logger.error("test failed");
		logger.error("Debug logs");
		Assert.assertTrue(false);
	}
	}
	catch(Exception e)
	{
		logger.error("test failed..");
		logger.debug("debug message");
		Assert.fail();
	}
}


}
