package com.qa.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BackToShoppingPage {
	
	private WebDriver driver;

	private By backToHome = By.xpath("//button[@name='back-to-products']");
	
	public BackToShoppingPage(WebDriver driver) {

		this.driver = driver;

		PageFactory.initElements(driver, this);

	}
	
	public BackToShoppingPage BackHome() {
		driver.findElement(backToHome).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(100));
		driver.quit();
		return new BackToShoppingPage(driver);
	}

}
