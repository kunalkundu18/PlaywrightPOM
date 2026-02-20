package pom.qa.openkart.testpackage;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.openkart.base.BaseTest;
import com.qa.openkart.constants.ApplicationConts;

public class LoginPageTest  extends BaseTest{
	
	
	@Test(priority = 1)
	public void loginPageNavigationTest() {
		loginPage =homePage.navigateToLoginPage();
		String actualLoginPAgeTitle =loginPage.getLoginPageTitle();
		System.out.println("login page title:" + actualLoginPAgeTitle);
		Assert.assertEquals(actualLoginPAgeTitle,ApplicationConts.LOGIN_PAGE_TITLE);
	}
	@Test(priority = 2)
	public void userLogin() {
		loginPage.doLogin(prop.getProperty("username").trim(),
				prop.getProperty("password").trim() );
	
	}
	
}
