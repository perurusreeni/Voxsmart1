package com.qa.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class OrderValidationPage {
	
	private WebDriver driver;

	private By paymentInfo = By.xpath("(//div[@class='summary_value_label'])[1]");
	
	private By shippingInfo = By.xpath("(//div[@class='summary_value_label'])[2]");
	private By totalItems = By.xpath("//div[@class='summary_subtotal_label']");
	private By taxDetails = By.xpath("//div[@class='summary_tax_label']");
	private By totalAmnt = By.xpath("//div[@class='summary_total_label']");
	private By finishBtn = By.xpath("//button[@id='finish']");
	
	public OrderValidationPage(WebDriver driver) {

		this.driver = driver;

		PageFactory.initElements(driver, this);

	}
	
	public OrderValidationPage OrderInfo() {
		driver.findElement(paymentInfo).getText();
		driver.findElement(shippingInfo).getText();
		driver.findElement(totalItems).getText();
		driver.findElement(taxDetails).getText();
		driver.findElement(totalAmnt).getText();
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(5000));
		driver.findElement(finishBtn).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));
		return new OrderValidationPage(driver);
	}

}
