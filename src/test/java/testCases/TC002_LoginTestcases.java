package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.DemoHomePage;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import testBase.BaseClass;

public class TC002_LoginTestcases extends BaseClass{

	@Test(groups= {"Regression"})
	public void verify_Login() {
	//Home page	
	HomePage homepage= new HomePage(driver);
	homepage.clickLogin();
	
	//Login Page
	LoginPage lp = new LoginPage(driver);
	lp.enterEmail(p.getProperty("username"));
	lp.enterPassword(p.getProperty("password"));
	
	lp.clickLoginButton();
	
	//Login demo page
	DemoHomePage dp= new DemoHomePage(driver);
	Assert.assertEquals(dp.getWelcomeMessage(), "Welcome to our store");
	Assert.assertTrue(dp.verifyLogoutButton());
	
	}
}
