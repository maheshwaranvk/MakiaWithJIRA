package com.servicenow.testcases;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.framework.selenium.servicenow.pages.LoginPage;
import com.framework.testng.api.base.ProjectSpecificMethods;

public class TC001_VerifyLogin extends ProjectSpecificMethods{
	
	@BeforeTest
	public void setValues() {
		testcaseName = "VerifyLogin";
		testDescription ="Verify Login functionality with positive data";
		authors="Hari";
		category ="Smoke";
		excelFileName="Login";
	}
	
	@Test(dataProvider = "fetchData")
	public void loginWithPositiveData(String username, String password) {
		new LoginPage()
		.typeUsername(username)
		.typePassword(password)
		.clickLogIn()
		.verifyHomePage();
		
	}

}
