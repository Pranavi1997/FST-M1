package activities;


import static org.testng.Assert.assertEquals;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.time.Duration;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class Activity6 {
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

		driver.get("https://training-support.net/webelements/sliders");
	}
	
	@Test
	public void volume25Test() {
		Dimension dims= driver.manage().window().getSize();
		System.out.println(dims.getWidth() + " ," +dims.getHeight());
		int startX = (int)(0.50*dims.getWidth());
		int startY = (int)(0.77*dims.getHeight());
		Point start = new Point(startX,startY);		
		int endX = (int)(0.33*dims.getWidth());
	    int endY = (int)(0.77*dims.getHeight());
	    Point end = new Point(endX,endY);
	    ActionsBase.doSwipe(driver,start,end,2000);
	    String volumeText = driver.findElement(
	    		AppiumBy.xpath("//android.widget.TextView[contains(@text, '%')]"))
	    		.getText();
	    assertEquals(volumeText,"25%");		
				
	}
	
	@Test
	public void volume75Test() {
		Dimension dims= driver.manage().window().getSize();
		System.out.println(dims.getWidth() + " ," +dims.getHeight());
		int startX = (int)(0.50*dims.getWidth());
		int startY = (int)(0.77*dims.getHeight());
		Point start = new Point(startX,startY);
		int endX = (int)(0.67*dims.getWidth());
	    int endY = (int)(0.77*dims.getHeight());
	    Point end = new Point(endX,endY);
	    ActionsBase.doSwipe(driver,start,end,2000);
	    String volumeText = driver.findElement(
	    		AppiumBy.xpath("//android.widget.TextView[contains(@text, '%')]"))
	    		.getText();
	    assertEquals(volumeText,"75%");		
				
	}
	
	
	@AfterClass
	public void tearDown() {
		// Close the browser
		driver.quit();
	}
}
