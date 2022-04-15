package com.nse.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage {
	private By patientLocator = By.xpath("//div[text()='Patient']");
	private By newSearchLocator = By.xpath("//div[text()='New/Search']");

	private WebDriver driver;

	public MainPage(WebDriver driver) {
		this.driver = driver;
	}	

	public String getDashboardPageTitle() {
		return driver.getTitle();
	}

	public void clickOnPatient() {
		driver.findElement(patientLocator).click();
	}

	public void clickOnNewSearch() {
		driver.findElement(newSearchLocator).click();
	}
}
