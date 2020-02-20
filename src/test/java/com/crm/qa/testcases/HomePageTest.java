package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.crm.base.TestBase;
import com.qa.crm.pages.ContactsPage;
import com.qa.crm.pages.HomePage;
import com.qa.crm.pages.LoginPage;

public class HomePageTest extends TestBase{
	LoginPage loginpage;
	HomePage homepage;
	ContactsPage contactspage;
	public HomePageTest()
	{
		super();
	}
	@BeforeMethod
	public void setUp()
	{
		initialization();
		loginpage = new LoginPage();
		homepage = loginpage.login(prop.getProperty("username"),prop.getProperty("password"));
	}
	@Test(priority=1)
	public void verifyHomePageTitleTest()
	{
		String Title = homepage.HomePageTitle();
		Assert.assertEquals(Title, "Cogmento CRM","Home page title not match");
	}
	@Test(priority=2)
	public void verifyCorrectUserLoggedIn()
	{
		Assert.assertTrue(homepage.CorrectUserLoggedIn());
	}
	@Test(priority=3)
	public void verifyContactsPageisClicked()
	{
		contactspage = homepage.ClickonContactsPage();
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
	

}
