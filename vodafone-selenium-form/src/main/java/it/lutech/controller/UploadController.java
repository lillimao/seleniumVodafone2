package it.lutech.controller;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import it.lutech.pages.CasoCreatoPage;
import it.lutech.pages.FormPage;
import it.lutech.pages.LoginPage;
import it.lutech.utils.DriverUtils;
import it.lutech.utils.ExcelUtils;
import it.lutech.utils.Utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.Set;

@Controller
public class UploadController {

    //Save the uploaded file to this folder
    private static String UPLOADED_FOLDER = "F://temp//"; //TODO
    
private WebDriver driver;
	
	private ExcelUtils excelUtils;
	
	private String servizioS;
	
	private String consistenzaS;
	
	private String sedeS;
	
	private String problemaS; 
	
	private String orarioReperibilitaS; 
	
	private String reperibilitaFestiviS; 
	
	private String idCircuitoS; 
	
	private String ticketClienteS; 
	
	private String commentoS; 
	
	private String nomeReferenteS; 
	
	private String cognomeReferenteS; 
	
	private String emailReferenteS; 
	
	private String telefonoReferenteS; 
	
	private String nomeReferente24S; 
	
	private String cognomeReferente24S; 
	
	private String emailReferente24S; 
	
	private String telefonoReferente24S; 
	
	private String scegliFileS; 


    @GetMapping("/upload")
    public String index() {
        return "upload";
    }

    @GetMapping("/uploadStatus")
    public String uploadStatus() {
        return "uploadStatus";
    }
    
    @PostMapping("/upload") // //new annotation since 4.3
    public String singleFileUpload(@RequestParam("file") MultipartFile file,
                                   RedirectAttributes redirectAttributes) {

        if (file.isEmpty()) {
            redirectAttributes.addFlashAttribute("message", "Selezionare un file, per favore");
            return "redirect:uploadStatus";
        }

        try {
        	
        	excelUtils = new ExcelUtils();
        	excelUtils.creaWorkbook(convert(file));
        	login();
        	casiMultipli();
        	
        	
//            // Get the file and save it somewhere
//            byte[] bytes = file.getBytes();
//            Path path = Paths.get(UPLOADED_FOLDER + file.getOriginalFilename());
//            Files.write(path, bytes);
//
//            redirectAttributes.addFlashAttribute("message",
//                    "You successfully uploaded '" + file.getOriginalFilename() + "'");

        } catch (IOException e) {
            e.printStackTrace();
        }
        redirectAttributes.addFlashAttribute("message", "Upload terminato");
        return "redirect:/uploadStatus";
    }
    
    public void login(){
		driver = DriverUtils.getDriver();
		DriverUtils.initializeFirefox();
		LoginPage lp = PageFactory.initElements(driver, LoginPage.class);
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		lp.compilaUserName();
		js.executeScript("document.getElementById('pw').setAttribute('value', 'Vodafone05');"); //compila password
		js.executeScript("document.getElementsByClassName('button small-button loginFormSubmit')[0].click();"); //click su "invia"
		
	}
    
