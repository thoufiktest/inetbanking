package com.inetbanking.testcases;

import java.io.IOException;

import org.junit.Assert;
import org.testng.annotations.Test;

import com.inetbanking.pageobjects.LoginPage;

public class TC_LoginTest_001 extends BaseClass {
	
	@Test
	public void loginTest() throws IOException 
	{
		
		
		
		logger.info("Url is opened");
		
		LoginPage lp=new LoginPage(driver);
		
		lp.setUserName(username);
		logger.info("Entered username");
		lp.setPassword(password);
		logger.info("Entered Password" );
		lp.clickSubmit();
		
		
		if(driver.getTitle().equals("Guru99 Bank Manager HomePage"))
			
		{
			Assert.assertTrue(true);
			
			logger.info("Login test Passed");
					
		}
		
		else
		{
			
			captureScreen(driver,"loginTest");
			Assert.assertTrue(false);
			
			logger.info("Login test Failed");
			
			
		}
		
		
		
		
	}

}
