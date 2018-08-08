package com.mailchimp.automation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashboardPage extends PageBase {

	public DashboardPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//*[@id=\"uniqName_3_0\"]/div/nav[2]/ul/li[3]/a")
	WebElement userButton;

	@FindBy(linkText="Log Out")//xpath = "//*[@id=\"uniqName_4_1\"]/div/nav/ul/li[5]/a"
	WebElement logOutButton;

	@FindBy(xpath = "//*[@id=\"uniqName_3_0\"]/div/nav[1]/ul/li[5]/a")
	WebElement listsButton;

	@FindBy(xpath = "//*[@id=\"uniqName_3_0\"]/div/nav[1]/ul/li[4]/a")
	WebElement templatesButton;

	@FindBy(xpath = "//*[@id=\"uniqName_3_0\"]/div/nav[1]/ul/li[3]/a")
	WebElement campaignsButton;

	@FindBy(xpath = "//*[@id=\"freddielink\"]/img")
	WebElement homeImgButton;
	
	@FindBy(xpath = "//*[@id=\"uniqName_3_0\"]/div/nav[2]/ul/li[3]/a/div[2]/span[1]")
	WebElement currntUser;

	public void clickUser() {
		userButton.click();
	}

	public void clickHome() {
		homeImgButton.click();
	}

	public void clickCampaign() {
		campaignsButton.click();
	}

	public void clickTemplate() {
		templatesButton.click();
	}

	public CreateListPage clickOnCreateNewList() {
		listsButton.click();
		return new CreateListPage();
	}

	public LogoutPage logOutAction() {
		clickUser();
		logOutButton.click();
		return new LogoutPage();
		// return new LoginPage();
	}

	public void clickBack() {
		driver.navigate().back();
	}


	public String getUser() {
		return currntUser.getText();
	}

}
