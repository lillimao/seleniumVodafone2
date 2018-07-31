package it.lutech.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import it.lutech.utils.AppProperties;

@Controller
public class DownloadController {
	
	private AppProperties app;
	
	@Autowired
	public void setApp(AppProperties app) {
		this.app = app;
	}

    @GetMapping("/download")
    public void getStream(HttpServletResponse response) throws IOException {
    	response.setContentType("application/vnd.ms-excel");
    	response.setHeader("Content-Disposition", "attachment; filename=\"demo.xlsx\"");
    	String path = app.getFileDownloadDir();
    	InputStream inputStream = new FileInputStream(new File(path+"excelVodafoneOutPut.xlsx"));
    	int nRead;
    	while((nRead = inputStream.read()) != -1){
    		response.getWriter().write(nRead);
    	}
    }
}