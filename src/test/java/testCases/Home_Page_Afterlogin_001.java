package testCases;

import pageObject.Home_Page_After_login;

public class Home_Page_Afterlogin_001 extends Login_page_001{
	
	public void logoutasuser()
	{
		Home_Page_After_login h=new Home_Page_After_login(driver) ;
		h.logoutbuttob();
		
	}

}
