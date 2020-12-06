package com.letsKodeIt.testclasses;

import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.CapabilityType;

import com.letsKodeIt.utils.Constants;

public class FactoryClassDriver {
	
	private static final Logger loggers= LogManager.getLogger(FactoryClassDriver.class);
	  private static ThreadLocal<String> threadedBrowser = new ThreadLocal<String>();
	
	private static final FactoryClassDriver factory_driver= new FactoryClassDriver();

	private FactoryClassDriver() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public static FactoryClassDriver getFactoryinstance()
	{
		
		
		return factory_driver;
	}
	
	public String getBrowser()
	{
		 return threadedBrowser.get();
	}
	
	
	private static final ThreadLocal<WebDriver> threadedDriver= new ThreadLocal<WebDriver>();
	
	public WebDriver getDriver(String browser)
	{
		threadedBrowser.set(browser);
		setDriver(browser);
		WebDriver driver= null;
		if(threadedDriver.get()==null)
		{
			if(browser.equalsIgnoreCase(Constants.BROWSER_FIREFOX))
			{
				FirefoxOptions firefox= ffOptions();
				driver=new FirefoxDriver(firefox);
				threadedDriver.set(driver);
			}
			if(browser.equalsIgnoreCase(Constants.BROWSER_CHROME))
			{
				ChromeOptions options= chromeOptions();
				driver= new ChromeDriver(options);
				threadedDriver.set(driver);
			}
		}
		
		threadedDriver.get().manage().window().maximize();
		threadedDriver.get().manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		
		return threadedDriver.get();
	}
	
	public void quit()
	{
		threadedDriver.get().quit();
		threadedDriver.set(null);
	}

	public void setDriver(String browser)
	{
		
		
		String dir=Constants.USER_DIRECTORY+Constants.USER_FOLDER+"";
	
		String path="";
		String key="";
		String value="";
		
		String os=Constants.OS_NAME.toLowerCase().substring(0,3);
		if(browser.equalsIgnoreCase(Constants.BROWSER_FIREFOX))
		{
			key=Constants.FIREFOX_DRIVER_KEY;
			value=Constants.FIREFOX_DRIVER_VALUE;
			loggers.info("Firefox driver set");
			
		}
		else if (browser.equalsIgnoreCase(Constants.BROWSER_CHROME)) {
			
			
				key=Constants.CHROME_DRIVER_KEY;
				value=Constants.CHROME_DRIVER_VALUE;
				loggers.info("Chrome driver set");
			}
			path=dir+value+(os.equals("win")?".exe":"");
			System.out.println(path);
			System.setProperty(key, path);
			loggers.info("System.setProperty");
		}
		
		private FirefoxOptions ffOptions()
		{
			
			
			FirefoxOptions firefox= new FirefoxOptions();
			firefox.setCapability(CapabilityType.HAS_NATIVE_EVENTS, false);
			return firefox;
		}
		
		private ChromeOptions chromeOptions()
		{
			ChromeOptions option= new ChromeOptions();
			option.addArguments("disable-infobars");
			return option;
		}
		
	}
	

