package it.lutech.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CasoCreatoPage {
	
	//** ELEMENTI **//
	
//	@FindBy(className="pageDescription")
//	private WebElement numeroCaso;
	
	@FindBy(id="j_id0:j_id23:j_id39:j_id42:j_id43")
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
	
	@FindBy(id="j_id0:j_id23:j_id39:j_id74:j_id75")
	private WebElement cognomeRef;
	
	@FindBy(id="j_id0:j_id23:j_id39:j_id74:j_id77")
	private WebElement nomeRef;
	
	@FindBy(id="j_id0:j_id23:j_id39:j_id74:j_id76")
	private WebElement emailRef;
	
	@FindBy(id="j_id0:j_id23:j_id39:j_id74:j_id78")
	private WebElement telRef;
	
	@FindBy(xpath="/html/body/div[1]/div/div[3]/table/tbody/tr/td[2]/form[3]/span/div/div/div/div/div[2]/table/tbody/tr[1]")
	private WebElement commento1;
	
	@FindBy(xpath="/html/body/div[1]/div/div[3]/table/tbody/tr/td[2]/form[3]/span/div/div/div/div/div[2]/table/tbody/tr[2]")
	private WebElement commento2;
	
	@FindBy(xpath="/html/body/div[1]/div/div[3]/table/tbody/tr/td[2]/form[3]/span/div/div/div/div/div[2]/table/tbody/tr[3]")
	private WebElement commento3;
	
	@FindBy(xpath="/html/body/div[1]/div/div[3]/table/tbody/tr/td[2]/form[3]/span/div/div/div/div/div[2]/table/tbody/tr[4]")
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
	
	
	
	
	
	
	
	
	
	
//	@FindBy(id="j_id0:j_id23:j_id39:j_id42:j_id43")
//	private WebElement numeroCasoID;
	
//	https://fastwebwholesale.force.com/5005700001qI7XQAA0    00118502
}
