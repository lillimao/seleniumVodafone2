package it.lutech.pages;

import java.util.Properties;

import javax.xml.ws.WebEndpoint;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import it.lutech.utils.Utils;

public class LoginPage {
	
	Properties prop = new Properties();
	
	//** ELEMENTI **//
	
	@FindBy(name="un")
	private WebElement username;
	
	@FindBy(name="pw")
	private WebElement password;

	@FindBy(className="button small-button loginFormSubmit")
	private WebElement invia;
	
	//** METODI **//
	
	public void compilaUserName(){
		try {
			username.sendKeys(Utils.readProperties("username"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
}
