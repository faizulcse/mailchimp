package com.mailchimp.automation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogoutPage extends PageBase {
	public LogoutPage() {
		PageFactory.initElements(driver, this);
	}
	
	

	@FindBy(xpath = "//*[@id=\"login\"]/div[1]/div[1]/div[1]/div/div/div/div/div[2]/h4")
	WebElement logoutSuccessText;

	
	
	public String getLogoutSuccessText() {
		return logoutSuccessText.getText();
	}
}
