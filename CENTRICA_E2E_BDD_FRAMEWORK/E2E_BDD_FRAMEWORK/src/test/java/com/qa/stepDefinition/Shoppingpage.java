package com.qa.stepDefinition;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Shoppingpage {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.saucedemo.com/");
		driver.manage().window().maximize();
		driver.findElement(By.id("user-name")).sendKeys("standard_user");
		driver.findElement(By.id("password")).sendKeys("secret_sauce");
		driver.findElement(By.id("login-button")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(100));
		String actualTitle = driver.getTitle();
		System.out.println("The title of the webpage:" + actualTitle);
		String expectedTitle = "Swag Labs";
		if (actualTitle.equalsIgnoreCase(expectedTitle))
			System.out.println("Title Matched");
		else
			System.out.println("Title didn't match");
		Select pricingdropdown=new Select(driver.findElement(By.xpath("//select [@class='product_sort_container']")));
        pricingdropdown.selectByVisibleText("Price (low to high)");
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(100));
        driver.findElement(By.xpath("(//button[contains(text(),'Add to cart')])[1]")).click();
        driver.findElement(By.xpath("//a[@class='shopping_cart_link']")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(100));
        driver.findElement(By.xpath("//button[@id='checkout']")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(50));
        driver.findElement(By.xpath("//input[@id='first-name']")).sendKeys("userOne");
        driver.findElement(By.xpath("//input[@id='last-name']")).sendKeys("lastOne");
        driver.findElement(By.xpath("//input[@id='postal-code']")).sendKeys("345688");
        driver.findElement(By.xpath("//input[@id='continue']")).click();
        String paymentInformation=driver.findElement(By.xpath("(//div[@class='summary_value_label'])[1]")).getText();
        System.out.println("Payment Information : "+paymentInformation);
        String shippingInformation=driver.findElement(By.xpath("(//div[@class='summary_value_label'])[2]")).getText();
        System.out.println("Shipping Information : " +shippingInformation);
        String itemTotal=driver.findElement(By.xpath("//div[@class='summary_subtotal_label']")).getText();
        System.out.println("Item Total : " +itemTotal);
        String tax=driver.findElement(By.xpath("//div[@class='summary_tax_label']")).getText();
        System.out.println("Tax : " +tax);
        String total=driver.findElement(By.xpath("//div[@class='summary_total_label']")).getText();
        System.out.println("Total : " +total);
        driver.findElement(By.xpath("//button[@id='finish']")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(50));
        driver.findElement(By.xpath("//button[@name='back-to-products']")).click();
        driver.quit();
     
        
	}

	
}
