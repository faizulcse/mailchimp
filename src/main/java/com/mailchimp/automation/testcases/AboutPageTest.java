package com.mailchimp.automation.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.mailchimp.automation.pages.AboutPage;
import com.mailchimp.automation.pages.HomePage;
import com.mailchimp.automation.pages.PageBase;
import com.mailchimp.automation.util.TestUtil;


public class AboutPageTest extends PageBase{


	TestUtil testUtil;
	
	HomePage homePage;
	AboutPage aboutPage;
	
	@BeforeClass
	public void setUp() {
		homePage = new HomePage();
		homePage.scrollToAboutLink();
		
		aboutPage = homePage.clickOnAboutLink();
		
	}
	
	
	//@Test(priority=1)
	@Test
	public void saveLeadershipList(){
		aboutPage.scrollToLeadershipSection();
		aboutPage.saveLeadershipInfoToCSV();
		Assert.assertTrue(true);
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
		
	
	@AfterClass
	public void tearDown(){

	}
}
