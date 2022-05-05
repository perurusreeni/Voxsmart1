package com.qa.stepDefinition;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.driver.DriverFactory;
import com.qa.pages.LoginPage;
import com.qa.pages.ShoppingPage;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ShoppingStepDef {

	private ShoppingPage shoppingPage = new ShoppingPage(DriverFactory.getDriver());

	@When("the user sort the pricing as low to high and add the lowest priced product in the cart")
	public void the_user_sort_the_pricing_as_low_to_high_and_add_the_lowest_priced_product_in_the_cart() {
		shoppingPage.AddProduct();
	}

	@Then("click the cart and proceed checkout")
	public void click_the_cart_and_proceed_checkout() {
		shoppingPage.checkOutBucketClick();
		shoppingPage.checkOutButtonClick();
	}

}
