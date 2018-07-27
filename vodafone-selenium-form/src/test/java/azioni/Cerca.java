package azioni;

import org.testng.annotations.Test;

import java.util.Properties;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import it.lutech.pages.HomePage;
import it.lutech.utils.DriverUtils;
import it.lutech.utils.Utils;

public class Cerca {
	
	private WebDriver driver;
	
	
	@Test
	public void cercaCaso(){
		driver = DriverUtils.getDriver();
		try {
			Thread.sleep(5000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		driver.get(Utils.readProperties("linkHomePage")); //va direttamente alla homepage
		HomePage hm = PageFactory.initElements(driver, HomePage.class);
		hm.compilaCerca();
		hm.clickVai();
	}

}
