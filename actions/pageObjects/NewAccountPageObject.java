package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUIs.NewAccountPageUI;
import pageUIs.NewCustomerPageUI;

public class NewAccountPageObject extends AbstractPage {
private WebDriver driver;
	
	public NewAccountPageObject(WebDriver driverMapping) {
		driver = driverMapping;
	}
	
	public void inputToCustomerIDTextbox(String customerId) {
		waitToElementVisible(driver, NewAccountPageUI.CUSTOMERID_TEXTBOX);
		sendKeysToElement(driver, NewAccountPageUI.CUSTOMERID_TEXTBOX, customerId);
	}
	
	public void selectAccountTypeDropdown(String valueInDropdown) {
		waitToElementVisible(driver, NewAccountPageUI.ACCOUNT_TYPE_DROPDOWN);
		selectItemInHtmlDropdown(driver, NewAccountPageUI.ACCOUNT_TYPE_DROPDOWN, valueInDropdown);
	}
	
	public void inputToInitialDeposit(String value) {
		waitToElementVisible(driver, NewAccountPageUI.INITIAL_DEPOSTI);
		sendKeysToElement(driver, NewAccountPageUI.INITIAL_DEPOSTI, value);
	}
	
	public void clickToSubmitBtn() {
		waitToElementVisible(driver, NewAccountPageUI.SUBMIT_BTN);
		clickToElement(driver, NewAccountPageUI.SUBMIT_BTN);
	}
	
	public boolean isRegisteredMsgDisplayed() {
		return isControlDisplayed(driver, NewAccountPageUI.REGISTERED_MSG);
	}
	
	public String getCurrentAmount() {
		waitToElementVisible(driver, NewAccountPageUI.CURRENT_AMOUNT_VALUE);
		return getTextInElement(driver, NewAccountPageUI.CURRENT_AMOUNT_VALUE);
	}
	
	public String getAccountNo() {
		waitToElementVisible(driver, NewAccountPageUI.ACCOUNT_NO_TEXTBOX);
		return getTextInElement(driver, NewAccountPageUI.ACCOUNT_NO_TEXTBOX);
	}
}
	