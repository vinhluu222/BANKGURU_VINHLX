package com.bankguru.account;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.AbstractTest;
import commons.Constant;
import pageObjects.DepositPageObject;
import pageObjects.EditCustomerPageObject;
import pageObjects.HomePageObject;
import pageObjects.LoginPageObject;
import pageObjects.NewAccountPageObject;
import pageObjects.NewCustomerPageObject;
import pageObjects.PageFactoryManager;
import pageUIs.NewAccountPageUI;

public class Payment extends AbstractTest {
	private WebDriver driver;
	private LoginPageObject loginPage;
	private HomePageObject homePage;
	private NewCustomerPageObject newCustomerPage;
	private EditCustomerPageObject editCustomerPage;
	private NewAccountPageObject newAccountPage;
	private DepositPageObject depositPage;
	private String email, customerID, currentAmount, accountNo;
	
	
	
	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = openMultiBrowser(browserName);
		loginPage = PageFactoryManager.getLoginPage(driver);
		loginPage.inputToUserTextbox(Constant.USER_ID_TO_LOGIN);
		loginPage.inputToPasswordTextbox(Constant.PASSWORD_TO_LOGIN);
		homePage = loginPage.clickToLoginBtn();
	}

	@Test
	public void TC_01_Create_New_Customer_Account_And_Check_Registered_Message() {
		newCustomerPage = (NewCustomerPageObject) homePage.openDynamicPage(driver, "New Customer");
		Assert.assertTrue(newCustomerPage.isNewCustomerPageDisplayed());
		email = "automation" + randomNumber() + "@gmail.com";
		newCustomerPage.inputToCustomerNameTextbox();
		newCustomerPage.inputToDobBox();
		newCustomerPage.inputToAddressTextbox();
		newCustomerPage.inputToCityTextbox();
		newCustomerPage.inputToSateTextbox();
		newCustomerPage.inputToPinTextbox();
		newCustomerPage.inputToMobileNumberTextbox();
		newCustomerPage.inputToEmailIDTextbox(email);
		newCustomerPage.inputToPasswordTextbox();
		newCustomerPage.clickToSubmitBtn();
		Assert.assertTrue(newCustomerPage.isRegisteredSuccessfully());
		customerID = newCustomerPage.getCustomerID();
	}
	
	@Test
	public void TC_02_Edit_Customer_Account_And_Check_Edited_Message() {
		editCustomerPage = (EditCustomerPageObject)newCustomerPage.openDynamicPage(driver, "Edit Customer");
		editCustomerPage.inputToCustomerIDTextbox(customerID);
		editCustomerPage.clickToSubmitBtn();
		editCustomerPage.inputToAddressTextbox();
		editCustomerPage.inputToCityTextbox();
		editCustomerPage.inputToSateTextbox();
		editCustomerPage.inputToPinTextbox();
		editCustomerPage.inputToMobileNumberTextbox();
		editCustomerPage.inputToEmailIDTextbox(email);
		editCustomerPage.clickToSubmitBtn();
		Assert.assertTrue(editCustomerPage.isEditedSuccessfully());
	}
	
	@Test
	public void TC_03_Add_New_Account_And_Check_Current_Amount_And_Initial_Deposit_Are_Equal() {
		newAccountPage = (NewAccountPageObject) editCustomerPage.openDynamicPage(driver, "New Account");
		newAccountPage.inputToCustomerIDTextbox(customerID);
		newAccountPage.selectAccountTypeDropdown("Current");
		newAccountPage.inputToInitialDeposit(NewAccountPageUI.initialDepositValue);
		newAccountPage.clickToSubmitBtn();
		Assert.assertTrue(newAccountPage.isRegisteredMsgDisplayed());
		currentAmount = newAccountPage.getCurrentAmount();
		Assert.assertEquals(currentAmount, NewAccountPageUI.initialDepositValue);
		accountNo = newAccountPage.getAccountNo();		
	}
	
	@Test
	public void TC_04_Transfer_Money_Into_Current_Account_And_ChecK_Account_Balance() {
		depositPage = (DepositPageObject)newAccountPage.openDynamicPage(driver, "Deposit");
		
		
	}

	@AfterClass
	public void afterClass() {
	}

}
