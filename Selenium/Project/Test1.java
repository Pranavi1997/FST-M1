package crmProject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Test1 {
private WebDriver driver;
    
    @BeforeMethod
	public void setup() {
		driver = new FirefoxDriver();
		driver.get("http://alchemy.hguy.co/crm");
	}
    
    @Test 
    public void titleTest() {
    	Assert.assertEquals(driver.getTitle(), "SuiteCRM");
    }
    
    @AfterMethod 
    public void teardown() {
    	driver.quit();
    }
}
