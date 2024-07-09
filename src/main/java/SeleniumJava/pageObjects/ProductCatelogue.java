package SeleniumJava.pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import SeleniumJava.abstrackComponents.AbstractComponents;

public class ProductCatelogue extends AbstractComponents {

	WebDriver driver;
	public ProductCatelogue (WebDriver driver) {
		// TODO Auto-generated constructor stub
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this); // how will @FindBy has knowledge of driver, its through init declared here
	}
	
	//List<WebElement> products = driver.findElements(By.cssSelector(".mb-3"));

	By productsBy=By.cssSelector(".mb-3");
	By addToCart=By.cssSelector(".card-body button:last-of-type");
	By toasterMsg=By.cssSelector("#toast-container");
	By animation=By.cssSelector(".ng-animating");
	
	@FindBy(css=".mb-3")
	List<WebElement> products;
	
	public List<WebElement> getProductList() {
		waitForElementToAppear(productsBy);
		return products;
		
	}
	
	public WebElement getProductByName(String productName) {

		WebElement prod = products.stream().filter(product->
		product.findElement(By.cssSelector("b")).getText().equals(productName)).findFirst().orElse(null);
		return prod;
	}
	
	public cartActions addProductToCart(String productName) {
		WebElement prod=getProductByName(productName);
		prod.findElement(addToCart).click();
		waitForElementToAppear(toasterMsg);
		waitForElementDisappear(animation);	
		cartActions cartAct= new cartActions(driver);
		return cartAct;
	}
	
}
