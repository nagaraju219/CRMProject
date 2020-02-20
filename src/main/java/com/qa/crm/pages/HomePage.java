package com.qa.crm.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.crm.base.TestBase;

public class HomePage extends TestBase {
	
	public HomePage()
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//div//span[text()='Nagaraju Madupu']")
	WebElement userNameLabel;
	@FindBy(xpath="//div//a//span[text()='Contacts']")
	static
	WebElement ContactsLink;
	@FindBy(xpath="//div//a//span[text()='Deals']")
	static
	WebElement DealsLink;
	
	
	
	public String HomePageTitle()
	{
		return driver.getTitle();
	}
	
	public ContactsPage ClickonContactsPage()
	{
		ContactsLink.click();
		return new ContactsPage();
	}
	
	public DealsPage DealsContactsPage()
	{
		DealsLink.click();
		return new DealsPage();
	}
	
	public boolean CorrectUserLoggedIn()
	{
		return userNameLabel.isDisplayed();	
	}

	
}
