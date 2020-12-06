package com.letsKodeIt.pageclasses;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NavigationPageClass  extends CommonPage{

	WebDriver driver;
	
	
	public NavigationPageClass(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	private String PRACTICE_LINK ="//*[@id=\"navbar\"]/div/div/div/ul/li[1]/a";
	private String LOGIN_NAVIGATION_LINK="//*[@id=\"navbar\"]/div/div/div/ul/li[1]/a";
	
	public void practiceClick()
	{
		driver.findElement(By.xpath(PRACTICE_LINK)).click();
	}
	
	public void loginClick()
	{
		driver.findElement(By.xpath(LOGIN_NAVIGATION_LINK)).click();
	}
	
}
