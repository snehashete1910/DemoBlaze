package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Mobile_Details_Page extends Base_Page{
	public Mobile_Details_Page(WebDriver driver)
	{
		super(driver);
	}
	@FindBy(xpath="//div[@id='contcont']//a[2]")
	WebElement mobilepage;
	
	public void clickonmobilelink()
	{
		mobilepage.click();
	}
}
