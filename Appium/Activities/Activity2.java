package activities;

import static org.testng.Assert.assertEquals;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class Activity2 {
	AndroidDriver driver;
	WebDriverWait wait;
 
	@BeforeClass
	public void setUp() throws MalformedURLException, URISyntaxException {
		
		UiAutomator2Options options = new UiAutomator2Options();
		options.setPlatformName("android");
		options.setAutomationName("UiAutomator2");
		options.setAppPackage("com.android.chrome");
		options.setAppActivity("com.google.android.apps.chrome.Main");
		options.noReset();

		URL serverURL = new URI("http://localhost:4723").toURL();
 
		driver = new AndroidDriver(serverURL, options);
		wait = new WebDriverWait(driver, Duration.ofSeconds(20));

		driver.get("https://training-support.net");
	}
	@Test
	public void chromeTest() {
		String pageheading = driver.findElement(AppiumBy.xpath(
	                "//android.widget.TextView[@text=\"Training Support\"]"
	        )).getText();
		System.out.println("Page Heading: " + pageheading);
		WebElement aboutheading = driver.findElement(AppiumBy.xpath(
                "//android.widget.TextView[@text=\"About Us\"]"
        ));
		aboutheading.click();
		System.out.println("About Heading: " +aboutheading.getText());
	}
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
}
