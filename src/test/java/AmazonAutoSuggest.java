import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class AmazonAutoSuggest {
	public WebDriver driver;
	public WebDriverWait wait;

	@BeforeMethod
	public void BrowserInitialize() {

		ChromeOptions option = new ChromeOptions();
		option.addArguments("--disable-notifications");
		driver = new ChromeDriver(option);

		driver.get("https://www.amazon.in");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		String title = driver.getTitle();
		System.out.println("Title of HomePage : " + title);
		String title1 = "Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in";
		String title2 = "Amazon.in";
		if (title.equals(title2)) {
			Assert.assertEquals(title, title2);
		} else {
			Assert.assertEquals(title, title1);
		}
	}

	@Test
	public void AutoSuggestion() throws InterruptedException, AWTException {
//Clicking Search Box and Enter Shoes
		WebElement search_Box = driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(search_Box));
		search_Box.click();
		search_Box.sendKeys("Shoes");
		// Thread.sleep(5000);
		/*
		 * List<WebElement> searchAjax =
		 * driver.findElements(By.xpath("[id='nav-flyout-searchAjax']")); int
		 * sizeofSearch = searchAjax.size();
		 * System.out.println("Total Count Search Result : " + sizeofSearch);
		 * Thread.sleep(5000);
		 */
//Selecting 4th element of Auto suggest using Robot class
		Robot rb = new Robot();
		for (int i = 0; i <= 3; i++) {
			rb.keyPress(KeyEvent.VK_DOWN);
			rb.keyRelease(KeyEvent.VK_DOWN);
		}
		Thread.sleep(2000);
		rb.keyPress(KeyEvent.VK_ENTER);
		rb.keyRelease(KeyEvent.VK_ENTER);

		String mensshoestitle = driver.getTitle();
		System.out.println("Title of Mens Shoes Page : " + mensshoestitle);

		/*
		 * wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		 * wait.until(ExpectedConditions.refreshed(ExpectedConditions.
		 * presenceOfElementLocated(By.xpath("//input[@id='twotabsearchtextbox']"))));
		 * String searchedItem = search_Box.getText(); System.out.println(searchedItem);
		 */
//Select Red color shoe by clicking color
		WebElement redClr = driver.findElement(By.xpath("(//div[@class='colorsprite aok-float-left'])[6]"));
		redClr.click();
		/*
		 * boolean redSelected = redClr.isEnabled(); if (redSelected == true) {
		 * System.out.println("RED Color Shoes Searched"); } else {
		 * System.out.println("RED Color Not Selected"); }
		 */
		String redshoestitle = driver.getTitle();
		System.out.println("Title of RED Shoes Page : " + redshoestitle);

//Select Categories from Select Dropdown
		WebElement cataDropdown = driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));
		Select sc = new Select(cataDropdown);
		List<WebElement> optionsDrop = sc.getOptions();
		int dropdownSize = optionsDrop.size();
		System.out.println("Total Count of Catagories : " + dropdownSize);
		for (int i = 0; i < dropdownSize; i++) {
			String dropdownValues = optionsDrop.get(i).getText();
			System.out.println(dropdownValues);
		}
		cataDropdown.click();
		/*
		 * sc.selectByValue("search-alias=automotive"); Thread.sleep(2000);
		 * sc.selectByValue("search-alias=automotive"); String carMotorBikeTitle =
		 * driver.getTitle(); System.out.println("Title of Car&MotorBike Page : " +
		 * carMotorBikeTitle);
		 */
		Thread.sleep(5000);

//Before click value get parent window ID
		String parentWindow = driver.getWindowHandle();
		System.out.println("Parent Window ID is : " + parentWindow);

//Selecting 3rd product of search
		List<WebElement> productList = driver.findElements(By.tagName("a"));
		int totalProduct = productList.size();
		System.out.println("Total Product in page : " + totalProduct);

		WebElement thirdProduct = driver.findElement(By.xpath("(//h2[@class='a-size-base-plus a-spacing-none a-color-base a-text-normal'])[3]"));
		thirdProduct.click();
		//wait.until(ExpectedConditions.)
		driver.switchTo().window(parentWindow);
		Thread.sleep(5000);
		
		for(int i =0;i<5 && i<totalProduct;i++) {
			
			productList.get(i).click();
			driver.switchTo().window(parentWindow);
		}
	}

}
