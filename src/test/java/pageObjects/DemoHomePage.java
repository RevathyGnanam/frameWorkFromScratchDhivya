package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DemoHomePage extends BasePage {

	public DemoHomePage(WebDriver driver) {
		super(driver);

	}

	@FindBy(xpath="//*[contains(text(),'Welcome to our store')]")
	WebElement welcomeMsgText;

	@FindBy(xpath="//*[@class='ico-logout']")
	WebElement logoutButton;


	public String getWelcomeMessage() {
		return welcomeMsgText.getText();
	}

	public void clickLogoutButton() {
		logoutButton.click();
	}
	
	public boolean verifyLogoutButton() {
	return logoutButton.isDisplayed();	
	}
	


}
