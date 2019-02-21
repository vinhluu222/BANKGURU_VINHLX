package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUIs.LoginPageUI;

public class LoginPageObject extends AbstractPage{
	private WebDriver driver;
	
	public LoginPageObject(WebDriver driverMapping) {
		driver = driverMapping;
	}
	
	public void inputToUserTextbox(String userID) {
		waitToElementVisible(driver, LoginPageUI.USERID_TEXTBOX);
		sendKeysToElement(driver, LoginPageUI.USERID_TEXTBOX, userID);		
	}
	
	public void inputToPasswordTextbox(String password) {
		waitToElementVisible(driver, LoginPageUI.PASSWORD_TEXTBOX);
		sendKeysToElement(driver, LoginPageUI.PASSWORD_TEXTBOX, password);
		
	}
	
	public HomePageObject clickToLoginBtn() {
		waitToElementVisible(driver, LoginPageUI.LOGIN_BTN);
		clickToElement(driver, LoginPageUI.LOGIN_BTN);
		return PageFactoryManager.getHomePage(driver);
	}
	
	public String getLoginPageUrl(WebDriver driver) {
		return getCurrentUrl(driver);
	}
	
	public RegisterPageObject clickToHereLink() {
		waitToElementVisible(driver, LoginPageUI.HERE_LINK);
		clickToElement(driver, LoginPageUI.HERE_LINK);
		return PageFactoryManager.getRegisterPage(driver);
	}
}
