package commons;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class AbstractTest {
	
	public int randomNumber() {
		Random random = new Random();
		int number = random.nextInt(9999);
		return number;
	}
	
	public WebDriver openMultiBrowser(WebDriver driver, String browserName) {
		if(browserName.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		}else if(browserName.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", ".//resoucers//chromedriver.exe");
			driver = new ChromeDriver();
		}
		
		driver.get(Constant.DEMO_URL);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		return driver;
	}
	
}