package com.qa.opencart.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.opencart.constants.AppConstants;
import com.qa.opencart.utilities.ElementUtils;


public class AccountsPage {
	
	private WebDriver driver;
	private ElementUtils eleUtil;
	
	
	private By searchbox = By.name("search");
	private By logout = By.xpath("(//a[contains(text(),'Logout')])[2]");
	private By headers = By.xpath("//div/h2");
	private By searchicon = By.xpath("//i[@class='fa fa-search']");

	

	public AccountsPage(WebDriver driver) {
		this.driver = driver;
		eleUtil = new ElementUtils(driver);
		
	}
	
	public boolean isLogoutLinkVisible() {
		return eleUtil.waitForElementPresence(logout, AppConstants.SHORT_TIME_OUT).isDisplayed();
	}
	
	public List<String> getAccountPadeHeaders() {
	List<WebElement> headerlist = eleUtil.waitForElementsVisible(headers, AppConstants.SHORT_TIME_OUT);
	List<String> newHeadeList = new ArrayList<String>();
	for(WebElement e : headerlist) {
		String header= e.getText();
		newHeadeList.add(header);
	}
	return newHeadeList;
	}
	
	public int getAccountPageHeaderCount() {
		return eleUtil.waitForElementsVisible(headers, AppConstants.SHORT_TIME_OUT).size();
		
	}
	
	public SearchResultPage doSearch(String search) {
		WebElement searchResult = eleUtil.waitForElementVisible(searchbox, AppConstants.MEDIUM_TIME_OUT);
		searchResult.clear();
		searchResult.sendKeys(search);
		eleUtil.doClick(searchicon);
		return new SearchResultPage(driver);
	}
	
}
