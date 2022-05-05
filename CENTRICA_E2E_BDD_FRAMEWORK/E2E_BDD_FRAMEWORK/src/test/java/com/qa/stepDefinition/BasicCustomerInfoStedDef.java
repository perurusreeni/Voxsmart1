package com.qa.stepDefinition;

import com.qa.driver.DriverFactory;
import com.qa.pages.BasicCustomerInfoPage;
import com.qa.pages.ShoppingPage;

import io.cucumber.java.en.Then;

public class BasicCustomerInfoStedDef {
	private BasicCustomerInfoPage basicCustomerInfoPage = new BasicCustomerInfoPage(DriverFactory.getDriver());


	@Then("the user enters the basic details and click continue")
	public void the_user_enters_the_basic_details_and_click_continue() {
		basicCustomerInfoPage.BaseInfoUpdate();
	}

}