    public void casiMultipli(){
		excelUtils = new ExcelUtils();
		driver = DriverUtils.getDriver();
		int numeroRighe = excelUtils.numeroRighe();
		for(int i = 0; i < numeroRighe; i++){
			servizioS = excelUtils.stampaCelle(i+2, 0);
			if(servizioS.equals("")){
				System.out.println("manca servizio");
			}
			consistenzaS = excelUtils.stampaCelle(i+2, 1);
			if(consistenzaS.equals("")){
				System.out.println("manca consistenza");
			}
			sedeS = excelUtils.stampaCelle(i+2, 2);
			if(sedeS.equals("")){
				System.out.println("manca sede");
			}
			problemaS = excelUtils.stampaCelle(i+2, 3);
			if(problemaS.equals("")){
				System.out.println("manca problema");
			}
			orarioReperibilitaS = excelUtils.stampaCelle(i+2, 4);
			if(orarioReperibilitaS.equals("")){
				System.out.println("manca orario reperibilita");
			}
			reperibilitaFestiviS = excelUtils.stampaCelle(i+2, 5);
			if(reperibilitaFestiviS.equals("")){
				System.out.println("manca reperibilita festivi");
			}
			idCircuitoS = excelUtils.stampaCelle(i+2, 6);
			if(idCircuitoS.equals("")){
				System.out.println("manca id circuito");
			}
			ticketClienteS = excelUtils.stampaCelle(i+2, 7);
			if(ticketClienteS.equals("")){
				System.out.println("manca ticket cliente");
			}
			commentoS = excelUtils.stampaCelle(i+2, 8);
			if(commentoS.equals("")){
				System.out.println("manca commento");
			}
			nomeReferenteS = excelUtils.stampaCelle(i+2, 9);
			if(nomeReferenteS.equals("")){
				System.out.println("manca nome referente 24");
			}
			cognomeReferenteS = excelUtils.stampaCelle(i+2, 10);
			if(cognomeReferenteS.equals("")){
				System.out.println("manca cognome ref24");
			}
			emailReferenteS = excelUtils.stampaCelle(i+2, 11);
			if(emailReferenteS.equals("")){
				System.out.println("manca email referente");
			}
			telefonoReferenteS = excelUtils.stampaCelle(i+2, 12);
			if(telefonoReferenteS.equals("")){
				System.out.println("manca telefono referente");
			}
			nomeReferente24S = excelUtils.stampaCelle(i+2, 13);
			if(nomeReferente24S.equals("")){
				System.out.println("manca nome referente 24");
			}
			cognomeReferente24S = excelUtils.stampaCelle(i+2, 14);
			if(cognomeReferente24S.equals("")){
				System.out.println("manca cpgnome referente24");
			}
			emailReferente24S = excelUtils.stampaCelle(i+2, 15);
			if(emailReferente24S.equals("")){
				System.out.println("manca email referente 24");
			}
			telefonoReferente24S = excelUtils.stampaCelle(i+2, 16);
			if(telefonoReferente24S.equals("")){
				System.out.println("manca telefono referente24");
			}
			scegliFileS = excelUtils.stampaCelle(i+2, 17);
			if(scegliFileS.equals("")){
				System.out.println("manca il file da caricare");
			}

//			creaCaso();
			
			excelUtils.scriviValore(creaCaso(), i+2, 18);
		}
		driver.quit();
	}

