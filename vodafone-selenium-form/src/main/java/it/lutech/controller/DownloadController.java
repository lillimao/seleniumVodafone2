package it.lutech.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DownloadController {

    @GetMapping("/download")
    public void getStream(HttpServletResponse response) throws IOException {
    	response.setContentType("application/vnd.ms-excel");
    	response.setHeader("Content-Disposition", "attachment; filename=\"demo.xlsx\"");
    	InputStream inputStream = new FileInputStream(new File("/home/lisa/git/vodafoneSelenium/vodafone-selenium-form/excelVodafoneOutPut.xlsx"));
    	int nRead;
    	while((nRead = inputStream.read()) != -1){
    		response.getWriter().write(nRead);
    	}
    }
}