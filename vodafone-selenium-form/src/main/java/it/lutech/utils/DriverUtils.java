package it.lutech.utils;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverUtils {
	
	private static WebDriver driver;
	
	private static String URLFASTWEB = "https://www.fastweb.it/wholesale/";

	public static WebDriver getDriver(){
		System.setProperty("webdriver.gecko.driver","/usr/local/bin/geckodriver");
		if(driver == null){
		driver = new FirefoxDriver();
		return driver;
		} 
		else return driver; 
	}
	
	public static void initializeFirefox(){
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get(URLFASTWEB);
		driver.manage().window().maximize();
	}

}
