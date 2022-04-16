package com.nse.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PatienDashboardPage {
	private By patFrameLocator=By.xpath("//iframe[@name='pat']");
	private By headerLocator=By.xpath("//h2[contains(text(),'Record D')]");
	private WebDriver driver;

	public PatienDashboardPage(WebDriver driver) {
		this.driver = driver;
	}	


	public String getAddedPaitentName()
	{
		driver.switchTo().frame(driver.findElement(patFrameLocator));
		return driver.findElement(headerLocator).getText();
		
	}
}
