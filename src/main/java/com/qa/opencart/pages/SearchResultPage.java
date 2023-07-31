package com.qa.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.opencart.constants.AppConstants;
import com.qa.opencart.utilities.ElementUtils;

public class SearchResultPage {
	private WebDriver driver;
	private ElementUtils eleUtil;

	private	By SearchResult = By.xpath("//div[contains(@class,'product-layout')]//img");


	public SearchResultPage(WebDriver Driver) {
		this.driver = Driver;
		eleUtil = new ElementUtils(driver);
	}

	public int getSearchResultCount() {
		int size=eleUtil.waitForElementsPresence(SearchResult, AppConstants.MEDIUM_TIME_OUT).size();
		return size;
	}
	
	public ProductDetailsPage selectProduct(String productName) {
	eleUtil.clickElementWhenReady(By.xpath("(//img[contains(@title,'"+productName+"')])[1]"), AppConstants.MEDIUM_TIME_OUT);
	return new ProductDetailsPage(driver);
	}

	

}
