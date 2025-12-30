package nativeApp;

import static org.testng.Assert.assertEquals;

import java.io.File;
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
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class Activity1 {
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
		wait.until(ExpectedConditions.elementToBeClickable(
				AppiumBy.id("fab_new_task")));
		driver.findElement(AppiumBy.id("fab_new_task")).click();
		wait.until(ExpectedConditions.elementToBeClickable(
				AppiumBy.id("et_new_task_name")));
		driver.findElement(AppiumBy.id("et_new_task_name")).sendKeys("Activity 1");
		driver.findElement(AppiumBy.id("tv_new_task_priority")).click();
		driver.findElement(AppiumBy.xpath(
				"//android.widget.TextView[@resource-id=\"android:id/title\" and @text=\"High\"]"
				)).click();
		driver.findElement(AppiumBy.id("bt_new_task_ok")).click();
		wait.until(ExpectedConditions.elementToBeClickable(
				AppiumBy.id("exlv_tasks")));
		String result1 = driver.findElement(AppiumBy.xpath(
				"//android.widget.TextView[contains(@text,'Activity 1')]"
				)).getText();
		System.out.println(result1);
		assertEquals(result1,"Activity 1");
	}
	@Test
	public void todolistTest2() {
		driver.findElement(AppiumBy.id("fab_new_task")).click();
		wait.until(ExpectedConditions.elementToBeClickable(
				AppiumBy.id("et_new_task_name")));
		driver.findElement(AppiumBy.id("et_new_task_name")).sendKeys("Activity 2");
		driver.findElement(AppiumBy.id("tv_new_task_priority")).click();
		driver.findElement(AppiumBy.xpath(
				"//android.widget.TextView[@resource-id=\"android:id/title\" and @text=\"Medium\"]"
				)).click();
		driver.findElement(AppiumBy.id("bt_new_task_ok")).click();
		wait.until(ExpectedConditions.elementToBeClickable(
				AppiumBy.id("exlv_tasks")));
		String result2 = driver.findElement(AppiumBy.xpath(
				"//android.widget.TextView[contains(@text,'Activity 2')]"
				)).getText();
		System.out.println(result2);
		assertEquals(result2,"Activity 2");
	}
	@Test
	public void todolistTest3() {
		driver.findElement(AppiumBy.id("fab_new_task")).click();
		wait.until(ExpectedConditions.elementToBeClickable(
				AppiumBy.id("et_new_task_name")));
		driver.findElement(AppiumBy.id("et_new_task_name")).sendKeys("Activity 3");
		driver.findElement(AppiumBy.id("tv_new_task_priority")).click();
		driver.findElement(AppiumBy.xpath(
				"//android.widget.TextView[@resource-id=\"android:id/title\" and @text=\"Low\"]"
				)).click();
		driver.findElement(AppiumBy.id("bt_new_task_ok")).click();
		wait.until(ExpectedConditions.elementToBeClickable(
				AppiumBy.id("exlv_tasks")));
		String result3 = driver.findElement(AppiumBy.xpath(
				"//android.widget.TextView[contains(@text,'Activity 3')]"
				)).getText();
		System.out.println(result3);
		assertEquals(result3,"Activity 3");
	}
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
}
