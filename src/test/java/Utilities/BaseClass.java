package Utilities;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseClass {
	
	public static WebDriver driver;
	public static Properties properties;
	
	public BaseClass() {
		
		try {
			properties = new Properties();
			FileInputStream fileInput = new FileInputStream("src/test/resources/config.properties");
			properties.load(fileInput);
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@BeforeClass
	public static void InitialzieDriver() {
		
		driver = new ChromeDriver();
		
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get(properties.getProperty("url"));
	}
	

//	public static void launch() {
//		
//		driver.get(properties.getProperty("url"));
//		
//	}
	@AfterClass
	public static void tearDown() {
		
		if(driver!=null) {
			
			driver.quit();
			
		}
		
		
	}
}
