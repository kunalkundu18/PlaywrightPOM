package com.qa.openkart.pages;

import com.microsoft.playwright.Page;

public class HomePage {
	
	private Page page;
	
	//1 Storing locators
	private String search = "input[name='search']";
	private String searchButton = "div#search button";
	private String searchPageHeader = "div#content h1";
	private String loginButton = "//ul[@class='dropdown-menu dropdown-menu-right']//a[normalize-space()='Login']";
	private String myAccountBtn = "a[title='My Account'] span[class='hidden-xs hidden-sm hidden-md']";
	
	
	
	
	
	//2 Page constructor
	
	public HomePage(Page page) {
		this.page = page;
	}
	
	
	
	//3 performing test/methods
	public String HomePageTitle() {
		String title = page.title();
		System.out.println("the title is :" + title);
		return title;
		
	}
	public String HomePageUrl() {
		String url= page.url();
		System.out.println("the url of the page is :" + url);
		return url;
	}
	
	public String doSearch(String prodName) {
		page.fill(search,prodName );
		page.click(searchButton);
		String header = page.textContent(searchPageHeader);
		System.out.println("the header of the page is :" + header);
		return header;
	}
	
	public LoginPage navigateToLoginPage() {
		page.click(myAccountBtn);
		page.click(loginButton);
		return new LoginPage(page);
	}
}
