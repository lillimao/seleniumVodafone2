package it.lutech.utils;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:application.properties")
@ConfigurationProperties
public class AppProperties {

	private String fileUploadDir;
	private String fileDownloadDir;
	private String linkHomePage;
	private String linkListaCasi;
	private String linkCreaCaso;
	private String username;
	private String password;
	

	public String getFileUploadDir() {
		return fileUploadDir;
	}

	public void setFileUploadDir(String fileUploadDir) {
		this.fileUploadDir = fileUploadDir;
	}

	public String getFileDownloadDir() {
		return fileDownloadDir;
	}

	public void setFileDownloadDir(String fileDownloadDir) {
		this.fileDownloadDir = fileDownloadDir;
	}

	public String getLinkHomePage() {
		return linkHomePage;
	}

	public void setLinkHomePage(String linkHomePage) {
		this.linkHomePage = linkHomePage;
	}

	public String getLinkListaCasi() {
		return linkListaCasi;
	}

	public void setLinkListaCasi(String linkListaCasi) {
		this.linkListaCasi = linkListaCasi;
	}

	public String getLinkCreaCaso() {
		return linkCreaCaso;
	}

	public void setLinkCreaCaso(String linkCreaCaso) {
		this.linkCreaCaso = linkCreaCaso;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
}
