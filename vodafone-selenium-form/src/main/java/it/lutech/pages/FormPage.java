package it.lutech.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import it.lutech.utils.ExcelUtils;

public class FormPage {
	
	//** VARIABILI **//
	
//	private String servizioS = ExcelUtils.stampaCelle(2, 1); //TODO
	
//	private String consistenzaS = "FWB_VOM _0000006083"; 
//	
//	private String sedeS = "LA00239599 - VIA TRAVERSAGNA SUD SNC, 56019 VECCHIANO"; 
//	
//	private String problemaS = "CIRCUITO DOWN"; 
//	
//	private String orarioReperibilitaS = "08:00-12:00 13:00-16:30"; 
//	
//	private String reperibilitaFestiviS = "No"; 
//	
//	private String idCircuitoS = "CS_VOF003F"; 
//	
//	private String ticketClienteS = "123"; 
//	
//	private String commentoS = "123 sdhfshd"; 
//	
//	private String nomeReferenteS = "gigi"; 
//	
//	private String cognomeReferenteS = "lalla"; 
//	
//	private String emailReferenteS = "gigi.lalla@gmail.com"; 
//	
//	private String telefonoReferenteS = "3333333333"; 
//	
//	private String nomeReferente24S = "gigi"; 
//	
//	private String cognomeReferente24S = "lalla"; 
//	
//	private String emailReferente24S = "gigi.lalla@gmail.com"; 
//	type filter text
//	private String telefonoReferente24S = "3333333333"; 
//	
//	private String scegliFileS = "/home/lisa/vodafone_selenium/vodafone-selenium-form/src/main/resources/fileUpload"; 
	
	//** ELMENTI **//
	
	@FindBy(className = "/html/body/div/div/div[3]/table/tbody/tr/td[2]/form/div[1]/div/div/div/div/div[2]/div[1]/div[2]/table/tbody/tr[2]/th/label")
	private WebElement tipo;
	
	@FindBy(name="Page:myForm:j_id66:DF1:j_id100:j_id105")
	private WebElement servizio;
	
	@FindBy(name="Page:myForm:j_id66:DF1:contAsset:asset")
	private WebElement consistenza;
	
	@FindBy(id="Page:myForm:j_id66:DF1:contAsset:asset_lkwgt")
	private WebElement cercaConsistenza;
	
	@FindBy(id="/html/body/form/div[1]/div[2]/div[2]/div/div/div/div[1]/table/tbody/tr/td[1]/a")
	private WebElement giustaConsistenza;
	
	@FindBy(name="Page:myForm:j_id66:DF1:j_id133:j_id137")
	private WebElement sede;

	@FindBy(name="Page:myForm:j_id66:DF1:problemCase:problema")
	private WebElement problema;
	
	@FindBy(name="Page:myForm:j_id66:DF1:OrariUfficio:j_id150")
	private WebElement orarioReperibilità;
	
	@FindBy(name="Page:myForm:j_id66:DF1:j_id154:j_id159")
	private WebElement reperibilitaFestivi;
	
	@FindBy(name="Page:myForm:j_id66:j_id166:descrizioneItem:descrizioneField")
	private WebElement idCircuito;

	@FindBy(name="Page:myForm:j_id66:j_id166:j_id173")
	private WebElement ticketCliente;
	
	@FindBy(name="Page:myForm:j_id66:j_id166:j_id174")
	private WebElement commento;
	
	@FindBy(name="Page:myForm:j_id66:j_id175:j_id176")
	private WebElement nomeReferente;
	
	@FindBy(name="Page:myForm:j_id66:j_id175:j_id177")
	private WebElement cognomeReferente;
	
	@FindBy(name="Page:myForm:j_id66:j_id175:j_id178")
	private WebElement emailReferente;
	
	@FindBy(name="Page:myForm:j_id66:j_id175:j_id179")
	private WebElement telefonoReferente;
	
	@FindBy(name="Page:myForm:j_id66:j_id180:j_id181:j_id185")
	private WebElement nomeReferente24;
	
