package it.lutech.utils;

import java.lang.ref.PhantomReference;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;

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
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(URLFASTWEB);
//		driver.manage().window().maximize();
//		Dimension d = new Dimension(0,0);
//		driver.manage().window().setSize(d);
//		driver.manage().window().setPosition(new Point(-2000, -2000));
	}

}
