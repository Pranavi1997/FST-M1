package examples;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class Activity9 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
				WebDriver driver=new FirefoxDriver();
				Actions builder = new Actions(driver);
				driver.get("https://training-support.net/webelements/keyboard-events");
				System.out.println("Title of the page :" + driver.getTitle());
				builder.sendKeys("This is coming from Selenium").build().perform();
		        String text = driver.findElement(By.cssSelector("h1.mt-3")).getText();
		        System.out.println(text);
		        driver.close();
	}

}
