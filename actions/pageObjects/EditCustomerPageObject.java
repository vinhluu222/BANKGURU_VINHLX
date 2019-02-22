package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import commons.Constant;
import pageUIs.EditCustomerPageUI;
import pageUIs.NewCustomerPageUI;

public class EditCustomerPageObject extends AbstractPage{
	private WebDriver driver;
	
	public EditCustomerPageObject(WebDriver driverMapping) {
		driver = driverMapping;
	}
	
	public void inputToCustomerIDTextbox(String ID) {
		waitToElementVisible(driver, EditCustomerPageUI.CUSTOMER_ID_TEXTBOX);
		sendKeysToElement(driver, EditCustomerPageUI.CUSTOMER_ID_TEXTBOX, ID);
	}
	
	public void clickToSubmitBtn() {
		waitToElementVisible(driver, EditCustomerPageUI.SUBMIT_BTN);
		clickToElement(driver, EditCustomerPageUI.SUBMIT_BTN);
	}
	
	public void inputToAddressTextbox() {
		waitToElementVisible(driver, EditCustomerPageUI.ADDRESS_TEXTBOX);
		sendKeysToElement(driver, EditCustomerPageUI.ADDRESS_TEXTBOX, Constant.EDITED_ADDRESS);
	}
	
	public void inputToCityTextbox() {
		waitToElementVisible(driver, EditCustomerPageUI.CITY_TEXTBOX);
		sendKeysToElement(driver, EditCustomerPageUI.CITY_TEXTBOX, Constant.EDITED_CITY);
	}
	
	public void inputToSateTextbox() {
		waitToElementVisible(driver, EditCustomerPageUI.STATE_TEXTBOX);
		sendKeysToElement(driver, EditCustomerPageUI.STATE_TEXTBOX, Constant.EDITED_STATE);
	}
	
	public void inputToPinTextbox() {
		waitToElementVisible(driver, EditCustomerPageUI.PIN_TEXTBOX);
		sendKeysToElement(driver, EditCustomerPageUI.PIN_TEXTBOX, Constant.EDITED_PIN);
	}
	
	public void inputToMobileNumberTextbox() {
		waitToElementVisible(driver, EditCustomerPageUI.MOBILE_NUMBER_TEXTBOX);
		sendKeysToElement(driver, EditCustomerPageUI.MOBILE_NUMBER_TEXTBOX, Constant.EDITED_MOBILE);
	}
	
	public void inputToEmailIDTextbox(String emailID) {
		waitToElementVisible(driver, EditCustomerPageUI.EMAILID_TEXTBOX);
		sendKeysToElement(driver, EditCustomerPageUI.EMAILID_TEXTBOX, emailID);
	}
	
	public boolean isEditedSuccessfully() {
		return isControlDisplayed(driver, EditCustomerPageUI.UPDATED_MSG);
	}
}
