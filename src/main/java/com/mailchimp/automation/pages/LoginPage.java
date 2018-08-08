package com.mailchimp.automation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends PageBase {

	public LoginPage() {
		PageFactory.initElements(driver, this);
	}

	private String user = "rootnext33";
	private String pass = "4shared-D";

	@FindBy(id = "username")
	WebElement userName;

	@FindBy(id = "password")
	WebElement passWord;

	@FindBy(tagName = "button")
	WebElement loginButton;

	@FindBy(xpath = "//*[@id=\"stay-signed-in\"]")
	WebElement checkBox;

//	@FindBy(xpath = "//*[@id=\"login-form\"]/fieldset/div[2]/div/label")
//	WebElement showPassWord;

	@FindBy(xpath = "//*[@id=\"login-form\"]/div/p/a")
	WebElement createAccountLink;

	@FindBy(xpath = "//*[@id=\"login-form\"]/fieldset/div[5]/p[1]/a")
	WebElement forgotUsernameLink;

	@FindBy(xpath = "//*[@id=\"login-form\"]/fieldset/div[5]/p[2]/a")
	WebElement forgotPasswordLink;

	@FindBy(xpath = "//*[@id=\"dijit__WidgetBase_1\"]")
	WebElement cookiesPrefLink;

	@FindBy(xpath = "//*[@id=\"login\"]/div[1]/div[1]/div[2]/div/p/span/a[1]")
	WebElement privacyLink;

	@FindBy(xpath = "//*[@id=\"login\"]/div[1]/div[1]/div[2]/div/p/span/a[2]")
	WebElement TermsLink;

	@FindBy(xpath = "//*[@id=\"billboard-cta-button\"]")
	WebElement theDeal;

	public void clickShowPass() {
		// *[@id="show-password"]
		// showPassWord.click();
	}

	public void clickCheckBox() {

		if (!checkBox.isSelected()) {
			checkBox.click();
		}
	}

	public DashboardPage loginAction() {

		userName.clear();
		userName.sendKeys(user);
		passWord.clear();
		passWord.sendKeys(pass);
		// showPassWord.click();

		clickCheckBox();
		waitFor(2);
		loginButton.click();

		return new DashboardPage();

	}

	public void checkOnLoginPageLink() {
		createAccountLink.click();
		driver.navigate().back();

		forgotUsernameLink.click();
		driver.navigate().back();

		forgotPasswordLink.click();
		driver.navigate().back();

		cookiesPrefLink.click();
		driver.navigate().back();

		privacyLink.click();
		driver.navigate().back();

		TermsLink.click();
		driver.navigate().back();

	}

	public String getLoginPageTitle() {

		return driver.getTitle();
	}

}
