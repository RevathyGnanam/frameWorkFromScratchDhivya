package pageObjects;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AccountRegistrationPage extends BasePage {

	public AccountRegistrationPage(WebDriver driver) {
		super(driver);
	}
	 @FindBy(id="gender-female")
	 WebElement femaleBulletButton;
	 
	 @FindBy(id="FirstName")
	 WebElement firstNameTextBox;
	 
	 @FindBy(id="LastName")
	 WebElement lastNameTextBox;
	 
	 @FindBy(id="Email")
	 WebElement emailTextBox;
	 
	 @FindBy(id="Password")
	 WebElement passwordTextBox;
	 
	 @FindBy(id="ConfirmPassword")
	 WebElement confirmPasswordTextBox;
	 
	 @FindBy(id="register-button")
	 WebElement registerButton;
		 
	 @FindBy(xpath="//*[contains(text(),'Your registration completed')]")
	 WebElement successMsgText;
	 
	 @FindBy(xpath="//*[@class='button-1 register-continue-button']")
	 WebElement continueButton;
	 
	 
	 public void selectFemaleBulletButton() {
		 femaleBulletButton.click();
	 }
	 
	 public void enterFirstName(String fname) {
		 firstNameTextBox.sendKeys(fname);
	 }
	 
	 public void enterLastName(String lname) {
		 lastNameTextBox.sendKeys(lname);
	 }
	 
	 public void enterEmail(String email) {
		 emailTextBox.sendKeys(email);
	 }
	 
	 public void enterPassword(String password) {
		 passwordTextBox.sendKeys(password);
	 }
	 public void enterConfirmPassword(String password) {
		 confirmPasswordTextBox.sendKeys(password);
	 }
		 
	 public void clickRegisterButton() {
		 registerButton.click();
	 }
	 public String getConfirmationMessage() {
		 return successMsgText.getText();
	 }
	 
	 public void clickContinueButton() {
		 //sol 1
		 continueButton.click();
		 
		 //sol 2
//		 continueButton.submit();
//		 
//		 //sol 3
//		 Actions act = new Actions(driver);
//		 act.moveToElement(continueButton).click().perform();
//		 
//		 //sol 4:
//		 continueButton.sendKeys(Keys.RETURN);
//		 
//		 //sol 5:
//	    JavascriptExecutor js = (JavascriptExecutor)driver;
//	    js.executeScript("argument[0].click();", continueButton);
//	    
//	    //sol 6:
//	    WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
//	    wait.until(ExpectedConditions.elementToBeClickable(continueButton)).click();
//		 
		 
	 }

}
