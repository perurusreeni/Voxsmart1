package com.qa.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BasicCustomerInfoPage {

	private WebDriver driver;

	private By customerFirstName = By.xpath("//input[@id='first-name']");
	private By customerLastName = By.xpath("//input[@id='last-name']");
	private By customerPostalCode = By.xpath("//input[@id='postal-code']");
	private By continueButton = By.xpath("//input[@id='continue']");

	public BasicCustomerInfoPage(WebDriver driver) {

		this.driver = driver;

		PageFactory.initElements(driver, this);

	}

	public BasicCustomerInfoPage BaseInfoUpdate() {
		driver.findElement(customerFirstName).sendKeys("Albert");
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(100));
		driver.findElement(customerLastName).sendKeys("Alex");
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(100));
		driver.findElement(customerPostalCode).sendKeys("456774");
		driver.findElement(continueButton).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));
		return new BasicCustomerInfoPage(driver);
	}

}
