package googleChrome;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class Todolist {
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
		wait = new WebDriverWait(driver, Duration.ofSeconds(50));
		driver.get("https://training-support.net/webelements");
	}
	
	@Test
	public void googlechromeTest() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.className("android.view.View")));
		List<WebElement> textElements = driver.findElements(AppiumBy.className("android.view.View"));
		String UiScrollable = "UiScrollable(UiSelector().scrollable(true))";
		wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.androidUIAutomator(UiScrollable + ".scrollForward(65)")));
		WebElement text = driver.findElement(AppiumBy
				.androidUIAutomator(UiScrollable + ".scrollForward(55)"));
		driver.findElement(AppiumBy
				.androidUIAutomator(UiScrollable + ".scrollForward(25)"));
		wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.xpath("//android.widget.TextView[@text=\"To-Do List\"]")));
	  driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=\"To-Do List\"]")).click();
	  wait.until(ExpectedConditions.elementToBeClickable(
              AppiumBy.xpath("//android.widget.EditText[@resource-id=\"todo-input\"]")));
	  driver.findElement(AppiumBy.xpath(
			  "//android.widget.EditText[@resource-id=\"todo-input\"]"
			  )).sendKeys("Add tasks to list");
	driver.findElement(AppiumBy.xpath(
			"//android.widget.Button[@resource-id=\"todo-add\"]")).click();	
	wait.until(ExpectedConditions.elementToBeClickable(
            AppiumBy.xpath(
            		"//android.widget.EditText[@resource-id=\"todo-input\"]")));
	driver.findElement(AppiumBy.xpath(
			"//android.widget.EditText[@resource-id=\"todo-input\"]"
			)).sendKeys("Get number of tasks");
	driver.findElement(AppiumBy.xpath(
			"//android.widget.Button[@resource-id=\"todo-add\"]")).click();	
	wait.until(ExpectedConditions.elementToBeClickable(
            AppiumBy.xpath(
            		"//android.widget.EditText[@resource-id=\"todo-input\"]")));
	driver.findElement(AppiumBy.xpath(
			"//android.widget.EditText[@resource-id=\"todo-input\"]"
			)).sendKeys("Clear the list");
	driver.findElement(AppiumBy.xpath(
			"//android.widget.Button[@resource-id=\"todo-add\"]")).click();
	wait.until(ExpectedConditions.elementToBeClickable(
            AppiumBy.xpath(
            		"//android.widget.ListView/android.view.View[3]/android.view.View/android.widget.CheckBox"
            		))).click();
	wait.until(ExpectedConditions.elementToBeClickable(
            AppiumBy.xpath(
            		"//android.widget.ListView/android.view.View[4]/android.view.View/android.widget.CheckBox"
            		))).click();
	wait.until(ExpectedConditions.elementToBeClickable(
            AppiumBy.xpath(
            		"//android.widget.ListView/android.view.View[5]/android.view.View/android.widget.CheckBox"
            		))).click();
	textElements = driver.findElements(AppiumBy.className("android.widget.CheckBox"));
	System.out.println("Number of elemets: " + textElements.size());
	Assert.assertEquals(textElements.size(), 5);
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
}
