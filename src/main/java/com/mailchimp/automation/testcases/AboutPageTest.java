package com.mailchimp.automation.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;

import com.mailchimp.automation.util.*;
import com.mailchimp.automation.base.TestBase;
import com.mailchimp.automation.pages.*;

public class AboutPageTest extends TestBase{

	TestUtil testUtil;
	
	HomePage homePage;
	AboutPage aboutPage;
	
	public AboutPageTest(){
		super();	
	}
	
	@BeforeMethod
	public void setUp() {
		
		initialization();
		
		homePage = new HomePage();
		homePage.scrollToAboutLink();
		TestUtil.waitFor(5);
		aboutPage = homePage.clickOnAboutLink();
	}
	
	
	@Test(priority=1)
	public void saveLeadershipList(){
		TestUtil.waitFor(5);
		aboutPage.scrollToLeadershipSection();
		TestUtil.waitFor(5);
		aboutPage.saveLeadershipInfoToCSV();
		//Assert.assertTrue(true);
	}
	
//	@Test(dataProvider="LeadersDataProvider")
//	public void testLeadership(String leaderName,String designation) {
//
//		Assert.assertTrue(aboutPage.checkLeaderName(leaderName) && aboutPage.checkLeaderDesignation(leaderName));
//	}
//	
//	@DataProvider(name="LeadersDataProvider")
//    public Object[][] getDataFromDataprovider(){
//    return new Object[][] 
//    	{
//            { "Ben Chestnut", "Co-founder and Chief Executive Officer" },
//            { "Dan Kurzius","Co-founder and Chief Customer Officer" },
//            { "Farrah Kennedy","Chief Operating Officer" }
//        };
//
//    }
		
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
}