	@FindBy(name="Page:myForm:j_id66:j_id180:j_id188:j_id192")
	private WebElement cognomeReferente24;
	
	@FindBy(name="Page:myForm:j_id66:j_id180:j_id195:j_id199")
	private WebElement emailReferente24;
	
	@FindBy(name="Page:myForm:j_id66:j_id180:j_id202:j_id206")
	private WebElement telefonoReferente24;
	
	@FindBy(name="Page:myForm:j_id66:allegato:allegaFile:file:inputFile:file")
	private WebElement scegliFile;
	
	@FindBy(name="Page:myForm:j_id66:allegato:allegaFile:j_id216")
	private WebElement uploadFile;

	@FindBy(name="Page:myForm:j_id66:buttons:bottom:save")
	private WebElement confermaInserimento;
	
	//** METODI **//
	
//	public String getServizioS(String servizioS) {
//		return servizioS;
//	}
	
//	public String getOrarioReperibilitaS() {
//		return orarioReperibilitaS;
//	}
//	
//	public String getReperibilitaFestiviS() {
//		return reperibilitaFestiviS;
//	}
	
	public void stampaEtichetta(){
		
		System.out.println(tipo.getText());
	}

	public void selezionaServizio(String servizioS){
		try {
			Select drop = new Select(servizio);
			drop.selectByVisibleText(servizioS);
		} catch (Exception e) {
  			e.printStackTrace();
		}
	}
	
	public void scriviCosistenza(String consistenzaS){
		try {
			consistenza.sendKeys(consistenzaS);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void cercaConsistenza(){
		try {
			cercaConsistenza.click();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void clickGiustaConsistenza(){
		try {
			giustaConsistenza.click();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void selezionaSede(String sedeS){
		try {
			Select drop = new Select(sede);
			drop.selectByVisibleText(sedeS);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void selezionaProblema(String problemaS){
		try {
			Select drop = new Select(problema);
			drop.selectByVisibleText(problemaS);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void selezionaOrarioReperibilità(String orarioReperibilitaS){
		try {
			Select drop = new Select(orarioReperibilità);
			drop.selectByVisibleText(orarioReperibilitaS);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void selezionaReperibilitaFestivi(String reperibilitaFestiviS){
		try {
			Select drop = new Select(reperibilitaFestivi);
			drop.selectByVisibleText(reperibilitaFestiviS);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void compilaIdCircuito(String idCircuitoS){
		try {
			idCircuito.sendKeys(idCircuitoS);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void compilaTicketCliente(String ticketClienteS){
		try {
			ticketCliente.sendKeys(ticketClienteS);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void compilaCommento(String commentoS){
		try {
			commento.sendKeys(commentoS);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void compilaNomeReferente(String nomeReferenteS){
		try {
			nomeReferente.sendKeys(nomeReferenteS);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void compilaCognomeReferente(String cognomeReferenteS){
		try {
			cognomeReferente.sendKeys(cognomeReferenteS);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void compilaEmailReferente(String emailReferenteS){
		try {
			emailReferente.sendKeys(emailReferenteS);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void compilaTelefonoReferente(String telefonoReferenteS){
		try {
			telefonoReferente.sendKeys(telefonoReferenteS);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void compilaNomeReferente24(String nomeReferente24S){
		try {
			nomeReferente24.sendKeys(nomeReferente24S);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void compilaCognomeReferente24(String cognomeReferente24S){
		try {
			cognomeReferente24.sendKeys(cognomeReferente24S);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void compilaEmailReferente24(String emailReferente24S){
		try {
			emailReferente24.sendKeys(emailReferente24S);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void compilaTelefonoReferente24(String telefonoReferente24S){
		try {
			telefonoReferente24.sendKeys(telefonoReferente24S);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void clickScegliFile(String scegliFileS){
		try {
			scegliFile.sendKeys(scegliFileS);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void clickUploadFile(){
		try {
			uploadFile.click();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void uploadFile(String scegliFileS){
		clickScegliFile(scegliFileS);
		clickUploadFile();
	}
	
	public void clickConfermaInserimento(){
		try {
			confermaInserimento.click();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	
	
	
}


