package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.crm.base.TestBase;
import com.qa.crm.pages.HomePage;
import com.qa.crm.pages.LoginPage;

public class LoginPageTest extends TestBase {
	LoginPage loginpage;
	HomePage homepage;
	
	public LoginPageTest()
	{
		super();
	}

	@BeforeMethod
	public void setUp()
	{
		initialization();
		loginpage = new LoginPage();
	}
	@Test(priority=1)
	public void ValidateLoginPageTitle()
	{
		String Title = loginpage.LoginPageTitle();
		Assert.assertEquals(Title, "Cogmento CRM");
	}
	@Test(priority=2)
	public void LoginFunctionalityTest()
	{
		homepage = loginpage.login(prop.getProperty("username"),prop.getProperty("password"));
	}
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}

	
}
