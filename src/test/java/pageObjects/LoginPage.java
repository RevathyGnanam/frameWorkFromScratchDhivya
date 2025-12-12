package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{

	public LoginPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(id="Email")
	WebElement emailTextBox;

	@FindBy(id="Password")
	WebElement passwordTextBox;

	@FindBy(xpath="//*[@class='button-1 login-button']")
	WebElement loginButton;


	public void clickLoginButton() {
		loginButton.click();
	}


	public void enterEmail(String email) {
		emailTextBox.sendKeys(email);
	}

	public void enterPassword(String password) {
		passwordTextBox.sendKeys(password);
	}


}
