package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import commons.Constant;
import pageUIs.NewCustomerPageUI;

public class NewCustomerPageObject extends AbstractPage{
private WebDriver driver;
	
	public NewCustomerPageObject(WebDriver driverMapping) {
		driver = driverMapping;
	}
	
	public boolean isNewCustomerPageDisplayed() {
		return isControlDisplayed(driver, NewCustomerPageUI.CHECK_PAGE_TEXT);
	}
	
	public boolean isRegisteredSuccessfully() {
		return isControlDisplayed(driver, NewCustomerPageUI.REGISTERED_MSG);
	}
	
	public void inputToCustomerNameTextbox() {
		waitToElementVisible(driver, NewCustomerPageUI.CUSTOMER_NAME_TEXTBOX);
		sendKeysToElement(driver, NewCustomerPageUI.CUSTOMER_NAME_TEXTBOX, Constant.CUSTOMER_NAME);
	}
	
	public void inputToDobBox() {
		waitToElementVisible(driver, NewCustomerPageUI.DOB_BOX);
		sendKeysToElement(driver, NewCustomerPageUI.DOB_BOX, Constant.DATE_OF_BIRTH);
	}
	
	public void inputToAddressTextbox() {
		waitToElementVisible(driver, NewCustomerPageUI.ADDRESS_TEXTBOX);
		sendKeysToElement(driver, NewCustomerPageUI.ADDRESS_TEXTBOX, Constant.ADDRESS);
	}
	
	public void inputToCityTextbox() {
		waitToElementVisible(driver, NewCustomerPageUI.CITY_TEXTBOX);
		sendKeysToElement(driver, NewCustomerPageUI.CITY_TEXTBOX, Constant.CITY);
	}
	
	public void inputToSateTextbox() {
		waitToElementVisible(driver, NewCustomerPageUI.STATE_TEXTBOX);
		sendKeysToElement(driver, NewCustomerPageUI.STATE_TEXTBOX, Constant.STATE);
	}
	
	public void inputToPinTextbox() {
		waitToElementVisible(driver, NewCustomerPageUI.PIN_TEXTBOX);
		sendKeysToElement(driver, NewCustomerPageUI.PIN_TEXTBOX, Constant.PIN);
	}
	
	public void inputToMobileNumberTextbox() {
		waitToElementVisible(driver, NewCustomerPageUI.MOBILE_NUMBER_TEXTBOX);
		sendKeysToElement(driver, NewCustomerPageUI.MOBILE_NUMBER_TEXTBOX, Constant.MOBILE);
	}
	
	public void inputToEmailIDTextbox(String emailID) {
		waitToElementVisible(driver, NewCustomerPageUI.EMAILID_TEXTBOX);
		sendKeysToElement(driver, NewCustomerPageUI.EMAILID_TEXTBOX, emailID);
	}
	
	public void inputToPasswordTextbox() {
		waitToElementVisible(driver, NewCustomerPageUI.PASSWORD_TEXTBOX);
		sendKeysToElement(driver, NewCustomerPageUI.PASSWORD_TEXTBOX, Constant.PASSWORD);
	}
	
	public void clickToSubmitBtn() {
		waitToElementVisible(driver, NewCustomerPageUI.SUBMIT_BTN);
		clickToElement(driver, NewCustomerPageUI.SUBMIT_BTN);		
	}
	
	public boolean isRegisteredMsgDisplayed() {
		return isControlDisplayed(driver, NewCustomerPageUI.REGISTERED_MSG);
	}
	
	public String getCustomerID() {
		waitToElementVisible(driver, NewCustomerPageUI.CUSTOMER_ID);
		return getTextInElement(driver, NewCustomerPageUI.CUSTOMER_ID);
	}

}
