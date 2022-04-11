package com.nse.base;

import org.openqa.selenium.WebDriver;

import io.cucumber.java.After;

public class WebDriverWrapper {
	
	public static WebDriver driver;
	
	
	//run after each scenario
	@After
	public void endScenarion()
	{
		WebDriverWrapper.driver.quit();
	}

}
