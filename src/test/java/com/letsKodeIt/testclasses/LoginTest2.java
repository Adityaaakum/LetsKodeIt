package com.letsKodeIt.testclasses;

import org.testng.annotations.Test;

import com.letsKodeIt.pageclasses.NavigationPageClass;
import com.letsKodeIt.pageclasses.CategoryFilterPage;
import com.letsKodeIt.pageclasses.CourseResultPage;
import com.letsKodeIt.pageclasses.FilterPageClass;
import com.letsKodeIt.pageclasses.LoginPageclasses;
import com.letsKodeIt.pageclasses.SearchCourses;
import com.letsKodeIt.utils.Constants;
import com.letsKodeIt.utils.ExcelUtility;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;

public class LoginTest2  extends CommonBaseClass{
@DataProvider(name = "verifyLogin")
	public Object[][] getData()
	{
	     ExcelUtility.setExcelFile(Constants.USER_DIRECTORY+"\\resources\\5-ExcelTestData.xlsx", "AllCoursesTests");
	       Object[][] testdata=ExcelUtility.getTestData("verify_login");
	       return testdata;
	}
	{
		
	}
	
	@Test(dataProvider = "verifyLogin")
	public void test1(String username,String password) {

	 
		login_Page=new LoginPageclasses(driver);
  		
	CheckPoint.cleanHashMap();
		
		login_Page.open();
		
		login_Page.signInWithCred( username,password);
		
		CheckPoint.mark("test1", login_Page.isLogined(), "checking gravatar");
		
		CheckPoint.markfinal("test1", login_Page.isLogin2(), "checking all courses page");
		login_Page.logOut();
		
	}
	@Test(enabled = false)
	public void test2()
	{

		login_Page.reopen();
		
		login_Page.signInWithCred( "test1@email.com","abcabc");
		
		Assert.assertFalse(login_Page.isLogined());
	
	}


	
	


}
