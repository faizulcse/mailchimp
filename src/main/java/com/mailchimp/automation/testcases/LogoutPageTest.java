package com.mailchimp.automation.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.mailchimp.automation.pages.CreateListPage;
import com.mailchimp.automation.pages.DashboardPage;
import com.mailchimp.automation.pages.ListCreateSuccessPage;
import com.mailchimp.automation.pages.LoginPage;
import com.mailchimp.automation.pages.LogoutPage;

public class LogoutPageTest {
	public LogoutPageTest() {

	}

	LogoutPage logoutPage;
	ListCreateSuccessPage listCreateSuccessPage;

	@BeforeMethod()
	public void setUp() {
		// CreateListPage createListPage=new CreateListPage();
		listCreateSuccessPage = new ListCreateSuccessPage();
		logoutPage = listCreateSuccessPage.clickLogout();

	}

	// @Test(priority = 4)
	@Test
	public void verifyLogOutSuccessfully() {
		
		//logoutPage.getLogoutSuccessText();
		String ss = logoutPage.getLogoutSuccessText();
		System.out.println(ss);
		Assert.assertEquals(ss, "You've been logged out.");
	}

	@AfterMethod
	public void tearDown() {

	}
}
