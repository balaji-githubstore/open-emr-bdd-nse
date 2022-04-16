package com.nse.stepdefn;

import org.junit.Assert;

import com.nse.base.WebDriverWrapper;
import com.nse.pages.LoginPage;
import com.nse.pages.MainPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps {
	
	private WebDriverWrapper wrapper;
	
	private LoginPage login;
	private MainPage main;
	
	public LoginSteps(WebDriverWrapper wrapper) {
		this.wrapper = wrapper;
	}

	public void initializePage() {
		this.login = new LoginPage(wrapper.driver);
		main = new MainPage(wrapper.driver);
	}

	@Given("I have browser with open emr page")
	public void i_have_browser_with_open_emr_page() {
		wrapper.launchBrowser("ch");
		initializePage();
	}

	@When("I enter username as {string}")
	public void i_enter_username_as(String username) {
		login.enterUsername(username);
	}

	@When("I enter password as {string}")
	public void i_enter_password_as(String password) {

		login.enterPassword(password);
	}

	@When("I select language as {string}")
	public void i_select_language_as(String language) {
		login.selectLanguageByText(language);
	}

	@When("I click on login")
	public void i_click_on_login() {
		login.clickOnLogin();
	}

	@Then("I should get access to the portal with title as {string}")
	public void i_should_get_access_to_the_portal_with_title_as(String expectedTitle) {
		// wait for page load
		Assert.assertEquals(expectedTitle, main.getDashboardPageTitle());

	}

	@Then("I should get error message as {string}")
	public void i_should_get_error_message_as(String expectedError) {

		String actualError = login.getInvalidErrorMessage();
		Assert.assertEquals(expectedError, actualError);
	}

}
