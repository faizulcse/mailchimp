package com.mailchimp.automation.pages;

import org.openqa.selenium.WebDriver;

import com.mailchimp.automation.suite.TestHelper;

public class PageBase {
	public WebDriver driver;
	
	public PageBase() {
		driver = TestHelper.getInstance().getCurrentDriver();
	}
	
	public void waitFor(double second) {
		try {
			Thread.sleep((int) (1000 * second));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
