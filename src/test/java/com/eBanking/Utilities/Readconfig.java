package com.eBanking.Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class Readconfig {

Properties pro;
public Readconfig() {
	
	File src= new File("./Configuration/config.properties");
	try
	{
	FileInputStream fis= new FileInputStream(src);
	pro= new Properties();
	pro.load(fis);
	}
	catch(Exception e){
		
		System.out.println("Exception is"+ e.getMessage());
		
	}
}

public String getApplicationurl() {
	 String url=pro.getProperty("baseurl");
	 return url;
}

public String getUsername() {
	 String username=pro.getProperty("username");
	 return username;
}

public String getPassword() {
	 String pass=pro.getProperty("password");
	 return pass;
}

public String getFirepath() {
	 String fpath=pro.getProperty("firepath");
	 return fpath;
}

public String getChromepath() {
	 String cpath=pro.getProperty("chromepath");
	 return cpath;
}
}
