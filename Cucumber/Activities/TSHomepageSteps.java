package stepDefinitions;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TSHomepageSteps extends Base {
	@Given("user is on the TS homepage")
	public void userisontheTShomepage() {
		driver.get("https://training-support.net");
		assertEquals(driver.getTitle(), "Training Support");
	}
	
	@When("the user clicks on the About Us link")
	public void theuserclicksontheAboutUs() {
		driver.findElement(By.linkText("About Us")).click();
	}
	@Then("they are redirected to another page")
	public void theyareredirectedtoanotherpage() {
		wait.until(ExpectedConditions.titleIs("About Training Support"));
		String pageheading = driver.findElement(By.cssSelector("h1.text-center")).getText();
		System.out.println("New page heading : " +pageheading);
		assertEquals(driver.getTitle(), "About Training Support");
	}

}
