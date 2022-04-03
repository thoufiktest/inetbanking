package com.inetbanking.testcases;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.inetbanking.utilities.ReadConfig;

public class BaseClass {
	
	
	
	ReadConfig readconfig=new ReadConfig();
	
	
	
	public String baseUrl=readconfig.getapplicationURL();
	
	public String username=readconfig.getUsername();
	
	public String password=readconfig.getPassword();
	
	public static WebDriver driver;
	
	public static Logger logger;
	
	@Parameters("browser")
	@BeforeClass
	
	public void setup(String br)
	{
		
		logger =Logger.getLogger("ebanking");
		
		PropertyConfigurator.configure("log4j.properties");
		
		if(br.equals("chrome"))
		{
		System.setProperty("webdriver.chrome.driver",readconfig.getChromepath());
		
		driver=new ChromeDriver();
		
		}
		
		else if(br.equals("firefox"))
			
		{
			
			System.setProperty("webdriver.gecko.driver",readconfig.getFirefoxpath());
			
			driver=new FirefoxDriver();
			
			
		}
		else if(br.equals("ie"))
		{
			System.setProperty("webdriver.ie.driver",readconfig.getiepath());
			driver = new InternetExplorerDriver();
		}
		
		else if(br.equals("edge"))
		{
			
			System.setProperty("webdriver.edge.driver",readconfig.getedgePath());
			driver = new EdgeDriver();
		}
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.get(baseUrl);
		

	
		
		
		
		
	}

@AfterClass
	public void teardown()
	{
		driver.quit();
	}
	
	
	public void captureScreen(WebDriver driver, String tname) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir") + "/Screenshots/" + tname + ".png");
		FileUtils.copyFile(source, target);
		System.out.println("Screenshot taken");
	}
	
	public String randomestring()
	{
		String generatedstring=RandomStringUtils.randomAlphabetic(8);
		return(generatedstring);
	}
	
	public static String randomeNum() {
		String generatedString2 = RandomStringUtils.randomNumeric(4);
		return (generatedString2);
	}
	
	 public boolean IsAlertPresent()//user defined method created to check alert is present or not
	  
	  {
		  
		  try
		  {
			  
			  driver.switchTo().alert();
			  return true;
		  }
		  catch(NoAlertPresentException e)
		  {
			  return false;
		  }
	  }
	  
	
}
