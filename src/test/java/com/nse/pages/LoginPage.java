package com.nse.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import com.nse.base.WebDriverWrapper;

public class LoginPage {
	private static By usernameLocator = By.cssSelector("#authUser");
	private static By passwordLocator = By.cssSelector("#clearPass");
	private static By languageLocator = By.xpath("//select[@name='languageChoice']");
	private static By loginLocator = By.id("login-button");
	private static By errorLocator=By.xpath("//*[contains(text(),'Invalid')]");

	public static void enterUsername(String username) {
		WebDriverWrapper.driver.findElement(usernameLocator).sendKeys(username);
	}

	public static void enterPassword(String password) {
		WebDriverWrapper.driver.findElement(passwordLocator).sendKeys(password);
	}

	public static void selectLanguageByText(String languageText) {
		Select selectLan = new Select(WebDriverWrapper.driver.findElement(languageLocator));
		selectLan.selectByVisibleText(languageText);
	}

	public static void clickOnLogin() {
		WebDriverWrapper.driver.findElement(loginLocator).click();
	}

	public static String getInvalidErrorMessage() {
		String text = WebDriverWrapper.driver.findElement(errorLocator).getText();
		return text;
	}
}
