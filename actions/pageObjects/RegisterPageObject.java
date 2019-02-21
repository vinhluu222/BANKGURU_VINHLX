package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;

public class RegisterPageObject extends AbstractPage{
	private WebDriver driver;
	public RegisterPageObject(WebDriver driverMapping) {
		driver = driverMapping;
	}
}
