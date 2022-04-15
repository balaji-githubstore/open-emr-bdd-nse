package com.nse.base;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.github.bonigarcia.wdm.WebDriverManager;

public class WebDriverWrapper {
	
	public static WebDriver driver;
	
	//run after each scenario
	@After
	public void endScenarion()
	{
		WebDriverWrapper.driver.quit();
	}

}
