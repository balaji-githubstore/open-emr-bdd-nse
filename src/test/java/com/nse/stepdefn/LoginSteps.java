package com.nse.stepdefn;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps {
	
	@Given("I have browser with open emr page")
	public void i_have_browser_with_open_emr_page() {
	   System.out.println("given");
	}
	@When("I enter username as {string}")
	public void i_enter_username_as(String username) {
		 System.out.println("when"+username);
	}
	@When("I enter password as {string}")
	public void i_enter_password_as(String password) {
	   
	}
	@When("I select language as {string}")
	public void i_select_language_as(String language) {
	    
	}
	@When("I click on login")
	public void i_click_on_login() {
	  
	}
	@Then("I should get access to the portal with title as {string}")
	public void i_should_get_access_to_the_portal_with_title_as(String string) {
		 System.out.println("then");
	}


}
