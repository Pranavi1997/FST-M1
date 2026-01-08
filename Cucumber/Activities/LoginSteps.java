package stepDefinitions;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps extends Base {
	@Given("the user is on the login page")
	public void loginpage() {
		driver.get("https://training-support.net/webelements/login-form");
	}
	
	@When("the user enters username and password")
	public void credentials() {
		driver.findElement(By.id("username")).sendKeys("admin");
		driver.findElement(By.id("password")).sendKeys("password");
	}
	
	@When("the user enters {string} and {string}")
	public void credentialsinputs(String Username,String Password) {
		WebElement username = driver.findElement(By.id("username"));
		WebElement password = driver.findElement(By.id("password"));
		username.clear();
		password.clear();
		username.sendKeys(Username);
		password.sendKeys(Password);
	}
	
	@And("clicks the submit button")
	public void submit() {
		driver.findElement(By.xpath("//button[text()='Submit']")).click();
	}
	
	@Then("get the confirmation message and verify it")
	public void confirmationmessage() {
		wait.until(ExpectedConditions.textToBePresentInElementLocated(By.cssSelector("h2.mt-5"), "Welcome"));
		String loginMessage = driver.findElement(By.cssSelector("h2.text-center")).getText();
		Assertions.assertEquals("Welcome Back, Admin!", loginMessage);
	}
	
	/*@Then("get the confirmation text and verify message as {string}")
	public void confirmationmessageinput(String expectedmessage) {
		wait.until(ExpectedConditions.textToBePresentInElementLocated(By.cssSelector("h2.mt-5"), "Welcome"));
		String loginMessage = driver.findElement(By.cssSelector("h2.text-center")).getText();
		Assertions.assertEquals(expectedmessage,loginMessage);
	}*/
	
	@Then("get the confirmation text and verify message as {string}")
    public void confirmMessageAsInput(String expectedMessage) {
        // Find the message
        String message = "NOT FOUND";
        if (expectedMessage.contains("Invalid")) {
            message = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("h2#subheading"))).getText();
        } else {
            message = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("h2.mt-5"))).getText();
        }
        Assertions.assertEquals(expectedMessage, message);
    }
}
