package commons;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import pageObjects.BalanceEnquiryPageObject;
import pageObjects.DepositPageObject;
import pageObjects.EditCustomerPageObject;
import pageObjects.HomePageObject;
import pageObjects.NewAccountPageObject;
import pageObjects.NewCustomerPageObject;
import pageObjects.PageFactoryManager;
import pageObjects.TransferPageObject;
import pageUIs.AbstractPageUI;

public class AbstractPage {

	public void openUrl(WebDriver driver, String url) {
		driver.get(url);
	}

	public String getTitle(WebDriver driver, String locator) {
		WebElement element = driver.findElement(By.xpath(locator));
		return element.getText();
	}

	public String getCurrentUrl(WebDriver driver) {
		return driver.getCurrentUrl();
	}

	public String getPageSource(WebDriver driver) {
		return driver.getPageSource();
	}

	public void back(WebDriver driver) {
		driver.navigate().back();
	}

	public void forward(WebDriver driver) {
		driver.navigate().forward();
	}

	public void refresh(WebDriver driver) {
		driver.navigate().refresh();
	}

	public void acceptAlert(WebDriver driver) {
		driver.switchTo().alert().accept();
	}

	public void cancelAlert(WebDriver driver) {
		driver.switchTo().alert().dismiss();
	}

	public String getTextAlert(WebDriver driver) {
		return driver.switchTo().alert().getText();
	}

	public void sendKeyAlert(WebDriver driver, String value) {
		driver.switchTo().alert().sendKeys(value);
	}

	public void clickToElement(WebDriver driver, String locator) {
		WebElement element = driver.findElement(By.xpath(locator));
		element.click();
	}
	public void clickToElement(WebDriver driver, String locator, String... dynamicValue) {
		locator = String.format(locator, (Object[]) dynamicValue);
		WebElement element = driver.findElement(By.xpath(locator));
		element.click();
	}

	public void sendKeysToElement(WebDriver driver, String locator, String value) {
		WebElement element = driver.findElement(By.xpath(locator));
		element.sendKeys(value);
	}

	public void selectItemInHtmlDropdown(WebDriver driver, String locator, String valueInDropdown) {
		WebElement element = driver.findElement(By.xpath(locator));
		Select select = new Select(element);
		select.selectByVisibleText(valueInDropdown);
	}

	public String getSelectedItemInHtmlDropdown(WebDriver driver, String locator) {
		WebElement element = driver.findElement(By.xpath(locator));
		Select select = new Select(element);
		return select.getFirstSelectedOption().getText();
	}

