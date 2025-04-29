package Pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Utilities.BaseClass;

public class SinginPage extends BaseClass {

	public String pageTitle;

	@FindBy(xpath = "//a[contains(text(),'Your Account')]")
	WebElement yourAccount;

	@FindBy(xpath = "//span[contains(text(),'sign in')]")
	WebElement signIn;

	@FindBy(css = "input[autocomplete='username']")
	WebElement enterUsername;

	@FindBy(css = "input[autocomplete='current-password']")
	WebElement enterPassword;

	@FindBy(css = ".a-button-input")
	WebElement continueBtn;

	public SinginPage() {

//		super();
//		InitialzieDriver();
		//this.driver =  driver;
		PageFactory.initElements(driver, this);
		
	}

	public void getPageTitle() {

		pageTitle = driver.getTitle();
		System.out.println("Page Title is : " + pageTitle);
	}

	public void clickOnSignIn() {

		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.invisibilityOfElementLocated((By) signIn));
		
		if (pageTitle.equals("Amazon.com")) {

			//yourAccount.click();
			signIn.click();

		} else {
			signIn.click();
		}

	}

	public void enterUsername(String username) {

		enterUsername.sendKeys(username);
		continueBtn.click();
	}

	public void enterPassword(String password) {

		enterPassword.sendKeys(password);
		continueBtn.click();
	}

	
	
}
