package com.qa.crm.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.crm.base.TestBase;

public class ContactsPage extends TestBase {
	String UserName;
	
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
	@FindBy(xpath="//button[text()='Save']")
	WebElement SaveIcon;
	@FindBy(xpath="//div//div[@class='ui secondary pointing menu header-title page-header']//div[@class='ui header item mb5 light-black']")
	WebElement Name;
	public boolean ContactsPageavailable(){
		return ConsPage.isDisplayed();
	}	
	
	
	public String createNewContact(String FirstName,String LastName,String Email) throws InterruptedException
	{
		NewLink.click();
		First_Name.sendKeys(FirstName);
		Last_Name.sendKeys(LastName);
		Email_ID.sendKeys(Email);
		SaveIcon.click();
		Thread.sleep(5001);
		UserName = Name.getText();
		return UserName;
		
		
	}


}
