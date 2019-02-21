package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;

public class HomePageObject extends AbstractPage {
private WebDriver driver;
	
	public HomePageObject(WebDriver driverMapping) {
		driver = driverMapping;
	}
}
