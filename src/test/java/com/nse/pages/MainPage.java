package com.nse.pages;

import com.nse.base.WebDriverWrapper;

public class MainPage {

	
	public static String getDashboardPageTitle()
	{
		return WebDriverWrapper.driver.getTitle();
	}
}
