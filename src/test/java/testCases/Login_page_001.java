package testCases;

import org.testng.annotations.Test;

import pageObject.Home_Page;
import pageObject.Login_page;

public class Login_page_001 extends Base_class_Test{
	@Test(groups = {"regression","master"})
	public void abletologin()
	{
		logger.info("start testing of login page............");
		
		Home_Page h=new Home_Page(driver);
		h.login();
		Login_page lp=new Login_page(driver);
		lp.setloginname(p.getProperty("email"));
		lp.setloginpass(p.getProperty("password"));
		System.out.println(driver.getTitle());
		
	}
	

}
