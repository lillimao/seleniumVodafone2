package it.lutech.controller;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.testng.annotations.Test;

import it.lutech.pages.HomePage;
import it.lutech.pages.LoginPage;
import it.lutech.utils.DriverUtils;
import it.lutech.utils.Utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;

@Controller
public class CaseListController {
	
	private WebDriver driver;
	
	Properties prop = new Properties();
	
	public void login(){
		driver = DriverUtils.getDriver();
		DriverUtils.initializeFirefox();
		LoginPage lp = PageFactory.initElements(driver, LoginPage.class);
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		lp.compilaUserName();
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
			driver.get(Utils.readProperties("linkListaCasi")); //va direttamente alla pagina dei casi
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