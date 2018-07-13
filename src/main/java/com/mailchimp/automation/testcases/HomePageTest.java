package com.mailchimp.automation.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.mailchimp.automation.util.*;
import com.mailchimp.automation.base.TestBase;
import com.mailchimp.automation.pages.*;

public class HomePageTest extends TestBase{
	TestUtil testUtil;
	HomePage homePage;
	
	public HomePageTest() {
		super();
	}
	
	//test cases should be separated -- independent with each other
	//before each test case -- launch the browser and login
	//@test -- execute test case
	//after each test case -- close the browser
	
	@BeforeMethod
	public void setUp() {
		initialization();
		testUtil = new TestUtil();
		homePage = new HomePage();
	}
	
	
	@Test(priority=1)
	public void verifyHomePageTitleTest(){
		String homePageTitle = homePage.verifyHomePageTitle();
		Assert.assertEquals(homePageTitle, "Marketing Platform for Small Businesses - Sell More Stuff | MailChimp","Home page title not matched");
	}
	
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
}
