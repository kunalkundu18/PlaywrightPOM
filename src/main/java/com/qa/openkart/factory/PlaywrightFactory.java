package com.qa.openkart.factory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class PlaywrightFactory {
	Playwright playwright;
	Browser browser;
	BrowserContext browserContext;
	Page page;
	Properties prop;
public Page initBrowser(Properties prop) {
	
	String browserName =prop.getProperty("browser");
	System.out.println("The broswer name is :" + browserName);
	playwright =Playwright.create();
	
	
	switch(browserName.toLowerCase()) {
	case "chromium":
		browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(true));
		break;
	case "firefox":
		browser = playwright.firefox().launch(new BrowserType.LaunchOptions().setHeadless(true));
		break;
	case "safari":
		browser = playwright.webkit().launch(new BrowserType.LaunchOptions().setHeadless(true));
		break;
	case "chrome":
		browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setChannel("chrome").setHeadless(true));
		break;
	default:
		System.out.println("enter the correct browser name....");
		break;
	}
	browserContext =browser.newContext();
	page =browserContext.newPage();
	page.navigate(prop.getProperty("url").trim());
	return page;
}

public Properties init_prop()  {
	prop = new Properties();
	try {
		FileInputStream ip = new FileInputStream(System.getProperty("user.dir")+/src/test/resources/config/config.properties");
		
		prop.load(ip);
	} catch (FileNotFoundException e) {
		e.printStackTrace();
	} catch (IOException e) {
		e.printStackTrace();
	}
	
	return prop;
}
}

