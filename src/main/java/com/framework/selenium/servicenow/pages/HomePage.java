package com.framework.selenium.servicenow.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import com.framework.testng.api.base.ProjectSpecificMethods;

import io.github.sukgu.Shadow;

public class HomePage extends ProjectSpecificMethods{
	public static Shadow shadow;
	public HomePage verifyHomePage() {
		shadow = new Shadow(getDriver());
		shadow.setImplicitWait(10);
		WebElement eleSearch = shadow.findElementByXPath("//span[@aria-label='Search']");
		verifyDisplayed(eleSearch);
		reportStep("HomePage is displayed", "pass");
		return this;
	}
	
	public HomePage searchNewIncident(String incident) {
		shadow = new Shadow(getDriver());
		shadow.setImplicitWait(20);
		shadow.findElementByXPath("//span[@aria-label='Search']").click();
		shadow.findElementByXPath("//input[contains(@placeholder,'Search')]").sendKeys(incident,Keys.ENTER);
		pause(5000);
		reportStep("New Incident is available", "pass");
		return this;
	}

}
