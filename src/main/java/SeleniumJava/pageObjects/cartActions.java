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

public class cartActions extends AbstractComponents {

	WebDriver driver;
	public cartActions(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
		// TODO Auto-generated constructor stub
	}

	//driver.findElement(By.cssSelector("[routerlink*='cart']")).click();
	By results = By.cssSelector(".ta-results");

	@FindBy(css="[routerlink*='cart']")
	WebElement cartClick;
	
	@FindBy(css=".cartSection h3")
	List<WebElement> cartProducts;
	
	@FindBy(css=".totalRow button")
	WebElement checkoutButton;
	
	@FindBy(css="[placeholder='Select Country']")
	WebElement countryField;
	
	@FindBy(xpath="(//button[contains(@class,'ta-item')])[2]")
	WebElement countrySuggestion;
	
	@FindBy(xpath="//div[@class='actions']//a")
	WebElement payNow;
	
	@FindBy(css=".hero-primary")
	WebElement heroText;
	
	public void clickCart() {
		
		cartClick.click();
	}
	
	public boolean cartProductMatch(String productName) throws InterruptedException {
		System.out.println(productName);
		Thread.sleep(2000);
		Boolean match = cartProducts.stream().anyMatch(cartProduct-> cartProduct.getText().equalsIgnoreCase(productName));
		System.out.println(match);

		return match;
	}
	
	public void addCountry() {
		
		//driver.findElement(By.cssSelector(".totalRow button")).click();
		checkoutButton.click();
		Actions a = new Actions(driver);
		a.sendKeys(countryField, "india").build().perform();
		waitForElementToAppear(results);
		countrySuggestion.click();
		
	}
	
	public String placeOrder() throws InterruptedException {
		
		Thread.sleep(2000);
//		a.sendKeys(Keys.PAGE_DOWN).build().perform();
//		a.sendKeys(Keys.PAGE_DOWN).build().perform();
		payNow.click();
		Thread.sleep(3000);
		String confirmMessage = heroText.getText();
		return confirmMessage;

	}

}
