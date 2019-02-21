package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUIs.EditCustomerPageUI;

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
}
