package crmProject;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Test2 {
private WebDriver driver;
private WebElement element;

    @BeforeMethod
	public void setup() {
		driver = new FirefoxDriver();
		driver.get("http://alchemy.hguy.co/crm");
	}
    
    @Test 
    public void urlTest() {
    	 WebElement element = driver.findElement(By.xpath("//img[@alt='SuiteCRM']"));
    	 String imgurl = element.getAttribute("src");
    	 System.out.println("Display header image url: " +imgurl);  	 
    }
    
    @AfterMethod 
    public void teardown() {
    	driver.quit();
    }
}
