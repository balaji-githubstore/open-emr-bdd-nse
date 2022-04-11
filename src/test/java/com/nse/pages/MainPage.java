package com.nse.pages;

import org.openqa.selenium.By;

import com.nse.base.WebDriverWrapper;

public class MainPage {
	private static By patientLocator=By.xpath("//div[text()='Patient']");
	private static By newSearchLocator=By.xpath("//div[text()='New/Search']");
	
	public static String getDashboardPageTitle()
	{
		return WebDriverWrapper.driver.getTitle();
	}
	
	public static void clickOnPatient() {
		WebDriverWrapper.driver.findElement(patientLocator).click();
	}
	
	public static void clickOnNewSearch() {
		WebDriverWrapper.driver.findElement(newSearchLocator).click();
	}
}
