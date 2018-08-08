package com.mailchimp.automation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ListCreateSuccessPage extends PageBase {

	public ListCreateSuccessPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//*[@id=\"new-list-response\"]/p")
	WebElement listCreateSuccessText;

	@FindBy(xpath = "//*[@id=\"uniqName_14_0\"]/div/nav[2]/ul/li[3]/a/div[2]/span[1]") //
	WebElement userButton;

	@FindBy(linkText="Log Out") //xpath = "//*[@id=\"uniqName_15_1\"]/div/nav/ul/li[5]/a"
	WebElement logOutButton;

	public LogoutPage clickLogout() {
		userButton.click();
		logOutButton.click();
		return new LogoutPage();
	}

	public String getListCreateSuccessText() {
		return listCreateSuccessText.getText();
	}

}
