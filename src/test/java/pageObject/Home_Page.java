package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Home_Page extends Base_Page {
	

	public Home_Page(WebDriver driver)
	{
		super(driver);
		}
	@FindBy(xpath="//a[@id='login2']")
	WebElement login;
	
	@FindBy(xpath="//a[@id='signin2']")
	WebElement signup;
	
	public void login()
	{
		login.click();
	}
	
	public void signup()
	{
		signup.click();
	}
}
