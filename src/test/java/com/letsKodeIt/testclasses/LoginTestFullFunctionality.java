package com.letsKodeIt.testclasses;

import org.testng.annotations.Test;

import com.letsKodeIt.pageclasses.NavigationPageClass;
import com.letsKodeIt.pageclasses.CategoryFilterPage;
import com.letsKodeIt.pageclasses.CourseResultPage;
import com.letsKodeIt.pageclasses.FilterPageClass;
import com.letsKodeIt.pageclasses.LoginPageclasses;
import com.letsKodeIt.pageclasses.SearchCourses;

import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class LoginTestFullFunctionality extends CommonBaseClass {
	

	

	
	@Test
	public void test1() {

		 login_Page=new LoginPageclasses(driver);
  		
	
		
		login_Page.open();
		
		login_Page.signInWithCred( "test@email.com","abcabc");
		
		
		
		
	}
	@Test
	public void test2()
	{
		driver.get("https://courses.letskodeit.com/courses");
		
		search_courses= new SearchCourses(driver);
		search_courses.searchCourses("Python");
		 course_result= new CourseResultPage(driver);
		Assert.assertTrue(course_result.isElementPresent());
	
	}

	
	
	@Test
	public void test3()
	{driver.get("https://courses.letskodeit.com/courses");
		
	    filter= new CategoryFilterPage(driver);
		filter.select("Software Testing");
	
                        		
		
		           
		      //     Assert.assertTrue(isTrue);
		
		
		
	}
	
	

	}


