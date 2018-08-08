package com.mailchimp.automation.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.mailchimp.automation.pages.HomePage;
import com.mailchimp.automation.pages.LoginPage;

public class LoginPageTest {

	public LoginPageTest() {
		super();
	}

	LoginPage loginPage;
	HomePage homePage;

	@BeforeMethod()
	public void setUp() {
		// loginPage = new LoginPage();
		 homePage = new HomePage();	//homePage object create -faizul

		// homePage = new HomePage();
		// homePage.scrollToAboutLink();

		loginPage = homePage.clickOnLoginLink();	//loginPage object create & homepage action -faizul

	}

	//@Test(priority = 1)
	@Test
	public void verifyLoginSuccessfully() {

		String title = loginPage.getLoginPageTitle();
		System.out.println(title);
		Assert.assertEquals(title, "Login | MailChimp - email marketing made easy");

	}

	@AfterMethod
	public void tearDown() {

	}

}
