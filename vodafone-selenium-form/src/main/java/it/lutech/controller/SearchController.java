package it.lutech.controller;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import it.lutech.pages.HomePage;
import it.lutech.pages.LoginPage;
import it.lutech.utils.DriverUtils;
import it.lutech.utils.Utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Controller
public class SearchController {
	
	private WebDriver driver;

    @GetMapping("/search")
    public String index() {
        return "search";
    }
    
    @PostMapping("/search")
    public String caseIdSearch(@RequestParam("caseId") String caseId, RedirectAttributes redirectAttributes, Model model){
    	if(caseId == null | caseId.equals("")){
    		redirectAttributes.addFlashAttribute("message", "Per favore inserire un id valido");
    		return "redirect:uploadStatus"; //TODO
    	}
    	login();
    	cercaCaso(caseId);
    	model.addAttribute("prova", "ciao");
    	return "/createdCase";
    }
    
    public void login(){
		try {
			driver = DriverUtils.getDriver();
			DriverUtils.initializeFirefox();
			LoginPage lp = PageFactory.initElements(driver, LoginPage.class);
			
			JavascriptExecutor js = (JavascriptExecutor) driver;
			lp.compilaUserName();
			js.executeScript("document.getElementById('pw').setAttribute('value', 'Vodafone05');"); //compila password
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
			driver.get(Utils.readProperties("linkHomePage")); //va direttamente alla homepage
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