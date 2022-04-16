package com.nse.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import com.nse.base.WebDriverKeywords;

public class LoginPage extends WebDriverKeywords {
	private By usernameLocator = By.cssSelector("#authUser");
	private By passwordLocator = By.cssSelector("#clearPass");
	private By languageLocator = By.xpath("//select[@name='languageChoice']");
	private By loginLocator = By.id("login-button");
	private By errorLocator=By.xpath("//*[contains(text(),'Invalid')]");
	
	private WebDriver driver;

	public LoginPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}
	
	
	public void enterUsername(String username) {
		typeOnElement(usernameLocator, username);
	}

	public void enterPassword(String password) {
		typeOnElement(passwordLocator, password);
	}

	public void selectLanguageByText(String languageText) {
		selectDropdownByText(languageLocator,languageText);
	}

	public void clickOnLogin() {
		clickOnElement(loginLocator);
	}

	public String getInvalidErrorMessage() {
		String text = driver.findElement(errorLocator).getText();
		return text;
	}
}
