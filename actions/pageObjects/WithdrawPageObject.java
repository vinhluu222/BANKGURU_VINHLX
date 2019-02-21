package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;

public class WithdrawPageObject extends AbstractPage {
private WebDriver driver;
	
	public WithdrawPageObject(WebDriver driverMapping) {
		driver = driverMapping;
	}
}
