package com.mystore.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Readconfig {

	Properties properties;

	String path="C:\\Users\\admin\\git\\MyWorkspace2\\MyStoreV1\\Configuration\\config.properties";

	public Readconfig() 
	{
		try 
		{
			properties =new Properties();
			FileInputStream fis = new FileInputStream(path);
			properties.load(fis);
			
		} catch (Exception e)
		
		{	
			e.printStackTrace();
		}
	}
	public String getBaseUrl() {
		
		String value=properties.getProperty("baseurl");
		
		if(value!=null)
			return value;
		else
			throw new RuntimeException("url not found");
	}
	
	public String getBrowser() {
		
		String value=properties.getProperty("browser");
		
		if(value!=null)
			return value;
		else
			throw new RuntimeException("url not found");
	}
}
