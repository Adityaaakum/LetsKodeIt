package com.letsKodeIt.pageclasses;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchCourses extends CommonPage {

	WebDriver driver;

	public SearchCourses(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}
	
	private String SEARCH_TEXT="//input[@name='course']";
	private String SEARCH_BUTTON="//button[@type='submit']";
	
	public void searchCourses(String course)
	{

		driver.findElement(By.xpath(SEARCH_TEXT)).sendKeys(course);
		driver.findElement(By.xpath(SEARCH_BUTTON)).click();
		
		
		
	}
	
	
	
}
