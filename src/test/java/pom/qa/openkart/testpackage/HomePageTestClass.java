package pom.qa.openkart.testpackage;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.openkart.base.BaseTest;
import com.qa.openkart.constants.ApplicationConts;

public class HomePageTestClass extends BaseTest {
	
	
	@Test(priority =1)
	public void getHomePageTitle() {
		String actualTitle =homePage.HomePageTitle();
		Assert.assertEquals(actualTitle, ApplicationConts.HOME_PAGE_TITLE);
	}
	@Test(priority=2)
	public void getHomePageURL() {
		String actualURL =homePage.HomePageUrl();
		Assert.assertEquals(actualURL, prop.getProperty("url"));
	}
	
	@DataProvider
	public Object[][] getProductData() {
		return new Object[][] {
			{"Macbook"},
			{"imac"},
			{"Samsung"}
		};
	}
	@Test(priority = 3,dataProvider = "getProductData")
	public void getHomePageHeader(String prodName) {
		String actualHeader =homePage.doSearch(prodName);
		Assert.assertEquals(actualHeader,"Search - " + prodName);
	}
	
	
	
	
	
	
}
