package azioni;
import org.testng.annotations.Test;

import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import it.lutech.pages.LoginPage;
import it.lutech.utils.DriverUtils;

public class Login {
	
	private WebDriver driver;
	
	Properties prop = new Properties();
	
	@Test
	public void login(){
		driver = DriverUtils.getDriver();
		DriverUtils.initializeFirefox();
		LoginPage lp = PageFactory.initElements(driver, LoginPage.class);
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		lp.compilaUserName();
		js.executeScript("document.getElementById('pw').setAttribute('value', 'Vodafone05');"); //compila password
		js.executeScript("document.getElementsByClassName('button small-button loginFormSubmit')[0].click();"); //click su "invia"
		
	}
		
	

}
