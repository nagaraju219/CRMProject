package com.qa.crm.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.crm.base.TestBase;

public class ContactsPage extends TestBase {
	
	public ContactsPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//div[text()='Contacts']")
	WebElement ConsPage;
	@FindBy(xpath="//button[text()='New']")
	WebElement NewLink;
	@FindBy(name="first_name")
	WebElement First_Name;
	@FindBy(name="last_name")
	WebElement Last_Name;
	@FindBy(xpath="//input[@placeholder='Email address']")
	WebElement Email_ID;
	@FindBy(xpath="//i[@class='save icon']")
	WebElement SaveIcon;
	
	
	
	public boolean ContactsPageavailable(){
		return ConsPage.isDisplayed();
	}	
	public void createNewContact(String FirstName,String LastName,String Email)
	{
		NewLink.click();
		First_Name.sendKeys(FirstName);
		Last_Name.sendKeys(LastName);
		Email_ID.sendKeys(Email);
		SaveIcon.click();
	}


}
