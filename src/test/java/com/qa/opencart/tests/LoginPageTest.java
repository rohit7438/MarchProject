package com.qa.opencart.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.qa.opencart.base.BaseTest;
import com.qa.opencart.pages.AccountsPage;

public class LoginPageTest extends BaseTest {

	@Test
	public void login() {
		AccountsPage title = loginpage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
		Assert.assertEquals(title, "My Account");

	}

}
