package com.letsKodeIt.pageclasses;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FilterPageClass  extends CommonPage{

	WebDriver driver;
	JavascriptExecutor exceutor=(JavascriptExecutor)driver;

	public FilterPageClass(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	private String DROP_DOWN_MENU = "//div[contains(@class,'course-filter')])[1]//button";
	private String DROP_DOWN_OPTION = "//a[contains(text(),'%s')]";

	public CourseResultPage selectOption(String option) {
		// TODO Auto-generated method stub

		driver.findElement(By.xpath(DROP_DOWN_MENU)).click();

		WebDriverWait wait = new WebDriverWait(driver, 3);

		WebElement dropOption = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath(String.format(DROP_DOWN_OPTION, option))));

		 exceutor.executeScript("arguments[0].click();", dropOption);

		return new CourseResultPage(driver);

	}

	public int getCount(String option) {
		// TODO Auto-generated method stub

		String textOption = driver.findElement(By.xpath(String.format(DROP_DOWN_OPTION, option))).getText();

		// Split on ( symbol
        // Example: Software IT (2)
        // Value of arrayTemp[0] ->Software IT
        // Value of arrayTemp[1] ->2)
        String[] arrayTemp = textOption.split("\\(");
        // Split arrayTemp[1] on ) symbol
        // Value of [0] ->2
        String courseCountString = arrayTemp[1].split("\\)")[0];
        int courseCount = Integer.parseInt(courseCountString);
        // Click the dropdown again to close the menu
    	driver.findElement(By.xpath(DROP_DOWN_MENU)).click();
        return courseCount;
		
		
	}

}
