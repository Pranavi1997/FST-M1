package examples;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver=new FirefoxDriver();
		driver.get("https://training-support.net");
		
		System.out.println("Title of the page :" + driver.getTitle());
		
		driver.findElement(By.linkText("About Us")).click();
		
		System.out.println("New title of the page:" + driver.getTitle());
		
		driver.close();
	}

}
