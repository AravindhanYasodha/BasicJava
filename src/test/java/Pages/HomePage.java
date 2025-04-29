package Pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.BaseClass;

public class HomePage extends BaseClass{
	
	@FindBy(xpath="//div[@class='nav-line-1-container']")
	WebElement userAccount;
	
	
	public HomePage() {
//		super();
//		InitialzieDriver();
		PageFactory.initElements(driver, this);
		
	}
	
	public void verifyUserAccount() {
		
		String userAccountName = userAccount.getText();
		System.out.println("User Account is : " + userAccountName);
		
	}
	
	
	

}