	public String creaCaso(){
		String numCaso;
		try {
			Thread.sleep(5000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		driver.get(Utils.readProperties("linkCreaCaso"));
		FormPage fp = PageFactory.initElements(driver, FormPage.class);
		CasoCreatoPage ccp = PageFactory.initElements(driver, CasoCreatoPage.class);
//		String servizio = fp.getServizioS(servizioS);
//		String orarioReperibilita = fp.getOrarioReperibilitaS();
//		String reperibilitàFestivi = fp.getReperibilitaFestiviS();
		
		switch (servizioS) {
/******/	case "Dark Fiber":
			fp.selezionaServizio(servizioS);
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			fp.selezionaProblema(problemaS);
			fp.selezionaOrarioReperibilità(orarioReperibilitaS);
			
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			fp.selezionaReperibilitaFestivi(reperibilitaFestiviS);
			fp.compilaIdCircuito(idCircuitoS);
			fp.compilaTicketCliente(ticketClienteS);
			fp.compilaCommento(commentoS);
			if(orarioReperibilitaS.equals("h24") | reperibilitaFestiviS.equals("Si")){
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				fp.compilaNomeReferente24(nomeReferente24S);
				fp.compilaCognomeReferente24(cognomeReferente24S);
				fp.compilaEmailReferente24(emailReferente24S);
				fp.compilaTelefonoReferente24(telefonoReferente24S);
			}
			else{
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				fp.compilaNomeReferente(nomeReferenteS);
				fp.compilaCognomeReferente(cognomeReferenteS);
				fp.compilaEmailReferente(emailReferenteS);
				fp.compilaTelefonoReferente(telefonoReferenteS);
			}
			fp.clickScegliFile(scegliFileS);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			fp.clickUploadFile();
//			fp.clickConfermaInserimento();  
			numCaso = ccp.numeroCaso();
			if(numCaso.equals("")){
				JavascriptExecutor js = (JavascriptExecutor)driver;	
				js.executeScript("alert('Il caso non è stato generato');");
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				driver.switchTo().alert().accept();//TODO togliere se si vuole che si blocchi dopo l'errore
				return "";
			}
			return numCaso;
/******/	case "DWDM":
			fp.selezionaServizio(servizioS);
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			fp.selezionaProblema(problemaS);
			fp.selezionaOrarioReperibilità(orarioReperibilitaS);
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			fp.selezionaReperibilitaFestivi(reperibilitaFestiviS);
			fp.compilaIdCircuito(idCircuitoS);
			fp.compilaTicketCliente(ticketClienteS);
			fp.compilaCommento(commentoS);
			if(orarioReperibilitaS.equals("h24") | reperibilitaFestiviS.equals("Si")){
				fp.compilaNomeReferente24(nomeReferente24S);
				fp.compilaCognomeReferente24(cognomeReferente24S);
				fp.compilaEmailReferente24(emailReferente24S);
				fp.compilaTelefonoReferente24(telefonoReferente24S);
			}
			else{
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				fp.compilaNomeReferente(nomeReferenteS);
				fp.compilaCognomeReferente(cognomeReferenteS);
				fp.compilaEmailReferente(emailReferenteS);
				fp.compilaTelefonoReferente(telefonoReferenteS);
			}
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			fp.uploadFile(scegliFileS);
//			fp.clickConfermaInserimento(); 
			numCaso = ccp.numeroCaso();
			if(numCaso.equals("")){
				JavascriptExecutor js = (JavascriptExecutor)driver;	
				js.executeScript("alert('Il caso non è stato generato');");
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				driver.switchTo().alert().accept();//TODO togliere se si vuole che si blocchi dopo l'errore
				return "";
			}
			return numCaso;
/******/	case "SDH/WDM - Punto Punto":
			fp.selezionaServizio(servizioS);
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			fp.scriviCosistenza(consistenzaS);
			
			String mainWindow = driver.getWindowHandle(); //per gestire il popup

			fp.cercaConsistenza();
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			Set<String>otherWindows = driver.getWindowHandles();//per gestire il popup
			Iterator<String> iterator = otherWindows.iterator();//per gestire il popup
			while(iterator.hasNext()){//per entrare nel popup
				String secondWindow = iterator.next();
				if(!mainWindow.equalsIgnoreCase(secondWindow)){//dentro il popup
					driver.switchTo().window(secondWindow);
					driver.findElement(By.xpath("/html/body/form/div[1]/div[2]/div[2]/div/div/div/div[1]/table/tbody/tr/td[1]/a")).click();
				}
			}
//			String reperibilita = fp.getOrarioReperibilitaS(reperibilitaFestiviS);
			driver.switchTo().window(mainWindow);//per tornare alla pagina principale
			
			fp.selezionaSede(sedeS);
			fp.selezionaProblema(problemaS);
			fp.selezionaOrarioReperibilità(orarioReperibilitaS);
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			fp.selezionaReperibilitaFestivi(reperibilitaFestiviS);
			fp.compilaIdCircuito(idCircuitoS);
			fp.compilaTicketCliente(ticketClienteS);
			fp.compilaCommento(commentoS);
			if(orarioReperibilitaS.equals("h24") | reperibilitaFestiviS.equals("Si")){
				fp.compilaNomeReferente24(nomeReferente24S);
				fp.compilaCognomeReferente24(cognomeReferente24S);
				fp.compilaEmailReferente24(emailReferente24S);
				fp.compilaTelefonoReferente24(telefonoReferente24S);
			}
			else{
				fp.compilaNomeReferente(nomeReferenteS);
				fp.compilaCognomeReferente(cognomeReferenteS);
				fp.compilaEmailReferente(emailReferenteS);
				fp.compilaTelefonoReferente(telefonoReferenteS);
			}
			fp.clickScegliFile(scegliFileS);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			fp.clickUploadFile();
//			fp.uploadFile(scegliFileS);
//			fp.clickConfermaInserimento();   
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			numCaso = ccp.numeroCaso();
			if(numCaso.equals("")){
				JavascriptExecutor js = (JavascriptExecutor)driver;	
				js.executeScript("alert('Il caso non è stato generato');");
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				driver.switchTo().alert().accept(); //TODO togliere se si vuole che si blocchi dopo l'errore
				return "";
			}
			return numCaso;
		}

		return "";
		
	}
    
    public static File convert(MultipartFile file) throws IOException {
        File convFile = new File(file.getOriginalFilename());
        convFile.createNewFile();
        FileOutputStream fos = new FileOutputStream(convFile);
        fos.write(file.getBytes());
        fos.close();
        return convFile;
    }

}