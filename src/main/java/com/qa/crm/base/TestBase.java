package com.qa.crm.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.qa.crm.util.TestUtil;

public class TestBase {
	
	//This is the TestBaseClass
	public static WebDriver driver;
	public static Properties prop;
	static FileInputStream fis = null;
	static String UserDir = System.getProperty("user.dir");
	public TestBase()
	{
		prop = new Properties();
		
		try {
			fis = new FileInputStream(UserDir+"\\src\\main\\resources\\config\\config.properties");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			prop.load(fis);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void initialization()
	{
		String browserName = prop.getProperty("browsername");
		if(browserName.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver",UserDir+ "\\src\\main\\resources\\drivers\\chromedriver.exe");
			driver = new ChromeDriver();
			
		}
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
	}
	

}
