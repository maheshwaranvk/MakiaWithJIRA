package com.servicenow.testcases;

import java.io.File;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.framework.restassured.api.base.RESTAssuredBase;
import com.framework.selenium.servicenow.pages.LoginPage;
import com.framework.testng.api.base.ProjectSpecificMethods;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class TC002_VerifyNewIncident extends ProjectSpecificMethods{
	
	@BeforeTest
	public void setValues() {
		testcaseName = "Verify New Incident";
		testDescription ="Create using API and Verify through UI";
		authors="Hari";
		category ="Smoke";
		excelFileName="Login";
	}
	
	@Test(dataProvider = "fetchData")
	public void runLogin(String username, String password) {
		
		File file = new File("./data/TC001.json");
		Response response = RESTAssuredBase.postWithBodyAsFileAndUrl(file, "incident");
		//response.prettyPrint();
		JsonPath jsonPath = response.jsonPath();
		RESTAssuredBase.verifyResponseCode(response, 201);
		String incidentNumber = jsonPath.get("result.number");
		
		
		
		new LoginPage()
		.typeUsername(username)
		.typePassword(password)
		.clickLogIn()
		.searchNewIncident(incidentNumber);
		
	}

}
