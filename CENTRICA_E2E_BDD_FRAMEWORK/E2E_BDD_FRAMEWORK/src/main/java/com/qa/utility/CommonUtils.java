package com.qa.utility;

import java.time.Duration;
import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;



public class CommonUtils {
	
	protected WebDriver driver;
	private WebDriverWait wait;
	
	public CommonUtils(WebDriver driver) {
	
	
	this.driver = driver;
    wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    PageFactory.initElements(new AjaxElementLocatorFactory(driver, 10), this);
}

protected void waitForElementToAppear(By locator) {
    wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
}

protected void waitForElementToDisappear(By locator) {
    wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
}

protected void implicitWait(int time) {
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(time));
}

protected void waitForTextToDisappear(By locator, String text) {
    wait.until(ExpectedConditions.not(ExpectedConditions.textToBe(locator, text)));
}

public void SelectUsingVisibleValue(By locator,String visibleValue) {
	SelectUsingVisibleValue(getElement(locator),visibleValue);
}

public void SelectUsingVisibleValue(WebElement element,String visibleValue) {
	Select select = new Select(element);
	select.selectByVisibleText(visibleValue);
	
}

public void SelectUsingValue(By locator,String value) {
	Select select = new Select(getElement(locator));
	select.selectByValue(value);
	
}

public void SelectUsingIndex(By locator,int index) {
	Select select = new Select(getElement(locator));
	select.selectByIndex(index);
	
}

public void SelectUsingText(By locator,String text) {
	Select select = new Select(getElement(locator));
	select.selectByVisibleText(text);
	
}

public String getSelectedValue(By locator) {
	
	return getSelectedValue(getElement(locator));
}

public String getSelectedValue(WebElement element) {
	String value = new Select(element).getFirstSelectedOption().getText();
	
	return value;
}




public List<String> getAllDropDownValues(By locator) {
	Select select = new Select(getElement(locator));
	List<WebElement> elementList = select.getOptions();
	List<String> valueList = new LinkedList<String>();
	
	for (WebElement element : elementList) {
		
		valueList.add(element.getText());
	}
	return valueList;
}

public boolean IsElementPresentQuick(By locator) {
	boolean flag = driver.findElements(locator).size() >= 1;
	
	return flag;
}

public WebElement getElement(By locator) {
	
	if (IsElementPresentQuick(locator))
		return driver.findElement(locator);
	
	try {
		throw new NoSuchElementException("Element Not Found : " + locator);
	} catch (RuntimeException re) {
		
		throw re;
	}
}

public void sendKeys(By locator,String value) {
	
	getElement(locator).sendKeys(value);
}

public void click(WebElement element){
	element.click();
	
}

}
