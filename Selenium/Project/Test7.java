package crmProject;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Test7 {
private WebDriver driver;
private WebDriverWait wait;		
	@BeforeMethod
	public void setup() {
		driver = new FirefoxDriver();
		wait = new WebDriverWait(driver,Duration.ofSeconds(5));
		driver.get("http://alchemy.hguy.co/crm");
	}
    
	
    @Test (dataProvider = "creds",dataProviderClass = crmProject.Commondataproviders.class)
    public void addtionalinfoTest(String username, String password) {
    	driver.findElement(By.id("user_name")).sendKeys(username);
    	driver.findElement(By.id("username_password")).sendKeys(password);
    	driver.findElement(By.id("bigbutton")).click();
    	wait.until(ExpectedConditions.elementToBeClickable(By.id("grouptab_0"))).click();
    	wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Leads']"))).click();
    	WebElement additionalInfoIcon = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("(//span[contains(@class,'suitepicon-action-info')])[1]")));
        additionalInfoIcon.click();
        WebElement phone = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='phone']")));
		System.out.println("Phone Number : " + phone.getText());

    }
    
    @AfterMethod
    public void teardown() {
    	driver.quit();
    }
}
