package com.qa.stepDefinition;

import com.qa.driver.DriverFactory;
import com.qa.pages.BackToShoppingPage;
import com.qa.pages.OrderValidationPage;

import io.cucumber.java.en.Then;

public class BackToShoppingStepDef {
	
	private BackToShoppingPage backToShoppingPage = new BackToShoppingPage(DriverFactory.getDriver());
	
	@Then("the user will be redirect to a page and finally quit")
	public void the_user_will_be_redirect_to_a_page_and_finally_quit() {
		backToShoppingPage.BackHome();
	}

}
