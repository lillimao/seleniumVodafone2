package it.lutech.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CasoCreatoPage {
	
	//** ELEMENTI **//
	
//	@FindBy(className="pageDescription")
//	private WebElement numeroCaso;
	
//	@FindBy(id="j_id0:j_id23:j_id39:j_id42:j_id43")
	@FindBy(xpath="/html/body/div/div/div[3]/table/tbody/tr/td[2]/form[1]/span[2]/div/div/div/div/div[2]/span/div[1]/div/table/tbody/tr[1]/td[1]")
	private WebElement numeroCaso;
	
	@FindBy(id="j_id0:j_id23:j_id39:j_id42:j_id45")
	private WebElement ticketID;
	
	@FindBy(id="j_id0:j_id23:j_id39:j_id42:j_id47")
	private WebElement cliente;
	
	@FindBy(id="")    //TODO
	private WebElement consistenza;
	
	@FindBy(id="j_id0:j_id23:j_id39:j_id42:j_id53")
	private WebElement servizio;
	
	@FindBy(id="j_id0:j_id23:j_id39:j_id42:j_id56")
	private WebElement codiceChiusura;
	
//	@FindBy(xpath="/html/body/div[1]/div/div[3]/table/tbody/tr/td[2]/form[1]/span[2]/div/div/div/div/div[2]/span/div[1]/div/table/tbody/tr[6]/td[1]")
	@FindBy(id="j_id0:j_id23:j_id39:j_id42:j_id61")
	private WebElement stato;
	
	@FindBy(id="j_id0:j_id23:j_id39:j_id42:j_id44")
	private WebElement problema;
	
	@FindBy(id="j_id0:j_id23:j_id39:j_id42:j_id46")
	private WebElement dataOraApertura;
	
	@FindBy(id="j_id0:j_id23:j_id39:j_id42:j_id48")
	private WebElement dataAggticket;
	
	@FindBy(id="j_id0:j_id23:j_id39:j_id42:j_id52")
	private WebElement orarioReperibilita;
	
	@FindBy(id="j_id0:j_id23:j_id39:j_id42:j_id54")
	private WebElement reperibilitaFestivi;
	
	@FindBy(id="j_id0:j_id23:j_id39:j_id42:j_id57")
	private WebElement azioneRichiesta;
	
	@FindBy(id="j_id0:j_id23:j_id39:j_id42:j_id62")
	private WebElement causaEffettiva;
	
	@FindBy(id="j_id0:j_id23:j_id39:j_id70:j_id71")
	private WebElement descrizione;
	
	@FindBy(id="j_id0:j_id23:j_id39:j_id70:j_id72")
	private WebElement numTicketClt;
	
	@FindBy(id="j_id0:j_id23:j_id39:j_id70:j_id73")
	private WebElement commento;
	
	@FindBy(xpath="/html/body/div[1]/div/div[3]/table/tbody/tr/td[2]/form[1]/span[2]/div/div/div/div/div[2]/span/div[3]/div[2]/table/tbody/tr[1]/td[1]")
	private WebElement cognomeRef;
	
	@FindBy(xpath="/html/body/div[1]/div/div[3]/table/tbody/tr/td[2]/form[1]/span[2]/div/div/div/div/div[2]/span/div[3]/div[2]/table/tbody/tr[2]/td[1]")
	private WebElement nomeRef;
	
	@FindBy(id="j_id0:j_id23:j_id39:j_id74:j_id76")
	private WebElement emailRef;
	
	@FindBy(id="j_id0:j_id23:j_id39:j_id74:j_id78")
	private WebElement telRef;
	
	@FindBy(xpath="/html/body/div[1]/div/div[3]/table/tbody/tr/td[2]/form[3]/span/div/div/div/div/div[2]/table/tbody/tr[1]/td[1]")
	private WebElement commento1;
	
	@FindBy(xpath="/html/body/div[1]/div/div[3]/table/tbody/tr/td[2]/form[3]/span/div/div/div/div/div[2]/table/tbody/tr[2]/td[1]")
	private WebElement commento2;
	
	@FindBy(xpath="/html/body/div[1]/div/div[3]/table/tbody/tr/td[2]/form[3]/span/div/div/div/div/div[2]/table/tbody/tr[3]/td[1]")
	private WebElement commento3;
	
	@FindBy(xpath="/html/body/div[1]/div/div[3]/table/tbody/tr/td[2]/form[3]/span/div/div/div/div/div[2]/table/tbody/tr[4]/td[1]")
	private WebElement commento4;
	
	@FindBy(xpath="/html/body/div[1]/div/div[3]/table/tbody/tr/td[2]/form[3]/span/div/div/div/div/div[2]/table/tbody/tr[5]")
	private WebElement commento5;
	

	//**METODI**//
	
	public String numeroCaso(){
		try {
			System.out.println(numeroCaso.getText());
			return numeroCaso.getText();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("id non presente perchè caso non creato correttamente");
		}
		return "";
	}
	
	public String servizio(){
		try {
			return servizio.getText();
		} catch (Exception e) {
			System.out.println("Campo 'servizio' non presente");
			return "";
		}
	}
	
	public String stato(){
		try {
			return stato.getText();
		} catch (Exception e) {
			System.out.println("Campo 'stato' non presente");
			return "";
		}
	}
	
	public String descrizione(){
		try {
			return descrizione.getText();
		} catch (Exception e) {
			System.out.println("Campo 'descrizione' non presente");
			return "";
		}
	}
	
	public String nomeReferente(){
		try {
			return nomeRef.getText();
		} catch (Exception e) {
			System.out.println("Campo 'nome referente' non presente");
			return "";
		}
	}
	
	public String cognomeReferente(){
		try {
			return cognomeRef.getText();
		} catch (Exception e) {
			System.out.println("Campo 'cognome referente' non presente");
			return "";
		}
	}
	
	public String commento1(){
		try {
			return commento1.getText();
		} catch (Exception e) {
			System.out.println("commento1 non presente");
			return "";
		}
	}
	
	public String commento2(){
		try {
			return commento2.getText();
		} catch (Exception e) {
			System.out.println("commento2 non presente");
			return "";
		}
	}
	
	public String commento3(){
		try {
			return commento3.getText();
		} catch (Exception e) {
			System.out.println("commento3 non presente");
			return "";
		}
	}
	
	public String commento4(){
		try {
			return commento4.getText();
		} catch (Exception e) {
			System.out.println("commento4 non presente");
			return "";
		}
	}
	
	public String commento5(){
		try {
			return commento5.getText();
		} catch (Exception e) {
			System.out.println("commento5 non presente");
			return "";
		}
	}
	

	
	
	
	
	
	
	
	
	
	
//	@FindBy(id="j_id0:j_id23:j_id39:j_id42:j_id43")
//	private WebElement numeroCasoID;
	
//	https://fastwebwholesale.force.com/5005700001qI7XQAA0    00118502
}
