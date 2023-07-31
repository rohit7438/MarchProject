package com.qa.opencart.tests;

import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;

public class AccountPageTest extends BaseTest {

	@BeforeClass
	public void accountPageSetup() {
		accpage = loginpage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
	}

	@Test(enabled = false)
	public void isLogoutLinkVisible() {
		boolean islogoutlinkPresent = accpage.isLogoutLinkVisible();
		Assert.assertEquals(islogoutlinkPresent, true);

	}

	@Test(enabled = false)
	public void isHeadersVisible() {
		List<String> expectedHeaders = new ArrayList<String>();
		expectedHeaders.add(0, "My Account");
		expectedHeaders.add(1, "My Orders");
		expectedHeaders.add(2, "My Affiliate Account");
		expectedHeaders.add(3, "Newsletter");

		List<String> actualheaders = accpage.getAccountPadeHeaders();
		Assert.assertEquals(actualheaders, expectedHeaders);

	}
	
	
	@DataProvider
	public Object[][] searchDataProvider() {
		return new Object[][] {
			{"macbook", 3},
			{"imac", 1},
			{"samsung", 2}
			
		};
	}

	@Test(enabled = false, dataProvider = "searchDataProvider")
	public void verifyProductImages(String productName, int expectedcount) {
		searchpage = accpage.doSearch(productName);
		int actualsize = searchpage.getSearchResultCount();
		Assert.assertEquals(actualsize, expectedcount);
		
		
		
	}
	

	@Test(enabled = true)
	public void verifyProductMetaData(String productName, int expectedcount) {
		searchpage = accpage.doSearch("macbook");
		int actualsize = searchpage.getSearchResultCount();
		Assert.assertEquals(actualsize, expectedcount);
		
		
		
	}

}