	public void selectItemInCustomDropdown(WebDriver driver, String scrollToXpath, String parentXpath, String childXpath, String expectedItem) throws Exception {
		JavascriptExecutor javaExecutor = (JavascriptExecutor) driver;
		WebDriverWait waitExplicit = new WebDriverWait(driver, 30);

		javaExecutor.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath(scrollToXpath)));
		WebElement element = driver.findElement(By.xpath(parentXpath));
		element.click();
		Thread.sleep(1000);

		List<WebElement> childList = driver.findElements(By.xpath(childXpath));

		waitExplicit.until(ExpectedConditions.visibilityOfAllElements(childList));

		for (WebElement child : childList) {
			String textItem = child.getText().trim();
			if (textItem.equals(expectedItem)) {
				javaExecutor.executeScript("arguments[0].scrollIntoView(true);", child);
				Thread.sleep(1000);
				child.click();
				break;
			}
		}
	}

	public String getAttributeValue(WebDriver driver, String locator, String attributeName) {
		WebElement element = driver.findElement(By.xpath(locator));
		return element.getAttribute(attributeName);
	}

	public String getTextInElement(WebDriver driver, String locator) {
		WebElement element = driver.findElement(By.xpath(locator));
		return element.getText();
	}

	public int countElementNumber(WebDriver driver, String locator) {
		List<WebElement> element = driver.findElements(By.xpath(locator));
		return element.size();
	}

	public void checkTheCheckbox(WebDriver driver, String locator) {
		WebElement element = driver.findElement(By.xpath(locator));
		if (!element.isSelected()) {
			element.click();
		}
	}

	public void uncheckTheCheckbox(WebDriver driver, String locator) {
		WebElement element = driver.findElement(By.xpath(locator));
		if (element.isSelected()) {
			element.click();
		}
	}

	public boolean isControlDisplayed(WebDriver driver, String locator) {
		WebElement element = driver.findElement(By.xpath(locator));
		return element.isDisplayed();
	}
	
	public boolean isControlDisplayed(WebDriver driver, String locator, String...dynamicValue) {
		locator = String.format(locator, (Object[]) dynamicValue);
		WebElement element = driver.findElement(By.xpath(locator));
		return element.isDisplayed();
	}

	public boolean isControlSelected(WebDriver driver, String locator) {
		WebElement element = driver.findElement(By.xpath(locator));
		return element.isSelected();
	}

	public boolean isControlEnabled(WebDriver driver, String locator) {
		WebElement element = driver.findElement(By.xpath(locator));
		return element.isEnabled();
	}
	
	public void switchWindowByID(WebDriver driver, String parentWindowID) {
		Set<String> allWindows = driver.getWindowHandles();
		for(String runWindow:allWindows) {
			if(!runWindow.equals(parentWindowID)) {
				driver.switchTo().window(runWindow);
				break;
			}
		}
		
	}
	
	public void switchWindowByTitle(WebDriver driver, String title) {
		Set<String> allWindows = driver.getWindowHandles();
		for(String runWindow:allWindows) {
			driver.switchTo().window(runWindow);
			String currentWindowTitle = driver.getTitle();
			if(currentWindowTitle.equals(title)) {
				break;
			}			
		}
	}
	
	public void closeAllWindowsWithoutParent(WebDriver driver, String parentID) {
		Set<String> allWindows = driver.getWindowHandles();
		for(String runWindow:allWindows) {
			if(!runWindow.equals(parentID)){
				driver.switchTo().window(runWindow);
				driver.close();
			}
			driver.switchTo().window(parentID);
			
		}
	}
	
	public void doubleClickToElement(WebDriver driver, String locator) {
		WebElement element = driver.findElement(By.xpath(locator));
		Actions action = new Actions(driver);
		action.doubleClick(element);
	}

	public void hoverToElement(WebDriver driver, String locator) {
		WebElement element = driver.findElement(By.xpath(locator));
		Actions action = new Actions(driver);
		action.moveToElement(element);
	}

	public void rightClickToElement(WebDriver driver, String locator) {
		WebElement element = driver.findElement(By.xpath(locator));
		Actions action = new Actions(driver);
		action.contextClick(element);
	}

	public void dragAndDropElement(WebDriver driver, String locatorSource, String locatorTarget) {
		WebElement source = driver.findElement(By.xpath(locatorSource));
		WebElement target = driver.findElement(By.xpath(locatorTarget));
		Actions action = new Actions(driver);
		action.dragAndDrop(source, target);
	}

	// public void keyPress(WebDriver driver, String locator, String key) {
	// WebElement element = driver.findElement(By.xpath(locator));
	// Actions action = new Actions(driver);
	// action.k
	//
	// }

	public void waitToElementVisible(WebDriver driver, String locator) {
		By byLocator = By.xpath(locator);
		WebDriverWait waitExplicit = new WebDriverWait(driver, 30);
		waitExplicit.until(ExpectedConditions.visibilityOfElementLocated(byLocator));
	}
	public void waitToElementVisible(WebDriver driver, String locator, String... dynamicValue) {
		locator = String.format(locator, (Object[]) dynamicValue);
		By byLocator = By.xpath(locator);
		WebDriverWait waitExplicit = new WebDriverWait(driver, 30);
		waitExplicit.until(ExpectedConditions.visibilityOfElementLocated(byLocator));
	}

	public void waitToElementPresent(WebDriver driver, String locator) {
		By byLocator = By.xpath(locator);
		WebDriverWait waitExplicit = new WebDriverWait(driver, 30);
		waitExplicit.until(ExpectedConditions.presenceOfElementLocated(byLocator));
	}
	
	public void waitToElementInvisible(WebDriver driver, String locator) {
		By byLocator = By.xpath(locator);
		WebDriverWait waitExplicit = new WebDriverWait(driver, 30);
		waitExplicit.until(ExpectedConditions.invisibilityOfElementLocated(byLocator));
	}
	
	
	//Hàm chuyển Page
	public NewCustomerPageObject openNewCustomerPage(WebDriver driver) {
		waitToElementVisible(driver, AbstractPageUI.NEW_CUSTOMER_LINK);
		clickToElement(driver, AbstractPageUI.NEW_CUSTOMER_LINK);
		return PageFactoryManager.getNewCustomerPage(driver);
		
	}
	
	public NewAccountPageObject openNewAccountPage(WebDriver driver) {
		waitToElementVisible(driver, AbstractPageUI.NEW_ACCOUNT_LINK);
		clickToElement(driver, AbstractPageUI.NEW_ACCOUNT_LINK);
		return PageFactoryManager.getNewAccountPage(driver);
		
	}
	
	public EditCustomerPageObject openEditCustomerPage(WebDriver driver) {
		waitToElementVisible(driver, AbstractPageUI.EDIT_CUSTOMER_LINK);
		clickToElement(driver, AbstractPageUI.EDIT_CUSTOMER_LINK);
		return PageFactoryManager.getEditCustomerPage(driver);
		
	}
	
	public DepositPageObject openDepositPage(WebDriver driver) {
		waitToElementVisible(driver, AbstractPageUI.DEPOSIT_LINK);
		clickToElement(driver, AbstractPageUI.DEPOSIT_LINK);
		return PageFactoryManager.getDepositPage(driver);
		
	}
	
	public TransferPageObject openTransferPage(WebDriver driver) {
		waitToElementVisible(driver, AbstractPageUI.TRANSFER_LINK);
		clickToElement(driver, AbstractPageUI.TRANSFER_LINK);
		return PageFactoryManager.getTransferPage(driver);
		
	}
	
	public BalanceEnquiryPageObject openBalanceEnquiryPage(WebDriver driver) {
		waitToElementVisible(driver, AbstractPageUI.BALANCE_ENQUIRY_LINK);
		clickToElement(driver, AbstractPageUI.BALANCE_ENQUIRY_LINK);
		return PageFactoryManager.getBalanceEnquiryPage(driver);
		
	}
	
	public HomePageObject openHomePage(WebDriver driver) {
		waitToElementVisible(driver, AbstractPageUI.HOMEPAGE_LINK);
		clickToElement(driver, AbstractPageUI.HOMEPAGE_LINK);
		return PageFactoryManager.getHomePage(driver);
	
	}
	
	public AbstractPage openDynamicPage(WebDriver driver, String pageName) {
		waitToElementVisible(driver, AbstractPageUI.DYNAMIC_LINK, pageName);
		clickToElement(driver, AbstractPageUI.DYNAMIC_LINK, pageName);
		switch(pageName) {
		case "New Customer":
			return PageFactoryManager.getNewCustomerPage(driver);
		case "New Account":
			return PageFactoryManager.getNewAccountPage(driver);
		case "Edit Customer":
			return PageFactoryManager.getEditCustomerPage(driver);
		case "Deposit":
			return PageFactoryManager.getDepositPage(driver);
		case "Fund Transfer":
			return PageFactoryManager.getTransferPage(driver);
		case "Balance Enquiry":
			return PageFactoryManager.getBalanceEnquiryPage(driver);
		default:
			return PageFactoryManager.getTransferPage(driver);
		}
	}


	
}
