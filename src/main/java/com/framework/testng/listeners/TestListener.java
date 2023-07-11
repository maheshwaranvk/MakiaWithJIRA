package com.framework.testng.listeners;

import java.util.List;

import org.testng.ITestListener;
import org.testng.ITestResult;

import com.framework.restassured.api.base.RESTAssuredBase;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class TestListener implements ITestListener {
	
	@Override
	public void onTestFailure(ITestResult result) {
		
		String name = result.getName();
		int matchCount = 0;
		RestAssured.baseURI = "https://api-training.atlassian.net//rest/api/2/";
		RestAssured.authentication = RestAssured.preemptive().basic("hari.radhakrishnan@testleaf.com", "ATATT3xFfGF06CcT8B03yrfHsqrYINW55KO9WJXVN02P0bbJjNHAJkPh7SijgyiKECAxptgZIICQ67m67Um_WjUMDMm9wZjgP1MYcz3NY-w2upJJxoOcVjYAy4LGzy7OC43IMo95FHcSequHLk_kLZgDPfKRhmcYK7_SV0iyLggluuvbwTuE1tI=3EA7A1B8");
	
		Response response = RESTAssuredBase.getWithParameter("jql", "project=TM", "search");
		JsonPath jsonPath = response.jsonPath();
				
		List<String> allSummary = jsonPath.get("issues.fields.summary");
		for (String eachSummary : allSummary) {
			if(eachSummary.equalsIgnoreCase(name)) {
				matchCount++;
				break;
			}
		
		}
		
		if(matchCount==0) {
			RESTAssuredBase.postWithJsonAsBody("{\"fields\":{\"project\":{\"key\":\"TM\"},\"summary\": \""+name+"\",\"description\":\""+name+"\",\"issuetype\":{\"name\":\"Bug\"}}}", "issue");
		}else {
			System.out.println("Already bug is created");
		}
	
	}

}
