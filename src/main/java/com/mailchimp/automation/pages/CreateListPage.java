package com.mailchimp.automation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateListPage extends PageBase {

	public CreateListPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "add-list-btn")
	WebElement createListBtn;
	@FindBy(xpath = "//*[@id=\"list-or-group\"]/div/div/a[1]")
	WebElement createListPopBtn;
	@FindBy(id = "name")
	WebElement listName;
	@FindBy(id = "default-fromemail")
	WebElement defaultEmail;
	@FindBy(id = "from_name")
	WebElement defaultName;
	@FindBy(id = "description")
	WebElement description;
	@FindBy(id = "company")
	WebElement company;
	@FindBy(id = "address1")
	WebElement address1;
	@FindBy(id = "city")
	WebElement city;
	@FindBy(id = "zip")
	WebElement zip;

	@FindBy(id = "country")
	WebElement country;
	@FindBy(xpath = "//*[text()=\"India\"]")
	WebElement countryname;

	@FindBy(id = "phone")
	WebElement phone;
	@FindBy(id = "double-optin")
	WebElement doubleOptIn;
	@FindBy(id = "new-list-save")
	WebElement newListSave;
	@FindBy(id = "new-list-cancel")
	WebElement newListCancel;

	public void clickOnSaveNewList() {//Excellent! You have a brand new list.
		newListSave.click();////*[@id="new-list-response"]/p
	}

	public void clickOnCancelNewList() {
		newListCancel.click();
	}

	public void clickOnDoubleOptIn() {
		if (!doubleOptIn.isSelected()) {
			doubleOptIn.click();
		}
	}

	public String getTitle() {
		return driver.getTitle();
	}

	public ListCreateSuccessPage clikOnAddNewList() {
		createListBtn.click();
		createListPopBtn.click();
		listName.clear();
		listName.sendKeys("ListAuto1");
		defaultEmail.clear();
		defaultEmail.sendKeys("rootnextsqa@gmail.com");
		defaultName.clear();
		defaultName.sendKeys("RootNext");
		description.clear();
		description.sendKeys("Custom description");
		company.clear();
		company.sendKeys("RN Solutions");
		address1.clear();
		address1.sendKeys("Mirpur-12 Dohs");
		city.clear();
		city.sendKeys("Dhaka");
		zip.clear();
		zip.sendKeys("1216");
		country.click();
		countryname.click();
		phone.clear();
		phone.click();
		clickOnDoubleOptIn();
		clickOnSaveNewList();
		return new ListCreateSuccessPage();
	}

}
