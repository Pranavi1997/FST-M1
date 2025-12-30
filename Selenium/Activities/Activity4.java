package examples;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.Color;

public class Activity4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver=new FirefoxDriver();
		driver.get("https://training-support.net/webelements/target-practice");
		System.out.println("Title of the page :" + driver.getTitle());
		String thirdheadermessage = driver.findElement(By.xpath("//h3[contains(text(), '#3')]")).getText();
		System.out.println("Third header message : " +thirdheadermessage);
		Color fifthHeaderColor = Color.fromString(driver.findElement(By.xpath("//h5[contains(text(), '#5')]")).getCssValue("color"));
        System.out.println("Fifth Header color: " + fifthHeaderColor.asRgb());
        System.out.println("Fifth Header Color as hexcode: " + fifthHeaderColor.asHex());
        String purplebuttonclass = driver.findElement(By.xpath("//button[text() = 'Purple']")).getAttribute("class");
        System.out.println("Purple button class: " +purplebuttonclass);
        String slatebutton = driver.findElement(By.xpath("//button[contains(text(),'Slate')]")).getText();
        System.out.println("Slate button message: " +slatebutton);
        driver.close();
	}

}
