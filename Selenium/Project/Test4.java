package crmProject;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Test4 {
	private WebDriver driver;
	private WebDriverWait wait;
	
	
	
	@BeforeMethod
	public void setup() {
		driver = new FirefoxDriver();
		 wait = new WebDriverWait(driver,Duration.ofSeconds(5));
		driver.get("http://alchemy.hguy.co/crm");
	}
    
	
    @Test (dataProvider = "creds",dataProviderClass = crmProject.Commondataproviders.class)
    public void loginTest(String username, String password) {
    	driver.findElement(By.id("user_name")).sendKeys(username);
    	driver.findElement(By.id("username_password")).sendKeys(password);
    	driver.findElement(By.id("bigbutton")).click();
    	wait.until(ExpectedConditions.titleContains("SuiteCRM"));
    	Assert.assertEquals(driver.getTitle(), "SuiteCRM");
    }

    @AfterMethod
    public void teardown() {
    	driver.quit();
    }
}
