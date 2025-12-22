package crmProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Test6 {
	private WebDriver driver;
	
	
	@BeforeMethod
	public void setup() {
		driver = new FirefoxDriver();
		driver.get("http://alchemy.hguy.co/crm");
	}
    
	
    @Test (dataProvider = "creds",dataProviderClass = crmProject.Commondataproviders.class)
    public void colorTest(String username, String password) {
    	driver.findElement(By.id("user_name")).sendKeys(username);
    	driver.findElement(By.id("username_password")).sendKeys(password);
    	driver.findElement(By.id("bigbutton")).click();
    	driver.findElement(By.id("grouptab_3")).click();
    }
    

    @AfterMethod
    public void teardown() {
    	driver.quit();
    }
}
