package nativeApp;

import static org.testng.Assert.assertEquals;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.time.Duration;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
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

public class Activity3 {
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
		wait = new WebDriverWait(driver, Duration.ofSeconds(50));
	}
	
	@Test
	public void todolistTest1() {
		driver.findElement(AppiumBy.accessibilityId("Predicted app: To-Do List")).click();	
		wait.until(ExpectedConditions.elementToBeClickable(
				AppiumBy.xpath(
						"(//android.widget.CheckBox[@resource-id=\"com.app.todolist:id/cb_task_done\"])[1]")));		
		driver.findElement(AppiumBy.xpath(
				"(//android.widget.CheckBox[@resource-id=\"com.app.todolist:id/cb_task_done\"])[1]"
				)).click();
		driver.findElement(AppiumBy.xpath(
				"(//android.widget.CheckBox[@resource-id=\"com.app.todolist:id/cb_task_done\"])[2]"
				)).click();
		WebElement firsttask = wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.androidUIAutomator("text(\"Activity 3\")")));
		((JavascriptExecutor) driver).executeScript("mobile: longClickGesture", ImmutableMap.of("elementId", ((RemoteWebElement) firsttask).getId(), "duration", 2000));		
		driver.findElement(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"android:id/title\" and @text=\"Edit To-Do Task\"]")).click();
		WebElement progress = driver.findElement(AppiumBy.id("com.app.todolist:id/sb_new_task_progress"));
		int startX = progress.getLocation().getX();
		int startY= progress.getLocation().getY();
		int width = progress.getSize().getWidth();		
		PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
		Sequence dragToMiddle = new Sequence(finger,1);
		int center = startX + (width/2);
		dragToMiddle.addAction(finger.createPointerMove(Duration.ZERO,PointerInput.Origin.viewport(),startX,startY));
		dragToMiddle.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
		dragToMiddle.addAction(finger.createPointerMove(Duration.ofMillis(1000),PointerInput.Origin.viewport(),center,startY));
		dragToMiddle.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));		
		driver.perform(Collections.singletonList(dragToMiddle));
		driver.findElement(AppiumBy.id("bt_new_task_ok")).click();
		wait.until(ExpectedConditions.elementToBeClickable(
				AppiumBy.accessibilityId("More options")));
		driver.findElement(AppiumBy.accessibilityId("More options")).click();	
		wait.until(ExpectedConditions.elementToBeClickable(
				AppiumBy.xpath("//android.widget.TextView[contains(@text,'Completed tasks')]")));
		driver.findElement(AppiumBy.xpath("//android.widget.TextView[contains(@text,'Completed tasks')]")).click();
		wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.androidUIAutomator("text(\"Activity 1\")")));
		List<WebElement> activities = driver.findElements(AppiumBy.id("tv_exlv_task_name"));
		// Print the number of images
		System.out.println("List of Activities: " + activities.size());
		assertEquals(activities.size(),2);
	}
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
}
