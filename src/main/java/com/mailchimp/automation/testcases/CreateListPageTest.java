package com.mailchimp.automation.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.mailchimp.automation.pages.CreateListPage;
import com.mailchimp.automation.pages.DashboardPage;
import com.mailchimp.automation.pages.ListCreateSuccessPage;

public class CreateListPageTest {
	public CreateListPageTest() {
		super();

	}

	DashboardPage dashboardPage;
	CreateListPage createListPage;
	ListCreateSuccessPage listCreateSuccessPage;

	@BeforeMethod()
	public void setUp() {
		dashboardPage = new DashboardPage();
		createListPage = dashboardPage.clickOnCreateNewList();
		//createListPage =new CreateListPage();
		listCreateSuccessPage = createListPage.clikOnAddNewList();
	}

	//@Test(priority = 3)
	@Test
	public void verifyCreateNewList() {
		// new LoginPage().loginAction();
		//createListPage.clikOnAddNewList();
		String ss = listCreateSuccessPage.getListCreateSuccessText();
		System.out.println(ss);
		Assert.assertEquals(ss, "Excellent! You have a brand new list.");
	}

	@AfterMethod
	public void tearDown() {

	}

}
