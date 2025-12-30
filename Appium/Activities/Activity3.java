package activities;

import static org.testng.Assert.assertEquals;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

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
		UiAutomator2Options caps=new UiAutomator2Options();
		File appFile=new File("src/test/resources/Calculator.apk");
		caps.setPlatformName("android");
		caps.setAutomationName("UiAutomator2");
		caps.setApp(appFile.getAbsolutePath());
		caps.noReset();
		URL serverurl=new URI("http://localhost:4723").toURL();
		driver = new AndroidDriver(serverurl,caps);		
	}
	
	@Test
	public void additionTest() {
		driver.findElement(AppiumBy.id("digit_5")).click();
		driver.findElement(AppiumBy.accessibilityId("plus")).click();
		driver.findElement(AppiumBy.id("digit_9")).click();
		driver.findElement(AppiumBy.accessibilityId("equals")).click();
		String result = driver.findElement(AppiumBy.id("result_final")).getText();
		System.out.println(result);
		assertEquals(result,"14");
	}
	@Test
	public void subtractTest() {
		driver.findElement(AppiumBy.id("digit_1")).click();
		driver.findElement(AppiumBy.id("digit_0")).click();
		driver.findElement(AppiumBy.accessibilityId("minus")).click();
		driver.findElement(AppiumBy.id("digit_5")).click();
		driver.findElement(AppiumBy.accessibilityId("equals")).click();
		String result = driver.findElement(AppiumBy.id("result_final")).getText();
		System.out.println(result);
		assertEquals(result,"5");
	}
	
	@Test
	public void multiplyTest() {
		driver.findElement(AppiumBy.id("digit_5")).click();
		driver.findElement(AppiumBy.accessibilityId("multiply")).click();
		driver.findElement(AppiumBy.id("digit_1")).click();
		driver.findElement(AppiumBy.id("digit_0")).click();
		driver.findElement(AppiumBy.id("digit_0")).click();
		driver.findElement(AppiumBy.accessibilityId("equals")).click();
		String result = driver.findElement(AppiumBy.id("result_final")).getText();
		System.out.println(result);
		assertEquals(result,"500");
	}

	@Test
	public void divisionTest() {
		driver.findElement(AppiumBy.id("digit_5")).click();
		driver.findElement(AppiumBy.id("digit_0")).click();
		driver.findElement(AppiumBy.accessibilityId("divide")).click();
		driver.findElement(AppiumBy.id("digit_2")).click();
		driver.findElement(AppiumBy.accessibilityId("equals")).click();
		String result = driver.findElement(AppiumBy.id("result_final")).getText();
		System.out.println(result);
		assertEquals(result,"25");
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
}
