package com.nse.stepdefn;

import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;


public class LoginSteps {
	WebDriver driver;
	@Given("I have browser with open emr page")
	public void i_have_browser_with_open_emr_page() {
		
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));
		driver.get("https://demo.openemr.io/b/openemr");
		
	}
	@When("I enter username as {string}")
	public void i_enter_username_as(String username) {
		
		 driver.findElement(By.cssSelector("#authUser")).sendKeys(username);
		 
	}
	@When("I enter password as {string}")
	public void i_enter_password_as(String password) {
		driver.findElement(By.cssSelector("#clearPass")).sendKeys(password);
	}
	@When("I select language as {string}")
	public void i_select_language_as(String language) {
		
		Select selectLan= new Select(driver.findElement(By.xpath("//select[@name='languageChoice']")));
		selectLan.selectByVisibleText(language);
	    
	}
	@When("I click on login")
	public void i_click_on_login() {
		driver.findElement(By.id("login-button")).click();
	}
	@Then("I should get access to the portal with title as {string}")
	public void i_should_get_access_to_the_portal_with_title_as(String expectedTitle) {
		//wait for page load
		Assert.assertEquals(expectedTitle, driver.getTitle());
		
		driver.quit();
	}
	
	@Then("I should get error message as {string}")
	public void i_should_get_error_message_as(String expectedError) {
		
		String actualError=driver.findElement(By.xpath("//*[contains(text(),'Invalid')]")).getText();
	    Assert.assertEquals(expectedError, actualError);
	}



}
