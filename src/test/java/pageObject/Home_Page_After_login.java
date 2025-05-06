package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Home_Page_After_login extends Login_page {

	public Home_Page_After_login(WebDriver driver) {
		super(driver);
		
	}
	@FindBy(xpath="//a[@id='logout2']")
	WebElement logout;
	
	@FindBy(xpath="//a[contains(text(),'Welcome')]")
	WebElement loginname; 
	
	public void logoutbuttob()
	{
		logout.click();
	}
	 public boolean isloginnameexist()
	 {
		 try
		 {
			 return (loginname.isDisplayed());
		 }
		 catch(Exception e)
		 {
			return false; 
		 }
	 }
	
	

}
