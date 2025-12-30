package examples;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Activity11 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver=new FirefoxDriver();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.get("https://training-support.net/webelements/dynamic-controls");
		System.out.println("Title of the page :" + driver.getTitle());
		WebElement checkbox = driver.findElement(By.xpath("//input[@id = 'checkbox']"));
		System.out.println("Checkbox is visible: " +checkbox.isDisplayed());
		driver.findElement(By.xpath("//button[text()='Toggle Checkbox']")).click();
        wait.until(ExpectedConditions.invisibilityOf(checkbox));
        System.out.println("Checkbox is visible: " + checkbox.isDisplayed());
		driver.findElement(By.xpath("//button[text() = 'Toggle Checkbox']")).click();
		wait.until(ExpectedConditions.elementToBeClickable(checkbox)).click();
		System.out.println("Checkbox is selected: " +checkbox.isSelected());
		driver.close();
	}

}
