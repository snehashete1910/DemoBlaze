package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Login_page extends Base_Page{

	public Login_page(WebDriver driver)
	{
		super(driver);
	}
	
	@FindBy(xpath="//input[@id='loginusername']")
	WebElement loginname;
	
	@FindBy(xpath="//input[@id='loginpassword']")
	WebElement loginpass;
	
	@FindBy(xpath="//button[@onclick='logIn()']")
	WebElement loginbuton;
	
	@FindBy(xpath="(//button[@class='btn btn-secondary'][text()='Close'])[3]")
	WebElement loginclose;
	
	public void setloginname(String loginnamee)
	{
		loginname.sendKeys(loginnamee);
	}
	public void setloginpass(String loginpassw)
	{
		loginpass.sendKeys(loginpassw);
	}
	public void clickloginbutton()
	{
		loginbuton.click();
	}
	public void clicksignupbutton()
	{
		loginclose.click();
	}
}
