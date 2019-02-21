package com.bankguru.account;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.AbstractTest;
import commons.Constant;
import pageObjects.EditCustomerPageObject;
import pageObjects.HomePageObject;
import pageObjects.LoginPageObject;
import pageObjects.NewCustomerPageObject;
import pageObjects.PageFactoryManager;

public class Payment extends AbstractTest {
	private WebDriver driver;
	private LoginPageObject loginPage;
	private HomePageObject homePage;
	private NewCustomerPageObject newCustomerPage;
	private EditCustomerPageObject editCustomerPage;
	private String email, customerID;
	
	
	
	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = openMultiBrowser(driver, "firefox");
		loginPage = PageFactoryManager.getLoginPage(driver);
		loginPage.inputToUserTextbox(Constant.USER_ID_TO_LOGIN);
		loginPage.inputToPasswordTextbox(Constant.PASSWORD_TO_LOGIN);
		homePage = loginPage.clickToLoginBtn();
	}

	@Test
	public void TC_01_Create_New_Customer_Account_And_Check_Registered_Message() {
		newCustomerPage = homePage.openNewCustomerPage(driver);
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
		Assert.assertTrue(newCustomerPage.isNewCustomerPageDisplayed());
		customerID = newCustomerPage.getCustomerID();
	}
	
	@Test
	public void TC_02_Edit_Customer_Account_And_Check_Edited_Message() {
		editCustomerPage = newCustomerPage.openEditCustomerPage(driver);
		editCustomerPage.inputToCustomerIDTextbox(customerID);
		editCustomerPage.clickToSubmitBtn();
	}
	

	@AfterClass
	public void afterClass() {
	}

}
