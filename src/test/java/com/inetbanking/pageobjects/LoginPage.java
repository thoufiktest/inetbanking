package com.inetbanking.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage

{
	
	WebDriver ldriver;
	
	public LoginPage (WebDriver rdriver)
	{
		
		
		ldriver=rdriver;
		
		PageFactory.initElements(rdriver,this);
		
	}
	
	
	@FindBy(xpath="//input[@name='uid']")
	@CacheLookup
	WebElement txtusername;
	
	@FindBy(xpath="//input[@name='password']")
	@CacheLookup
	WebElement txtPasswd;
	
	@FindBy(xpath="//input[@name='btnLogin']")
	@CacheLookup
	WebElement btnLogin;
	
	@FindBy(xpath="//a[normalize-space()='Log out']")
	@CacheLookup
	WebElement lnkLogout;
	
	public void setUserName(String uname)
	
	{
		txtusername.sendKeys(uname);
	}
	
public void setPassword(String pwd)
	
	{
		txtPasswd.sendKeys(pwd);
	}

public void clickSubmit()

{
	btnLogin.click();
}
	
public void clickLogout()
{
	lnkLogout.click();
}

}
