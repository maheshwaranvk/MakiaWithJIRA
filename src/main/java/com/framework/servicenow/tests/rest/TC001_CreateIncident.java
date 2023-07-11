package com.framework.servicenow.tests.rest;

import java.io.File;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.framework.restassured.api.base.RESTAssuredBase;

import io.restassured.http.ContentType;
import io.restassured.response.Response;


public class TC001_CreateIncident extends RESTAssuredBase{
	
	@BeforeTest//Reporting
	public void setValues() {
		testcaseName = "Create Incident";
		testDescription = "Create Incident using REST API";
		authors = "Hari";
		category = "REST";
		//dataProvider
		dataFileName = "TC001";
	    dataFileType = "JSON";
	}

	@Test(dataProvider = "fetchData")
	public void createIncident(File file) {		
				
		Response response = postWithBodyAsFileAndUrl(file, "incident");
		response.prettyPrint();
		
		  verifyContentType(response, "application/json");
		  verifyResponseCode(response, 201); 
		  verifyContentWithKey(response,"result.short_description",
		  "This is Rest Assured Automation framework - Makaia");
		  sysID= extractResponseContent(response, "result.sys_id");
		  System.out.println(sysID);
		 
		
	}


}




















