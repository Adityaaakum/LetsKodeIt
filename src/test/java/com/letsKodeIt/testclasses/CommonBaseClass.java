package com.letsKodeIt.testclasses;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.letsKodeIt.customDriver.CustomDriver;
import com.letsKodeIt.pageclasses.CategoryFilterPage;
import com.letsKodeIt.pageclasses.CourseResultPage;
import com.letsKodeIt.pageclasses.LoginPageclasses;
import com.letsKodeIt.pageclasses.SearchCourses;
import com.letsKodeIt.utils.Constants;

public class CommonBaseClass  {

	public WebDriver driver;
	LoginPageclasses login_Page;
	

	SearchCourses search_courses;
	CourseResultPage course_result;
	CategoryFilterPage filter;
	@Parameters({"browser"})
	@BeforeClass
	public void commonbeforeClass(String browser) {

	
		driver=FactoryClassDriver.getFactoryinstance().getDriver(browser);
		
		driver.get(Constants.BASE_URL);
	}
	
	@AfterClass
	public void afterClasses() throws InterruptedException {
		FactoryClassDriver.getFactoryinstance().quit();
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
