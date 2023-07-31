package com.qa.opencart.base;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.asserts.SoftAssert;

import com.qa.opencart.factory.DriverFactory;
import com.qa.opencart.pages.AccountsPage;
import com.qa.opencart.pages.LoginPage;
import com.qa.opencart.pages.ProductDetailsPage;
import com.qa.opencart.pages.SearchResultPage;

public class BaseTest {
	WebDriver driver;
	protected LoginPage loginpage;
	protected AccountsPage accpage;
	protected SearchResultPage searchpage;
	protected ProductDetailsPage productdetailspage;
	DriverFactory df;
	protected Properties prop;
	protected SoftAssert sofeassert;
	
	@BeforeClass
	public void setup() {
		df = new DriverFactory();
		prop = df.initProperties();
		driver = df.intiDriver(prop);
		loginpage = new LoginPage(driver);
		searchpage = new SearchResultPage(driver);
		sofeassert = new SoftAssert();
		
	}
	
	
	@AfterTest
	public void closeBrowser() {
		driver.quit();
	}
	
	
//	public BaseTest() {
//		driver = new ChromeDriver();
//	}
	

}
