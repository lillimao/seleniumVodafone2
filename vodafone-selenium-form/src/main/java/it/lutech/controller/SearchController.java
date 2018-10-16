package it.lutech.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import it.lutech.pages.CasoCreatoPage;
import it.lutech.pages.HomePage;
import it.lutech.pages.LoginPage;
import it.lutech.utils.AppProperties;
import it.lutech.utils.DriverUtils;
import it.lutech.utils.ExcelUtils;

@Controller
public class SearchController {
	
	private WebDriver driver;
	
	private CasoCreatoPage ccp;
	
	private AppProperties app;
	
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
	
	private Map<String, Map<String, String>> hmapAll = new HashMap<String, Map<String, String>>();
	
	@Autowired
	public void setApp(AppProperties app) {
		this.app = app;
	}		

    @GetMapping("/search")
    public String index() {
        return "search";
    }

    @GetMapping("/viewCreatedCases")
    public String viewCreatedCases(Model modelGet, RedirectAttributes redirectAttributes) throws FileNotFoundException {
    	String path = app.getFileDownloadDir();
    	File file = new File(path+"excelVodafoneOutPut.xlsx");
		excelUtils = new ExcelUtils();
		excelUtils.creaWorkbook(file);
		hmapAll = new HashMap<String, Map<String, String>>();
		
		login();
		for(int i = 0; i < excelUtils.numeroRighe(); i++){
			String caso = excelUtils.stampaCelle(i+2, 18);
			if(caso != null && !caso.isEmpty()){
			cercaCaso(caso);
			ccp = PageFactory.initElements(driver, CasoCreatoPage.class);
			Map<String, String> hmapSingle = new HashMap<String, String>();
			if(ccp.numeroCaso().equals("")){
	    		redirectAttributes.addFlashAttribute("message", "Numero caso non trovato");
	    		return "redirect:uploadStatus";
	    	}
			
			hmapSingle = new HashMap<String, String>(); 
//			hmapSingle.put("problemaS", ccp.);
//			hmapSingle.put("orarioReperibilitaS", );
//			hmapSingle.put("reperibilitaFestiviS", );
//			hmapSingle.put("idCircuitoS", );
//			hmapSingle.put("ticketClienteS", );
			hmapSingle.put("commentoS", commentoS);
			hmapSingle.put("servizioS", ccp.servizio());
			hmapSingle.put("statoS", ccp.stato());
			hmapSingle.put("descrizioneS", ccp.descrizione());
			hmapSingle.put("nomeReferente24S", ccp.nomeReferente());
			hmapSingle.put("cognomeReferente24S", ccp.cognomeReferente());
//			hmapSingle.put("emailReferente24S", emailReferente24S);
//			hmapSingle.put("telefonoReferente24S", telefonoReferente24S);
//			hmapSingle.put("nomeReferenteS", nomeReferenteS);
//			hmapSingle.put("cognomeReferenteS", cognomeReferenteS);
//			hmapSingle.put("emailReferenteS", emailReferenteS);
//			hmapSingle.put("telefonoReferenteS", telefonoReferenteS);
//			hmapSingle.put("scegliFileS", scegliFileS);
			hmapSingle.put("numCaso", ccp.numeroCaso());
	    	hmapAll.put(ccp.numeroCaso(), hmapSingle);
			}
		}
		modelGet.addAttribute("hmapAll", hmapAll);
    	return "createdCases";
    }
    
    @PostMapping("/search")
    public String caseIdSearch(@RequestParam("caseId") String caseId, RedirectAttributes redirectAttributes, Model model){
    	if(caseId == null | caseId.equals("")){
    		redirectAttributes.addFlashAttribute("message", "Per favore inserire un id valido");
    		return "redirect:uploadStatus"; //TODO
    	}
    	login();
    	System.out.println("Login End");
    	cercaCaso(caseId);
    	ccp = PageFactory.initElements(driver, CasoCreatoPage.class);
    	if(ccp.numeroCaso().equals("")){
    		redirectAttributes.addFlashAttribute("message", "Numero caso non trovato");
    		return "redirect:uploadStatus";
    	}
    	model.addAttribute("numeroCaso", ccp.numeroCaso());
    	model.addAttribute("servizio", ccp.servizio());
    	model.addAttribute("stato", ccp.stato());
    	model.addAttribute("descrizione", ccp.descrizione());
    	model.addAttribute("nomeRef", ccp.nomeReferente());
    	model.addAttribute("cognomeRef", ccp.cognomeReferente());
    	model.addAttribute("commento1", ccp.commento1());
    	model.addAttribute("commento2", ccp.commento2());
    	model.addAttribute("commento3", ccp.commento3());
    	model.addAttribute("commento4", ccp.commento4());
    	model.addAttribute("commento5", ccp.commento5());
    	return "createdCase";
    }
    
    public void login(){
		try {
			driver = DriverUtils.getDriver();
			DriverUtils.initializeFirefox();
			LoginPage lp = PageFactory.initElements(driver, LoginPage.class);
			
			JavascriptExecutor js = (JavascriptExecutor) driver;
			lp.compilaUserName(app.getUsername());
			js.executeScript("document.getElementById('pw').setAttribute('value', 'Vodafone06');"); //compila password
			js.executeScript("document.getElementsByClassName('button small-button loginFormSubmit')[0].click();"); //click su "invia"
		} catch (Exception e) {
			System.out.println("Chiusura inaspettata del browser"); //TODO
			e.printStackTrace();
			driver = DriverUtils.getDriver();
		}
		
	}
    
    public void cercaCaso(String caseId){
		try {
			driver = DriverUtils.getDriver();
			try {
				Thread.sleep(5000);
			} catch (Exception e) {
				e.printStackTrace();
			}
			driver.get(app.getLinkHomePage()); //va direttamente alla homepage
			HomePage hm = PageFactory.initElements(driver, HomePage.class);
			hm.setIdCaso(caseId);
			hm.compilaCerca();
			hm.clickVai();
		} catch (Exception e) {
			System.out.println("Chiusura inaspettata del browser");
			driver = DriverUtils.getDriver();
		}
	}
    
//    @PostMapping("/upload") // //new annotation since 4.3
//    public String singleFileUpload(@RequestParam("file") MultipartFile file,
//                                   RedirectAttributes redirectAttributes) {
//
//        if (file.isEmpty()) {
//            redirectAttributes.addFlashAttribute("message", "Please select a file to upload");
//            return "redirect:uploadStatus";
//        }
//
//        try {
//
//            // Get the file and save it somewhere
//            byte[] bytes = file.getBytes();
//            Path path = Paths.get(UPLOADED_FOLDER + file.getOriginalFilename());
//            Files.write(path, bytes);
//
//            redirectAttributes.addFlashAttribute("message",
//                    "You successfully uploaded '" + file.getOriginalFilename() + "'");
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        return "redirect:/uploadStatus";
//    }

//    @GetMapping("/uploadStatus")
//    public String uploadStatus() {
//        return "uploadStatus";
//    }

}