package com.qa.openkart.pages;

import com.microsoft.playwright.Page;

public class LoginPage {
	
	private Page page;
	
	
	private String emailId = "//input[@id='input-email']";
	private String password = "//input[@id='input-password']";
	private String loginBtn = "//input[@value='Login']";
	//private String myOrders = "h2:nth-child(1)";
	private String logoutLink = "li[class='dropdown open'] li:nth-child(5) a:nth-child(1)";
	private String myAccountBtn = "a[title='My Account'] span[class='hidden-xs hidden-sm hidden-md']";
	
	public LoginPage(Page page) {
		this.page =page;
	}
	public String getLoginPageTitle() {
		String title = page.title();
		System.out.println("page title:" + title);
		return title;
	}
	
	public String getLoginPageURL() {
		String url = page.url();
		System.out.println("page url:" + url);
		return url;
	}
	public boolean doLogin(String appUserName, String appPassword) {
	System.out.println("App creds:" + appUserName + ":" + appPassword);
	page.fill(emailId, appUserName);
	page.fill(password, appPassword);
	page.click(loginBtn);
	page.click(myAccountBtn);
	if(page.isVisible(logoutLink)) {
		System.out.println("The user has successfully logged in");return true;
	} else {
		 return false;
	}
	
	}
}
