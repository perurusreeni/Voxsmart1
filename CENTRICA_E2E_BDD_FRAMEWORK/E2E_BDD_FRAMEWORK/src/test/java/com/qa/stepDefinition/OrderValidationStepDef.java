package com.qa.stepDefinition;

import com.qa.driver.DriverFactory;
import com.qa.pages.OrderValidationPage;

import io.cucumber.java.en.Then;

public class OrderValidationStepDef {
	private OrderValidationPage orderValidationPage = new OrderValidationPage(DriverFactory.getDriver());


	@Then("validate the order information and click on finish button")
	public void validate_the_order_information_and_click_on_finish_button() {
		orderValidationPage.OrderInfo();
	}

}
