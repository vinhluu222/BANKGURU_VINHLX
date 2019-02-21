package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;

public class TransferPageObject extends AbstractPage{
private WebDriver driver;
	
	public TransferPageObject(WebDriver driverMapping) {
		driver = driverMapping;
	}
}
