package activities;

import static org.testng.Assert.assertEquals;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.android.options.UiAutomator2Options;

public class Activity5 {
	AndroidDriver driver;
	WebDriverWait wait;
 
	@BeforeClass
	public void setUp() throws MalformedURLException, URISyntaxException {
		
		UiAutomator2Options options = new UiAutomator2Options();
		options.setPlatformName("android");
		options.setAutomationName("UiAutomator2");
		options.setAppPackage("com.google.android.apps.messaging");
        options.setAppActivity(".ui.ConversationListActivity");
		options.noReset();

		URL serverURL = new URI("http://localhost:4723").toURL();
 
		driver = new AndroidDriver(serverURL, options);
		wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	}
	
	@Test
	public void smsTest() {
		driver.findElement(AppiumBy.accessibilityId("Messages")).click();
		wait.until(ExpectedConditions.elementToBeClickable(
				AppiumBy.accessibilityId("Start chat")));
		driver.findElement(AppiumBy.accessibilityId("Start chat")).click();
		wait.until(ExpectedConditions.elementToBeClickable(
                AppiumBy.xpath("//android.widget.TextView[@text=\"Type names, phone numbers, or emails\"]")
        ));
		driver.findElement(AppiumBy.xpath(
				"//android.widget.EditText[@resource-id=\"ContactSearchField\"]"))
		.sendKeys("6361742689");
		driver.pressKey(new KeyEvent(AndroidKey.ENTER));
		wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("compose_message_text")));
		driver.findElement(AppiumBy.id(
				"compose_message_text")).sendKeys("Hello from Appium");
		driver.findElement(AppiumBy.accessibilityId("Send SMS")).click();
		wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.xpath(
				 "//android.widget.TextView[contains(@text, 'Hello from Appium')]")));
		String messageText = driver.findElement(AppiumBy.xpath(
				"//android.widget.TextView[contains(@text, 'Hello from Appium')]")).getText();		
		System.out.println(messageText);
		assertEquals(messageText,"Hello from Appium");
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
}
