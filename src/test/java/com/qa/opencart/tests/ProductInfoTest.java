package com.qa.opencart.tests;


import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;

public class ProductInfoTest extends BaseTest {

	@BeforeClass
	public void productInfoSetup() {
		accpage = loginpage.doLogin(prop.getProperty("username"), prop.getProperty("password"));

	}

	@DataProvider
	public Object[][] productANdImagesData() {
		return new Object[][] {

				{ "MacBook", 5 }, { "MacBook Pro", 4 }, { "MacBook Air", 4 }

		};

	}

	@Test(dataProvider = "productANdImagesData", enabled = false)
	public void verifyProductImages(String productName, int count) {
		searchpage = accpage.doSearch(productName);
		productdetailspage = searchpage.selectProduct(productName);
		int totalImages = productdetailspage.productImagesCount();
		Assert.assertEquals(totalImages, count);

	}

	@Test(enabled = true)
	public void verifyProductMeatData() {
		searchpage = accpage.doSearch("MacBook");
		productdetailspage = searchpage.selectProduct("MacBook");
		Map<String, String> ActualMetaData = productdetailspage.productMetaData();
		System.out.println(ActualMetaData);
		
		
		
		sofeassert.assertEquals(ActualMetaData.get("Brand"), "Apple");
		sofeassert.assertEquals(ActualMetaData.get("Product Code"), "Product 16");
		sofeassert.assertEquals(ActualMetaData.get("Reward Points"), "600");
		sofeassert.assertEquals(ActualMetaData.get("Availability"), "In Stock");
		sofeassert.assertAll();
	}

}
