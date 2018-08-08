package com.mailchimp.automation.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.mailchimp.automation.pages.DashboardPage;
import com.mailchimp.automation.pages.LoginPage;

public class DashboardPageTest {
	public DashboardPageTest() {
		super();
	}

	DashboardPage dashBoard;
	LoginPage loginPage;

	@BeforeMethod()
	public void setUp() {
		loginPage = new LoginPage();
		dashBoard = loginPage.loginAction();
	}

	//@Test(priority = 2)
	@Test
	
	public void verifyDashBoardSuccessfully() {
		//new LoginPage().loginAction();
		String mcUser = dashBoard.getUser();
		System.out.println(mcUser);
		Assert.assertEquals(mcUser, "Root");
	}

	@AfterMethod
	public void tearDown() {

	}

}