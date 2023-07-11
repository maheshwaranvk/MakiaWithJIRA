package com.framework.testng.api.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;

import com.framework.selenium.api.base.SeleniumBase;
import com.framework.utils.DataLibrary;

import io.restassured.RestAssured;

public class ProjectSpecificMethods extends SeleniumBase {

	
	
	@DataProvider(name = "fetchData", indices = 0)
	public Object[][] fetchData() throws IOException {
		return DataLibrary.getSheet(excelFileName);
	}

	@BeforeMethod
	public void preCondition() throws FileNotFoundException, IOException {
		
		startApp("chrome", false, "https://dev128088.service-now.com");
		setNode();
		
		Properties prop = new Properties();
		prop.load(new FileInputStream(new File("./src/main/resources/config.properties")));
		
		RestAssured.authentication = RestAssured.basic(prop.getProperty("username"),prop.getProperty("password"));
		RestAssured.baseURI = "https://"+prop.getProperty("server")+"/"+prop.getProperty("resources")+"/";
	}

	@AfterMethod
	public void postCondition() {
		close();

	}

}
