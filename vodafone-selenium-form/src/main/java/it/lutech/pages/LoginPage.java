package it.lutech.pages;

import java.util.Properties;

import javax.xml.ws.WebEndpoint;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import it.lutech.utils.AppProperties;

public class LoginPage {
	
	//** ELEMENTI **//
	
	@FindBy(name="un")
	private WebElement username;
	
	@FindBy(name="pw")
	private WebElement password;

	@FindBy(className="button small-button proploginFormSubmit")
	private WebElement invia;
	
	//** METODI **//
	
	public void compilaUserName(String user){
		try {
			username.clear();
			username.sendKeys(user);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
}
