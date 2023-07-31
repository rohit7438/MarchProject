package com.qa.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.opencart.constants.AppConstants;
import com.qa.opencart.utilities.ElementUtils;

public class LoginPage {

	private ElementUtils eleUtils;
	private WebDriver driver;

	private By email = By.id("input-email");
	private By password = By.id("input-password");
	private By loginBtn = By.xpath("//input[@value='Login']");

	public LoginPage(WebDriver driver) {

		this.driver = driver;
		eleUtils = new ElementUtils(driver);
	}

	public String getLoginPageTitle() {
		return driver.getTitle();
	}

	public String getLoginPageURL() {
		return driver.getCurrentUrl();
	}

	public AccountsPage doLogin(String emailId, String pwd) {
		eleUtils.waitForElementVisible(email, AppConstants.MEDIUM_TIME_OUT).sendKeys(emailId);
		eleUtils.doSendKeys(password, pwd);
		eleUtils.doClick(loginBtn);
//		return eleUtils.waitForTitleIs(AppConstants.LOGIN_PAGE_TITLE, AppConstants.SHORT_TIME_OUT);
		return new AccountsPage(driver);
	}

}