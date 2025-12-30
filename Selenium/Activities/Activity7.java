package examples;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver=new FirefoxDriver();
		driver.get("https://training-support.net/webelements/dynamic-controls");
		System.out.println("Title of the page :" + driver.getTitle());
		WebElement inputtext = driver.findElement(By.xpath("//input[@id = 'textInput']"));
		System.out.println("Input text is enabled: " +inputtext.isEnabled());
		driver.findElement(By.id("textInputButton")).click();
		System.out.println("Input text is enabled: " +inputtext.isEnabled());
		inputtext.sendKeys("example");
		System.out.println("Text Message: " +inputtext.getDomProperty("value"));
		driver.close();
	}

}
