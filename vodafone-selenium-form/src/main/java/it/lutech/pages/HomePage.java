package it.lutech.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage {
	
	public String idCaso = "prova"; //TODO

	//** ELEMENTI **//

	@FindBy(name="sbstr")
	private WebElement cercaField;

	@FindBy(name="search")
	private WebElement vaiButton;

	//** METODI **//

	public void compilaCerca(){
		try {
			cercaField.sendKeys(idCaso);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void clickVai(){
		try {
			vaiButton.click();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void setIdCaso(String id){
		idCaso = id;
	}

}
