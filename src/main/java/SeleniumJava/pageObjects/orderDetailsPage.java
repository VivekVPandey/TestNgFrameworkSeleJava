package SeleniumJava.pageObjects;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import SeleniumJava.abstrackComponents.AbstractComponents;

public class orderDetailsPage extends AbstractComponents {


	WebDriver driver;
	public orderDetailsPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(css="tr td:nth-child(3)")
	List<WebElement> productNameList;
	
	public boolean verifyOrderDisplay(String productName) throws InterruptedException {
		System.out.println(productName);
		Thread.sleep(2000);
		Boolean match = productNameList.stream().anyMatch(orderDetail-> orderDetail.getText().equalsIgnoreCase(productName));
		System.out.println(match);

		return match;
	}
	
	
	}
