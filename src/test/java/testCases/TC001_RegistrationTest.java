package testCases;

import java.time.Duration;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC001_RegistrationTest extends BaseClass {

	@Test(groups= {"Regression","Sanity"})
	public void verify_Registration_Flow() {
		//Home Page
		HomePage homepage = new HomePage(driver);
		homepage.clickRegister();

		//Account creation page
		AccountRegistrationPage accpage = new AccountRegistrationPage(driver);
		accpage.selectFemaleBulletButton();
		accpage.enterFirstName(randomString());
		accpage.enterLastName(randomString());
		accpage.enterEmail(randomAlphaNumerics()+"@gmail.com");
		String password = randomAlphaNumeric();
		accpage.enterPassword(password);
		accpage.enterConfirmPassword(password);
		accpage.clickRegisterButton();
		//String confirmmsg = accpage.getConfirmationMessage();
		//Assert.assertEquals(confirmmsg, "Your registration completed");
		Assert.assertEquals(accpage.getConfirmationMessage(), "Your registration completed");
		accpage.clickContinueButton();

	}




}
