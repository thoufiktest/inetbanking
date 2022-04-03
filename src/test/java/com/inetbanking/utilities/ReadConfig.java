package com.inetbanking.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {
	
	
	
	Properties pro;
	
	
	public ReadConfig()
	
	{
		
		File src=new File("./Configuration files/config.properties");
		
		try
		{
			
			FileInputStream fis= new FileInputStream(src);
			
			pro=new Properties();
			
			pro.load(fis);
			
				} 
		 catch (Exception e) {
			 
			 System.out.println("Exception is "+e.getMessage());
		 }
					
	}
	
	public String getapplicationURL()
	{
		
		
		String url=pro.getProperty("BaseURL");
		
		return url;
	}

	
	public String getUsername()
	{
		String Uname=pro.getProperty("username");
		return Uname;
	}
	
	
	public String getPassword()
	
	{
		String Passwd=pro.getProperty("password");
		return Passwd;
		
	}
	
	
	public String getChromepath()
	
	{
		
		String chromePath=pro.getProperty("chromepath");
		return chromePath;
	}
	
	public String getFirefoxpath()
	
	{
		
		String Firefoxpath=pro.getProperty("firefoxpath");
		return Firefoxpath;
		
	}

public String getiepath()

{
	String iepath=pro.getProperty("iepath");
	return iepath;
	
}

public String getedgePath()
{
String edgepath=pro.getProperty("edgepath");
return edgepath;
}


}
