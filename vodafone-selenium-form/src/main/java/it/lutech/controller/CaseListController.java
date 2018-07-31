package it.lutech.controller;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import it.lutech.pages.LoginPage;
import it.lutech.utils.AppProperties;
import it.lutech.utils.DriverUtils;

@Controller
public class CaseListController {
	
	private WebDriver driver;
	
	private AppProperties app;
	
	@Autowired
	public void setApp(AppProperties app) {
		this.app = app;
	}	
	
	public void login(){
		driver = DriverUtils.getDriver();
		DriverUtils.initializeFirefox();
		LoginPage lp = PageFactory.initElements(driver, LoginPage.class);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		lp.compilaUserName(app.getUsername());
		js.executeScript("document.getElementById('pw').setAttribute('value', 'Vodafone05');"); //compila password
		js.executeScript("document.getElementsByClassName('button small-button loginFormSubmit')[0].click();"); //click su "invia"
		
	}
	
	public void goCasi(){
			driver = DriverUtils.getDriver();
			try {
				Thread.sleep(5000);
			} catch (Exception e) {
				e.printStackTrace();
			}
			driver.get(app.getLinkListaCasi()); //va direttamente alla pagina dei casi
		}

	@GetMapping("/casesList")
    public String index() {
		//TODO selenium
		System.out.println("prima");
		login();
		System.out.println("dopo");
		goCasi();
		System.out.println("dopo2");
        return "casesList";
    }

}