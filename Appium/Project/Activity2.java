package nativeApp;

import static org.testng.Assert.assertEquals;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class Activity2 {
	AppiumDriver driver;
	WebDriverWait wait;
	
	
	@BeforeClass
	public void setup() throws MalformedURLException, URISyntaxException {
		UiAutomator2Options caps=new UiAutomator2Options();
		File appFile=new File("src/test/resources/ts-todo-list-v1.apk");
		caps.setPlatformName("android");
		caps.setAutomationName("UiAutomator2");
		caps.setApp(appFile.getAbsolutePath());
		caps.noReset();
		URL serverurl=new URI("http://localhost:4723").toURL();
		driver = new AndroidDriver(serverurl,caps);	
		wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	}
	
	@Test
	public void todolistTest1() {
		driver.findElement(AppiumBy.accessibilityId("Predicted app: To-Do List")).click();	
		WebElement firsttask = wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.androidUIAutomator("text(\"Activity 1\")")));
		((JavascriptExecutor) driver).executeScript("mobile: longClickGesture", ImmutableMap.of("elementId", ((RemoteWebElement) firsttask).getId(), "duration", 2000));		
		driver.findElement(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"android:id/title\" and @text=\"Edit To-Do Task\"]")).click();
		wait.until(ExpectedConditions.elementToBeClickable(
				AppiumBy.id("tv_todo_list_deadline")));
		driver.findElement(AppiumBy.id("tv_todo_list_deadline")).click();
		driver.findElement(AppiumBy.accessibilityId("Next month")).click();
		driver.findElement(AppiumBy.xpath("//android.view.View[@content-desc=\"10 January 2026\"]")).click();
		driver.findElement(AppiumBy.id("bt_deadline_ok")).click();
		wait.until(ExpectedConditions.elementToBeClickable(
				AppiumBy.id("bt_new_task_ok")));
		driver.findElement(AppiumBy.id("bt_new_task_ok")).click();
		wait.until(ExpectedConditions.elementToBeClickable(
				AppiumBy.id("tv_exlv_task_deadline")));
		String result1 = driver.findElement(AppiumBy.xpath(
				"//android.widget.TextView[contains(@text,'Deadline: 10.01.2026')]"
				)).getText();
		System.out.println(result1);
		assertEquals(result1,"Deadline: 10.01.2026");
	}
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
}
