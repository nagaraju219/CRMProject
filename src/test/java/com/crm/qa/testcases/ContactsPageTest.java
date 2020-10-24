package com.crm.qa.testcases;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.qa.crm.base.TestBase;
import com.qa.crm.pages.ContactsPage;
import com.qa.crm.pages.HomePage;
import com.qa.crm.pages.LoginPage;
import com.qa.crm.util.TestUtil;

public class ContactsPageTest extends TestBase {
	public static Logger Log = LogManager.getLogger(TestBase.class.getClass());
	
	LoginPage loginpage;
	HomePage homepage;
	ContactsPage contactspage;
	SoftAssert softAssert = new SoftAssert();
	@BeforeMethod
	public void setUp()
	{
		initialization();
		loginpage = new LoginPage();
		homepage = loginpage.login(prop.getProperty("username"),prop.getProperty("password"));
		contactspage = homepage.ClickonContactsPage();
		Log.info("In the SetUp Method");
	}
	
	@Test(priority=1)
	public void verifyContactsPage()
	{
		boolean var = contactspage.ContactsPageavailable();
		Log.info("Verify Contacts Page Run Successfully");
		Assert.assertEquals(var, true);
		Log.info("Verify Contacts Page was Pass");
	}
	@DataProvider(name="ContactsData")
	public Object[][] getData()
	{
		Object[][] data = TestUtil.getTestData("contacts");
		
		return data;
	}
	@Test(priority=2,dataProvider="ContactsData")
	public void verifyContactareadded(String FirstName,String LastName,String Email) throws InterruptedException
	{
		Thread.sleep(5000);
		String user_name = contactspage.createNewContact(FirstName, LastName, Email);
		softAssert.assertEquals(FirstName, user_name);
		softAssert.assertAll();
		}
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}

}
