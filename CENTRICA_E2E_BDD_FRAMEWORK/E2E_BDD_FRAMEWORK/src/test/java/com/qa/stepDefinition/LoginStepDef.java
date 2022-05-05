package com.qa.stepDefinition;

import java.time.Duration;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import com.qa.driver.DriverFactory;
import com.qa.pages.LoginPage;
import com.qa.utility.ConfigReader;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginStepDef {
	
private LoginPage loginPage = new LoginPage(DriverFactory.getDriver());

	
	@Given("user launch the url")
	public void user_launch_the_url() {
		System.out.println("Launched URL success by reading the config data");
	}

	@Then("enter the invalid credential and click submit")
	public void enter_the_invalid_credential_and_click_submit(DataTable credTable) {

		List<Map<String, String>> credList = credTable.asMaps();
		String userName = credList.get(0).get("username");
		String password = credList.get(0).get("password");		
		loginPage.doLogin(userName, password);
	    loginPage.invalidCredentialMessageValidation();
		
	}

	
	@When("the user entered valid {string} and {string}")
	public void the_user_entered_valid_and(String userName, String password) {
		DriverFactory.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		loginPage.doLogin(userName, password);
	 
	}

	@Then("page title should be {string}")
	public void page_title_should_be(String string) {
		String actualTitle=loginPage.getLoginPageTitle();
		System.out.println("The acutal tile of the webpage:" +actualTitle);
		String expectedTitle ="Swag Labs";
		if (actualTitle.equalsIgnoreCase(expectedTitle))
			System.out.println("Actual Title Matched with Expected Title");
		else
			System.out.println("Actual Title didn't Matched with Expected Title");
		
	}


}
