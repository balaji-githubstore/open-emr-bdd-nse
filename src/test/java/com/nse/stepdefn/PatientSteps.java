package com.nse.stepdefn;

import java.time.Duration;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.nse.base.WebDriverWrapper;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class PatientSteps {
	private static String actualAlertText;
	WebDriverWrapper wrapper;
	
	public PatientSteps(WebDriverWrapper wrapper) {
		this.wrapper = wrapper;
	}
	
	@When("I click on patient")
	public void i_click_on_patient() {	
		wrapper.driver.findElement(By.xpath("//div[text()='Patient']")).click();
	}

	@When("I click on new-search")
	public void i_click_on_new_search() {
		wrapper.driver.findElement(By.xpath("//div[text()='New/Search']")).click();
	}

	@When("I fill the form")
	public void i_fill_the_form(DataTable dataTable) {
		// Write code here that turns the phrase above into concrete actions
		// For automatic transformation, change DataTable to one of
		// E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
		// Map<K, List<V>>. E,K,V must be a String, Integer, Float,
		// Double, Byte, Short, Long, BigInteger or BigDecimal.
		//
		// For other transformations you can register a DataTableType.

		List<Map<String, String>> lists = dataTable.asMaps();
		System.out.println(lists);

		System.out.println(lists.get(0).get("firstname"));
		System.out.println(lists.get(0).get("lastname"));
		System.out.println(lists.get(0).get("gender"));
		System.out.println(lists.get(0).get("dob"));

		wrapper.driver.switchTo().frame(wrapper.driver.findElement(By.xpath("//iframe[@name='pat']")));

		wrapper.driver.findElement(By.id("form_fname")).sendKeys(lists.get(0).get("firstname"));
		wrapper.driver.findElement(By.id("form_lname")).sendKeys(lists.get(0).get("lastname"));
		wrapper.driver.findElement(By.id("form_DOB")).sendKeys(lists.get(0).get("dob"));

		Select selectGender = new Select(wrapper.driver.findElement(By.cssSelector("#form_sex")));
		selectGender.selectByVisibleText(lists.get(0).get("gender"));
	}

	@When("I click on create new patient")
	public void i_click_on_create_new_patient() {
		wrapper.driver.findElement(By.id("create")).click();
		wrapper.driver.switchTo().defaultContent();
	}

	@When("I click on confirm create new patient")
	public void i_click_on_confirm_create_new_patient() {
		wrapper.driver.switchTo().frame("modalframe");
		wrapper.driver.findElement(By.xpath("//input[@value='Confirm Create New Patient']")).click();
		wrapper.driver.switchTo().defaultContent();
	}

	@When("I handle the alertbox")
	public void i_handle_the_alertbox() {
		WebDriverWait wait = new WebDriverWait(wrapper.driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.alertIsPresent());
		actualAlertText = wrapper.driver.switchTo().alert().getText();
		wrapper.driver.switchTo().alert().accept();

	}

	@When("I click on close happy birthday popup if shown")
	public void i_click_on_close_happy_birthday_popup_if_shown() {

		// checking the presence of element
		if (wrapper.driver.findElements(By.xpath("//div[@class='closeDlgIframe']")).size() > 0) {
			wrapper.driver.findElement(By.xpath("//div[@class='closeDlgIframe']")).click();
		}

	}

	@Then("I should see the alert text contains {string}")
	public void i_should_see_the_alert_text_contains(String expectedAlert) {
		Assert.assertTrue(actualAlertText.contains(expectedAlert));
	}

	@Then("I should see the added patient details as {string}")
	public void i_should_see_the_added_patient_details_as(String expectedPaitentName) {

		wrapper.driver.switchTo().frame(wrapper.driver.findElement(By.xpath("//iframe[@name='pat']")));
		String actual = wrapper.driver.findElement(By.xpath("//h2[contains(text(),'Record D')]")).getText();
		Assert.assertEquals(expectedPaitentName, actual);
	}

}
