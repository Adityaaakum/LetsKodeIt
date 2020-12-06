package com.letsKodeIt.pageclasses;

import javax.print.DocFlavor.STRING;
import javax.swing.plaf.basic.BasicGraphicsUtils;

import org.omg.CORBA.PRIVATE_MEMBER;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.letsKodeIt.utils.Util;

public class LoginPageclasses extends CommonPage {

	
	/*
	variables- url, private locators of each element
	
	
	
	*/
	
	
	WebDriver driver;

	public LoginPageclasses(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}
	
	private String LOGIN_LINK="//div[contains(text(),'Sign')]";

	private String AGAINLOGIN_LINK="//a[contains(text(),'Sign')]";
	private String EMAILD_ID="email";
	private String PASSWORD_ID="password";
	private  String LOG_BUTTON="//input[@value='Login']";
	private String LOG_VERIFY="//img[contains(@class,'zl')]";
	private String LOG_OUT="//a[contains(@href,'/logout')]";
	private String LOG_VERIFY2="//a[contains(@href,'courses')]";
	
	public void open()
	{
		driver.findElement(By.xpath(LOGIN_LINK)).click();;
		
	}
	
	public void reopen()
	{
		driver.findElement(By.xpath(AGAINLOGIN_LINK)).click();;
		
	}
	
	public NavigationPageClass signInWithCred(String email,String password)
	{
		 WebElement element_Email  =driver.findElement(By.id(EMAILD_ID));
		 element_Email.clear();
		 element_Email.sendKeys(email);
		 WebElement element_Password  =driver.findElement(By.id(PASSWORD_ID));
		 element_Password.clear();
		 element_Password.sendKeys(password);
		 driver.findElement(By.xpath(LOG_BUTTON)).click();
		 return new  NavigationPageClass(driver);
	}
	
	public boolean isLogined()
	{try
	{
		return driver.findElement(By.xpath(LOG_VERIFY))!=null;}
	
	catch (Exception e) {
		
		System.out.println("Login verificattion 1 failed");// TODO: handle exception
		return false;
	}
	}
	
	public void logOut()
	{
		driver.findElement(By.xpath(LOG_VERIFY)).click();
		driver.findElement(By.xpath(LOG_OUT)).click();
	}
	
	public boolean isLogin2()
	{
		try {
          return driver.findElements(By.xpath(LOG_VERIFY2)).size()>0;
	}
		catch (Exception e) {
			System.out.println("Login 2 failed");
			return false;
		}
}
}
