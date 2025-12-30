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

public class Activity1 {
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
	public void testMethod() {
		driver.findElement(AppiumBy.id("digit_5")).click();
		driver.findElement(AppiumBy.accessibilityId("multiply")).click();
		driver.findElement(AppiumBy.id("digit_8")).click();
		driver.findElement(AppiumBy.accessibilityId("equals")).click();
		String result = driver.findElement(AppiumBy.id("result_final")).getText();
		assertEquals(result,"40");
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
}
