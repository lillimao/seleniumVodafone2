package azioni;
import org.testng.annotations.Test;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.springframework.beans.factory.annotation.Autowired;

import it.lutech.pages.LoginPage;
import it.lutech.utils.AppProperties;
import it.lutech.utils.DriverUtils;

public class Login {

	private WebDriver driver;

	private AppProperties app;

	@Autowired
	public void setApp(AppProperties app) {
		this.app = app;
	}

	@Test
	public void login(){
		driver = DriverUtils.getDriver();
		DriverUtils.initializeFirefox();
		LoginPage lp = PageFactory.initElements(driver, LoginPage.class);
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		driver.findElement(By.name("un")).clear();
		driver.findElement(By.name("un")).sendKeys("governance.nmcpm@mail.vodafone.it");
		driver.findElement(By.name("pw")).clear();
		driver.findElement(By.name("pw")).sendKeys("Vodafone05");		
		//lp.compilaUserName(app.getUsername()); //non funziona su centos!?
//		js.executeScript("document.getElementById('un').setAttribute('value', 'governance.nmcpm@mail.vodafone.it');"); //compila username
//		js.executeScript("document.getElementById('pw').setAttribute('value', 'Vodafone05');"); //compila password
		js.executeScript("document.getElementsByClassName('button small-button loginFormSubmit')[0].click();"); //click su "invia"
		
	}
		
	

}
