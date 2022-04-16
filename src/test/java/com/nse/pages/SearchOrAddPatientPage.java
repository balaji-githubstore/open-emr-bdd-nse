package com.nse.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchOrAddPatientPage {
	private By patFrameLocator=By.xpath("//iframe[@name='pat']");
	private By firstnameLocator=By.id("form_fname");
	private By lastnameLocator=By.id("form_lname");
	private By createLocator= By.id("create");
	private By confirmLocator=By.xpath("//input[@value='Confirm Create New Patient']");
	private By hbdLocator=By.xpath("//div[@class='closeDlgIframe']");
	
	private WebDriver driver;

	public SearchOrAddPatientPage(WebDriver driver) {
		this.driver = driver;
	}	


	public void enterFirstName(String firstname)
	{
		driver.switchTo().frame(driver.findElement(patFrameLocator));
		driver.findElement(firstnameLocator).sendKeys(firstname);
	}
	
	public void enterLastName(String lastname)
	{
		driver.findElement(lastnameLocator).sendKeys(lastname);
	}

	public void enterDOB()
	{
		
	}
	
	public void selectGender()
	{
		
	}
	public void clickOnCreateNewPaitent()
	{
		driver.findElement(createLocator).click();
		driver.switchTo().defaultContent();
	}
	
	public void clickOnConfirmCreateNewPatient()
	{
		driver.switchTo().frame("modalframe");
		driver.findElement(confirmLocator).click();
		driver.switchTo().defaultContent();
	}
	
	public String getAlertTextAndHandleAlert()
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.alertIsPresent());
		String alertText = driver.switchTo().alert().getText();
		driver.switchTo().alert().accept();
		
		return alertText;
	}
	
	public void closeHappyBirthday()
	{
		if (driver.findElements(hbdLocator).size() > 0) {
			driver.findElement(hbdLocator).click();
		}
	}
}
