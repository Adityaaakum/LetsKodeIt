package com.letsKodeIt.pageclasses;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CourseResultPage  extends CommonPage{

	WebDriver driver;
	
	private String SEARCH_RESULT="xpath=>//div[contains(@class,'col-lg-4 col-md-4 col-sm-6 col-xs-12')]";
	private String SEARCH_URL="?query";

	public CourseResultPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}
	
	
	public int isElementsPresent()
	{
		
		 return getElementList(SEARCH_RESULT, "yaha thi dikkat").size();
	}
	
	
	public boolean isElementPresent()
	{
		boolean result= false;
		if(isElementsPresent()>0)
		{
			result=true;
		}
		
		return result;
		}
	


 

     public boolean isCountEqual(int coursesCount) {

	           
    	 
    	return  isElementsPresent()==coursesCount ;
	
	
	// TODO Auto-generated method stub

}
     }
