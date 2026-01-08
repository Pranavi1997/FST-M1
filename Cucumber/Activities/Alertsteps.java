package stepDefinitions;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Alertsteps extends Base{
	Alert alert;
	@Given("User is on the page")
	public void openpage() {
		driver.get("https://training-support.net/webelements/alerts");
	}
	@When("User clicks the Simple Alert button")
	public void simpleAlert() {
		driver.findElement(By.id("simple")).click();		
	}
	@When("User clicks the Confirmation Alert button")
	public void ConfirmAlert() {
		driver.findElement(By.id("confirmation")).click();		
	}
	@When("User clicks the Prompt Alert button")
	public void PromptAlert() {
		driver.findElement(By.id("prompt")).click();		
	}
	@Then("Alert opens")
	public void alertOpen() {
		alert = driver.switchTo().alert();
	}
	@And("Read the text from it and print it")
	public void readAlert() {
		System.out.println("Alert message : " +alert.getText());
	}
	@And("Write a custom message in it")
	public void writeAlert() {
		alert.sendKeys("Hello World!!");
	}
	@And("Close the alert")
	public void closeAlert() {
		alert.accept();
	}
	@And("Close the alert with Cancel")
	public void closeAlertWithCAncel() {
		alert.dismiss();
	}
	@And("Read the result text")
	public void readresultText() {
		String message = driver.findElement(By.id("result")).getText();
		System.out.println("Action performed: " + message);
	}

}
