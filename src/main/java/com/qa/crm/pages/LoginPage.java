package com.qa.crm.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.crm.base.TestBase;

public class LoginPage extends TestBase {
	
	@FindBy(name="email")
	WebElement UserName;
	
	@FindBy(name="password")
	WebElement Password;
	
	@FindBy(xpath="//div[text()='Login']")
	WebElement LoginBtn;
	
	@FindBy(xpath="//a[text()='Sign Up']")
	WebElement SignUp;
	
	public LoginPage()
	{
		PageFactory.initElements(driver,this );
	}
	
	public String LoginPageTitle()
	{
		return driver.getTitle();
	}
	public HomePage login(String UN,String PW)
	{
		UserName.sendKeys(UN);
		Password.sendKeys(PW);
		LoginBtn.click();
		return new HomePage();
	}

	
}

