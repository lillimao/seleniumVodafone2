package azioni;

import org.testng.annotations.Test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.springframework.beans.factory.annotation.Autowired;

import it.lutech.pages.CasoCreatoPage;
import it.lutech.pages.HomePage;
import it.lutech.utils.AppProperties;
import it.lutech.utils.DriverUtils;

public class Cerca {
	
	private WebDriver driver;
	private CasoCreatoPage ccp;
	
	private AppProperties app;
	
	@Autowired
	public void setApp(AppProperties app) {
		this.app = app;
	}	
	
	@Test
	public void cercaCaso(){
		driver = DriverUtils.getDriver();
		ccp = PageFactory.initElements(driver, CasoCreatoPage.class);
		try {
			Thread.sleep(5000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		driver.get(app.getLinkHomePage()); //va direttamente alla homepage
		HomePage hm = PageFactory.initElements(driver, HomePage.class);
		hm.compilaCerca();
		hm.clickVai();
		System.out.println(ccp.commento2());
		
	}

}
