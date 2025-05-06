package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Contact_Page extends Login_page{

	public Contact_Page(WebDriver driver) {
		super(driver);
	}
	@FindBy(xpath="//a[text()='Contact']")
	WebElement conatct;
	
	@FindBy(id="recipient-email")
	WebElement emailid;
	
	@FindBy(id="recipient-name")
	WebElement name;

	@FindBy(id="message-text")
	WebElement message;
	
	@FindBy(xpath="//button[contains(text(),'Send message')]")
	WebElement sendmessage;
	
	@FindBy(xpath="(//button[contains(text(),'Close')])[1]")
	WebElement closes;
	
	public void conttact()
	{
		conatct.click();
	}
	public void email(String emaill)
	{
		emailid.sendKeys(emaill);
	}
	public void messagee(String meessage)
	{
		message.sendKeys(meessage);
	}
	public void sendm()
	{
		sendmessage.click();
	}
	public void  closse()
	{
		closes.click();
	}
}
