package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.DemoHomePage;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC002_LoginTestcasesUsingExcel extends BaseClass{

	@Test(dataProvider="LoginData",dataProviderClass=DataProviders.class)
	public void verify_Login(String email,String pass) {
	//Home page	
	HomePage homepage= new HomePage(driver);
	homepage.clickLogin();
	
	//Login Page
	LoginPage lp = new LoginPage(driver);
	lp.enterEmail(email);
	lp.enterPassword(pass);
	
	lp.clickLoginButton();
	
	//Login demo page
	DemoHomePage dp= new DemoHomePage(driver);
	Assert.assertEquals(dp.getWelcomeMessage(), "Welcome to our store");
	Assert.assertTrue(dp.verifyLogoutButton());
	dp.clickLogoutButton();
	
	}
}
