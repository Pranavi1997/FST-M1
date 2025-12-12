package examples;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver=new FirefoxDriver();
		driver.get("https://training-support.net/webelements/login-form");
		
		System.out.println("Title of the page :" + driver.getTitle());
		driver.findElement(By.name("username")).sendKeys("admin");
		driver.findElement(By.id("password")).sendKeys("password");
		driver.findElement(By.cssSelector(".svelte-1pdjkmx")).click();
		String message = driver.findElement(By.tagName("h1")).getText();
		System.out.println("Login Message : " +message);
		driver.close();
	}
}
