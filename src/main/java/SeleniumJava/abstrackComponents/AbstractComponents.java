package SeleniumJava.abstrackComponents;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.ExtentReports;


import SeleniumJava.pageObjects.orderDetailsPage;

public class AbstractComponents {

	//this will be parent class for all the class in pageObject package
	//all the commonly used methods variables etc will be reusable
	// methods like switch frame window alert handling waits
	
	//This is commonly used wait for visibilityOfElementLocated piece of code, will make it generic and reusable
	WebDriver driver;
	public AbstractComponents(WebDriver driver) {
		this.driver=driver;
	}

	@FindBy (xpath="//button[@routerlink='/dashboard/myorders']")
	WebElement orderHeader;
	
	
	public void waitForElementToAppear(By findBy) {
	WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5)); //Here the driver is not having knowledge of webdriver, we passed it from child class using super and caught it in constructor of this class and passed it on to the local variable 
	wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));
	}
	
	public void waitForElementToAppear(WebElement element) {
	WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5)); //Here the driver is not having knowledge of webdriver, we passed it from child class using super and caught it in constructor of this class and passed it on to the local variable 
	wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public void waitForElementDisappear(By findBy) {
	WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5)); //Here the driver is not having knowledge of webdriver, we passed it from child class using super and caught it in constructor of this class and passed it on to the local variable 
	wait.until(ExpectedConditions.invisibilityOfElementLocated(findBy));
	}
	
	public orderDetailsPage clickOrders() throws InterruptedException {
		Thread.sleep(2000);
		orderHeader.click();
		orderDetailsPage orderPage= new orderDetailsPage(driver);
		return orderPage;
	}
	

	
}
