package com.inetbanking.testcases;

import java.io.IOException;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Duration;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetbanking.pageobjects.AddCustomerPage;
import com.inetbanking.pageobjects.LoginPage;

public class TC_AddCustomerTest_003 extends BaseClass {

	
	
	
	@Test
	public void addNewCustomer() throws InterruptedException, IOException
	{
		LoginPage lp=new LoginPage(driver);
		lp.setUserName(username);
		logger.info("User name is provided");
		lp.setPassword(password);
		logger.info("Passsword is provided");
		lp.clickSubmit();
		
		AddCustomerPage addcust=new AddCustomerPage(driver);
		
		addcust.clickAddNewCustomer();
		
		/*WebDriverWait wait=new WebDriverWait(driver, 20);
		WebElement guru99;
		guru99=wait.until(ExpectedConditions.elementToBeClickable(By.id("prime-popover-close-button")));
		
		guru99.click();*/
			
		  logger.info("providing customer details....");
			addcust.custName("Thoufeek");
			addcust.custgender("male");
			addcust.custdob("10","15","1985");
			Thread.sleep(5000);
			addcust.custaddress("INDIA");
			addcust.custcity("CBE");
			addcust.custstate("TAN");
			addcust.custpinno("5000074");
			addcust.custtelephoneno("987890091");
			
			String email=randomestring()+"@gmail.com";
			addcust.custemailid(email);
			addcust.custpassword("abcdef");
			addcust.custsubmit();
			
			Thread.sleep(3000);
			
			logger.info("validation started....");
			
			boolean res=driver.getPageSource().contains("Customer Registered Successfully!!!");
			
			if(res==true)
			{
				Assert.assertTrue(true);
				logger.info("test case passed....");
				
			}
			else
			{
				logger.info("test case failed....");
				captureScreen(driver,"addNewCustomer");
				Assert.assertTrue(false);
			}
}
}

