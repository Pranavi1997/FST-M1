package crmProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Test3 {
	private WebDriver driver;
	
	@BeforeMethod
	public void setup() {
		driver = new FirefoxDriver();
		driver.get("http://alchemy.hguy.co/crm");
	}
    
    @Test 
    public void copyrightTest() {
    	String element = driver.findElement(By.id("admin_options")).getText();
    	 System.out.println("Displaying the first copyright text: " +element);
    }
    
    @AfterMethod 
    public void teardown() {
    	driver.quit();
    }
}
