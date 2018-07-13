package com.mailchimp.automation.testcases;

import java.io.IOException;

import org.apache.log4j.PropertyConfigurator;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.log4testng.Logger;

import com.mailchimp.automation.util.*;
import com.mailchimp.automation.base.TestBase;
import com.mailchimp.automation.pages.*;

public class AboutPageTest extends TestBase{

	TestUtil testUtil;
	
	HomePage homePage;
	AboutPage aboutPage;
	
	String sheetName = "abouts";
	
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
	}
		
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
}
