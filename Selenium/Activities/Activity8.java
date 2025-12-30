package examples;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class Activity8 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver=new FirefoxDriver();
		Actions builder = new Actions(driver);
		driver.get("https://training-support.net/webelements/mouse-events");
		System.out.println("Title of the page :" + driver.getTitle());
		WebElement cargolock = driver.findElement(By.xpath("//h1[text()='Cargo.lock']"));
		WebElement cargotoml = driver.findElement(By.xpath("//h1[text()='Cargo.toml']"));
		WebElement src = driver.findElement(By.xpath("//h1[text()='src']"));
		WebElement target = driver.findElement(By.xpath("//h1[text()='target']"));
		builder.click(cargolock).pause(1000).moveToElement(cargotoml).pause(5000).click(cargotoml).build().perform();
		String message1 = driver.findElement(By.id("result")).getText();
		System.out.println("The result is: " +message1);
		builder.doubleClick(src).pause(3000).pause(5000).contextClick(target).pause(3000).build().perform();
		builder.click(driver.findElement(By.xpath("//div[@id ='menu']/div/ul/li[1]"))).pause(5000).build().perform();
		String message2 = driver.findElement(By.id("result")).getText();
		System.out.println("The result is: " +message2);
		driver.close();
	}

}
