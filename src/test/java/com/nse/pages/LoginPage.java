package com.nse.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class LoginPage {
	private By usernameLocator = By.cssSelector("#authUser");
	private By passwordLocator = By.cssSelector("#clearPass");
	private By languageLocator = By.xpath("//select[@name='languageChoice']");
	private By loginLocator = By.id("login-button");
	private By errorLocator=By.xpath("//*[contains(text(),'Invalid')]");
	
	private WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}
	
	
	public void enterUsername(String username) {
		driver.findElement(usernameLocator).sendKeys(username);
	}

	public void enterPassword(String password) {
		driver.findElement(passwordLocator).sendKeys(password);
	}

	public void selectLanguageByText(String languageText) {
		Select selectLan = new Select(driver.findElement(languageLocator));
		selectLan.selectByVisibleText(languageText);
	}

	public void clickOnLogin() {
		driver.findElement(loginLocator).click();
	}

	public String getInvalidErrorMessage() {
		String text = driver.findElement(errorLocator).getText();
		return text;
	}
}
