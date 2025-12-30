package googleChrome;

import static org.testng.Assert.assertEquals;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class Activity3 {
	AppiumDriver driver;
	WebDriverWait wait;
	
	
	@BeforeClass
	public void setup() throws MalformedURLException, URISyntaxException {
		UiAutomator2Options options = new UiAutomator2Options();
		options.setPlatformName("android");
		options.setAutomationName("UiAutomator2");
		options.setAppPackage("com.android.chrome");
		options.setAppActivity("com.google.android.apps.chrome.Main");
		options.noReset();
		URL serverURL = new URI("http://localhost:4723").toURL();
		driver = new AndroidDriver(serverURL, options);
		wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		driver.get("https://training-support.net/webelements");
	}
	
	@Test
	public void popupTest() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.className("android.view.View")));
		List<WebElement> textElements = driver.findElements(AppiumBy.className("android.view.View"));
		String UiScrollable = "UiScrollable(UiSelector().scrollable(true))";
		wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.androidUIAutomator(UiScrollable + ".scrollForward(65)")));
		WebElement text = driver.findElement(AppiumBy
				.androidUIAutomator(UiScrollable + ".scrollForward(25)"));
		wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.xpath("//android.widget.TextView[@text=\"Popups\"]")));
	  driver.findElement(AppiumBy.xpath(
			  "//android.widget.TextView[@text=\"Popups\"]")).click();	 
	  wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.xpath("//android.widget.Button[@resource-id=\"launcher\"]")));
	  driver.findElement(AppiumBy.xpath(
			  "//android.widget.Button[@resource-id=\"launcher\"]")).click();	
	 wait.until(ExpectedConditions.elementToBeClickable( AppiumBy.androidUIAutomator("new UiSelector().text(\"Popups\")")));
	  WebElement allow = new WebDriverWait(driver, Duration.ofSeconds(8))
    .until(ExpectedConditions.elementToBeClickable(
        AppiumBy.androidUIAutomator("new UiSelector().text(\"Popups\")")
    ));
	  allow.click();

	  driver.findElement(AppiumBy.xpath(
			  "//android.widget.EditText[@resource-id=\"username\"]"
			  )).sendKeys("admin");
	  driver.findElement(AppiumBy.xpath(
			  "//android.widget.EditText[@resource-id=\"password\"]"
			  )).sendKeys("password");
	  driver.findElement(AppiumBy.xpath(
			  "//android.widget.Button[@text=\"Submit\"]")).click();
	  wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.xpath(
			  "//android.widget.TextView[@text=\"Login Success!\"]")));
	  String messageText = driver.findElement(AppiumBy.xpath(
				"//android.widget.TextView[@text=\"Login Success!\"]")).getText();		
		System.out.println(messageText);
		assertEquals(messageText,"Login Success!");
	}
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
}
