package com.nse.stepdefn;

import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import com.nse.base.WebDriverWrapper;
import com.nse.pages.LoginPage;
import com.nse.pages.MainPage;

import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginSteps {

	@Given("I have browser with open emr page")
	public void i_have_browser_with_open_emr_page() {

		WebDriverManager.chromedriver().setup();
		WebDriverWrapper.driver = new ChromeDriver();
		WebDriverWrapper.driver.manage().window().maximize();
		WebDriverWrapper.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebDriverWrapper.driver.get("https://demo.openemr.io/b/openemr");

	}

	@When("I enter username as {string}")
	public void i_enter_username_as(String username) {
		LoginPage.enterUsername(username);
	}

	@When("I enter password as {string}")
	public void i_enter_password_as(String password) {
		LoginPage.enterPassword(password);
	}

	@When("I select language as {string}")
	public void i_select_language_as(String language) {

		LoginPage.selectLanguageByText(language);

	}

	@When("I click on login")
	public void i_click_on_login() {
		LoginPage.clickOnLogin();
	}

	@Then("I should get access to the portal with title as {string}")
	public void i_should_get_access_to_the_portal_with_title_as(String expectedTitle) {
		// wait for page load
		Assert.assertEquals(expectedTitle, MainPage.getDashboardPageTitle());

	}

	@Then("I should get error message as {string}")
	public void i_should_get_error_message_as(String expectedError) {

		String actualError = LoginPage.getInvalidErrorMessage();
		Assert.assertEquals(expectedError, actualError);
	}

}
