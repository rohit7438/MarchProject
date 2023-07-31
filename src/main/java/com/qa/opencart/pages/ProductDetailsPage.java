package com.qa.opencart.pages;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.opencart.constants.AppConstants;
import com.qa.opencart.utilities.ElementUtils;

public class ProductDetailsPage {
	
	private WebDriver driver ;
	private ElementUtils eleUtil;

	public ProductDetailsPage(WebDriver Driver) {
		this.driver=Driver;
		eleUtil = new ElementUtils(driver);
	}
	
	private By ProductImages = By.xpath("//a[@class='thumbnail']");
	
	private By ProductMetaData = By.xpath("(//div[@id]//ul[@class='list-unstyled'])[1]/li");
	
	
	
	
	public int productImagesCount() {
		return eleUtil.waitForElementsVisible(ProductImages, AppConstants.MEDIUM_TIME_OUT).size();
	}
	

	public Map<String, String> productMetaData() {
		List<WebElement> metalist = eleUtil.waitForElementsVisible(ProductMetaData, AppConstants.MEDIUM_TIME_OUT);
		Map<String, String> dataMap = new LinkedHashMap<String, String>();
		for(WebElement e: metalist) {
			String metaText = e.getText();
			String key = metaText.split(":")[0].trim();
			String value = metaText.split(":")[1].trim();
			dataMap.put(key, value);
		}
		return dataMap;
	}
}
