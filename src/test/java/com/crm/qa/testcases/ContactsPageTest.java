package com.crm.qa.testcases;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.crm.base.TestBase;
import com.qa.crm.pages.ContactsPage;
import com.qa.crm.pages.HomePage;
import com.qa.crm.pages.LoginPage;
import com.qa.crm.util.TestUtil;

public class ContactsPageTest extends TestBase {
	LoginPage loginpage;
	HomePage homepage;
	ContactsPage contactspage;
	@BeforeMethod
	public void setUp()
	{
		initialization();
		loginpage = new LoginPage();
		homepage = loginpage.login(prop.getProperty("username"),prop.getProperty("password"));
		contactspage = homepage.ClickonContactsPage();
	}
	
	@Test(priority=1)
	public void verifyContactsPage()
	{
		boolean var = contactspage.ContactsPageavailable();
		Assert.assertEquals(var, true);
	}
	@DataProvider
	public Object[][] getData()
	{
		Object[][] data = TestUtil.getTestData("contacts");
		
		return data;
	}
	@Test(priority=2,dataProvider="getData")
	public void verifyContactareadded(String FirstName,String LastName,String Email)
	{
		contactspage.createNewContact(FirstName, LastName, Email);
	}
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}

}
