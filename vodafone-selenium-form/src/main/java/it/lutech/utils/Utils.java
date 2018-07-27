package it.lutech.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Utils {
	
	public static String readProperties(String keyToRead){
		Properties prop = new Properties();
		
		try {
			InputStream input = new FileInputStream("/home/lisa/vodafone_selenium/vodafone-selenium-form/src/main/resources/varie.properties");
			prop.load(input);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return prop.getProperty(keyToRead);
		
	}

}
