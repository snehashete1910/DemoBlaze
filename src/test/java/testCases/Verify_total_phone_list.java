package testCases;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import pageObject.Home_Page;
import pageObject.Mobile_Details_Page;

public class Verify_total_phone_list extends Login_page_001 {
@Test
	public void verifylinksonpage()
	{
		Home_Page h=new Home_Page(driver);
		h.login();
		Mobile_Details_Page md=new Mobile_Details_Page(driver);
		md.clickonmobilelink();
		
		List<WebElement> lists=driver.findElements(By.tagName("a"));
		System.out.println(lists.size());
		
	}
}
