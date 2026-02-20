package com.qa.openkart.base;

import java.util.Properties;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.microsoft.playwright.Page;
import com.qa.openkart.factory.PlaywrightFactory;
import com.qa.openkart.pages.HomePage;
import com.qa.openkart.pages.LoginPage;

public class BaseTest {
	PlaywrightFactory pf;
	Page page;
	protected Properties prop;
	
	
	protected HomePage homePage;
	protected LoginPage loginPage;
	
	@BeforeTest
	public void setup() {
		prop = new Properties();
		pf = new PlaywrightFactory();
		prop =pf.init_prop();
		page =pf.initBrowser(prop);
		homePage = new HomePage(page);
	}
	
	
	
	
	
	@AfterTest
	public void tearDown() {
	page.context().browser().close();
	}

}
