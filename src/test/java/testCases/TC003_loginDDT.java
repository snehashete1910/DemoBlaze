package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObject.Home_Page;
import pageObject.Home_Page_After_login;
import pageObject.Login_page;
import utilities.Data_Provider;

public class TC003_loginDDT extends Base_class_Test{
	@Test(dataProvider = "logindata",dataProviderClass=Data_Provider.class,groups = "datadriven")
	public void verifyloginddt(String email,String password,String exp)
	{
logger.info("start testing of login page..using datadriven..........");
		try {
		Home_Page h=new Home_Page(driver);
		h.login();
		Login_page lp=new Login_page(driver);
		lp.setloginname(email);
		lp.setloginpass(password);
		lp.clickloginbutton();
		
		//usernamevalidate
		Home_Page_After_login hpal=new Home_Page_After_login(driver);
		boolean usernameafterlogin=hpal.isloginnameexist();
		
		logger.info("---valid username/passowrd--login--pass--logout");
		logger.info("---valid username/passowrd-not login-fail--");
		logger.info("---invalid username/passowrd-login-fail--logout");
		logger.info("---invalid username/passowrd--not login--pass--");
		
		if(exp.equalsIgnoreCase("valid"))
		{
			if(usernameafterlogin==true)
			{
				Assert.assertTrue(true);
				hpal.logoutbuttob();
			}
			else
			{
				Assert.assertFalse(false);
			}
		}
		else if (exp.equalsIgnoreCase("invalid"))
		{
			if(usernameafterlogin==true)
			{
				hpal.logoutbuttob();
				Assert.assertTrue(false);
				
			}
			else
			{
				Assert.assertFalse(true);
			}
		}
		}
		catch(Exception e)
		{
			Assert.fail();
		}
		
		logger.info("---finished tc 003 of data drivern-------");
	}

}
