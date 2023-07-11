package com.framework.selenium.servicenow.pages;

import com.framework.selenium.api.design.Locators;
import com.framework.testng.api.base.ProjectSpecificMethods;

public class LoginPage extends ProjectSpecificMethods{
	
	
	public LoginPage typeUsername(String username) {
		type(locateElement(Locators.ID,"user_name123"), username);
		reportStep(username+" Username is entered successfully", "pass");
		return this;
	}

	
	public LoginPage typePassword(String password) {
		type(locateElement(Locators.ID,"user_password"), password);
		reportStep(password+" Password is entered successfully", "pass");
		return this;
	}	
	

	public HomePage clickLogIn() {
		click(locateElement(Locators.ID,"sysverb_login"));
		reportStep("Login button is clicked", "pass");
		return new HomePage();		
	}

}
