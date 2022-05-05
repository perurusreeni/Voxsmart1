package com.qa.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.driver.DriverFactory;

public class LoginPage {

	private WebDriver driver;

	private By userName = By.id("user-name");
	private By password = By.id("password");
	private By loginButton = By.id("login-button");

	// 2. Constructor of the page class:
	public LoginPage(WebDriver driver) {

		this.driver = driver;

		PageFactory.initElements(driver, this);

	}

	// 3. page actions: features(behavior) of the page the form of methods:

	public String getLoginPageTitle() {
		return driver.getTitle();
	}

	public LoginPage doLogin(String un, String pwd) {
		System.out.println("login with: " + un + " and " + pwd);
		driver.findElement(userName).sendKeys(un);
		driver.findElement(password).sendKeys(pwd);
		driver.findElement(loginButton).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));
		return new LoginPage(driver);
	}

	public void invalidCredentialMessageValidation()
	{
		
		String actualErrorMessage= driver.findElement(By.xpath("//h3[contains(text(),'Epic sadface: ')]")).getText();
		String expectedErrorMessage ="Epic sadface: Username and password do not match any user in this service";
		if (actualErrorMessage.equalsIgnoreCase(expectedErrorMessage))
			System.out.println("Title Matched");
		else
			System.out.println("Title didn't match");
	}
}
