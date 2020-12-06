package com.letsKodeIt.pageclasses;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CategoryFilterPage extends CommonPage {

    public CategoryFilterPage(WebDriver driver) {
    	super(driver);
        this.driver = driver;
        js = (JavascriptExecutor) driver;
    }

    /***
     * Variables
     * URL
     * Title
     */
    public WebDriver driver;
    private JavascriptExecutor js;
    private String CATEGORY_DROPDOWN = "xpath=>//*[@name='categories']";
  //  private String CATEGORY_OPTION = "//a[@href='/courses/category/%s']";

    /***
     * Methods
     */

    public 	CourseResultPage select(String categoryName) {
        // Find category dropdown
        WebElement categoryDropdown = getElement(CATEGORY_DROPDOWN, "categorie dropdown");
       elementClick(categoryDropdown, "clicking on dropdown");
        Select select=new Select(categoryDropdown);
        select.selectByIndex(1);
       // js.executeScript("arguments[0].click();", categoryDropdown);
        // Wait for the element to be clickable
       
        return new CourseResultPage(driver);
    }

   
    
}