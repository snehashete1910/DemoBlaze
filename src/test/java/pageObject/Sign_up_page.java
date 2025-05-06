package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Sign_up_page extends Base_Page{
	
	public Sign_up_page(WebDriver driver)
	{
		super(driver);
	}
	
	@FindBy(xpath="//input[@id='sign-username']")
	WebElement username;
	
	@FindBy(xpath="//input[@id='sign-password']")
	WebElement password;
	
	@FindBy(xpath="//button[@onclick='register()']")
	WebElement signup;
	
	@FindBy(xpath="(//button[@type='button'][normalize-space()='Close'])[2]")
	WebElement close;
	
	@FindBy(xpath="//a[@id='cat']")
	WebElement buttonlabel;
	
	public void setusername(String uname)
	{
		username.sendKeys(uname);
	}
	public void setpass(String pass)
	{
		password.sendKeys(pass);
	}
	public void clicksignup()
	{
		signup.click();
	
	}
	public void clickclose()
	{
		close.click();
	}
	
	public String buttonlabelis()
	{
		String m=buttonlabel.getText();
		return m;
	}

}
