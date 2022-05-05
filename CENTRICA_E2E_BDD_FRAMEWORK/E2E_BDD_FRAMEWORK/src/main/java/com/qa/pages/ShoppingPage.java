package com.qa.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ShoppingPage {

	private WebDriver driver;

	private By clickpricingdropdown = By.xpath("//select [@class='product_sort_container']");
	private By clickaddToCart = By.xpath("(//button[contains(text(),'Add to cart')])[1]");
	private By checkOutBucket = By.xpath("//a[@class='shopping_cart_link']");
	private By checkoutButton = By.xpath("//button[@id='checkout']");
	
	public ShoppingPage(WebDriver driver) {

		this.driver = driver;

		PageFactory.initElements(driver, this);

	}

	public void pricingDroplist() {

		Select pricingdropdown = new Select(driver.findElement(clickpricingdropdown));
		pricingdropdown.selectByVisibleText("Price (low to high)");
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));
		
	}

	public void addToKart() {
		WebDriverWait wt=new WebDriverWait(driver, Duration.ofSeconds(20));
		wt.until(ExpectedConditions.visibilityOfElementLocated(clickaddToCart));	
		driver.findElement(clickaddToCart).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));

	}

	public void checkOutBucketClick()
	{
		driver.findElement(checkOutBucket).click();
	}
	
	public void checkOutButtonClick() {
		driver.findElement(checkoutButton).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));
	}
	public ShoppingPage AddProduct() {
		pricingDroplist();
		addToKart();
		return new ShoppingPage(driver);
	}
	
	

}
