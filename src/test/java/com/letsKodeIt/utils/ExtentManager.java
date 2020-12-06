package com.letsKodeIt.utils;

import java.io.File;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentManager {

	
	private static ExtentReports extent;
	
	public static ExtentReports getInstance()//we want one report for one run even though browsers opens and closes multiple times
	{
		if(extent==null)
		{
			return createInstance();
					
		}
		else
			return extent;
	}
	
	
	public static synchronized ExtentReports createInstance()
	{
		
		          String reportName  =Util.getReportName();
		          
                                    String dirctory =  Constants.EXTENT_DIRECTORY;
                                    
                                    new File(dirctory).mkdirs();
                                  String  path = dirctory+reportName;
                                  ExtentHtmlReporter reporter= new ExtentHtmlReporter(path);
                                  
                                  reporter.config().setTheme(Theme.DARK);
                                  
                                  reporter.config().setDocumentTitle("Selenium framework reports");
                                  reporter.config().setReportName("LetsKodeIt");
                                  reporter.config().setAutoCreateRelativePathMedia(true);
                                  extent= new ExtentReports();
                                  
                                  extent.setSystemInfo("WebDriver", "Selenium");
                                  extent.setSystemInfo("Level", "Exppert");
                                  extent.attachReporter(reporter);
                                  return extent;
                                    
		
	}
	
	
}
