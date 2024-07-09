package SeleniumJava.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import SeleniumJava.abstrackComponents.AbstractComponents;

public class LoginPage extends AbstractComponents {
	
	WebDriver driver;
	public LoginPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this); // how will @FindBy has knowledge of driver, its through init declared here
	}

	//WebElement UserEmailField= driver.findElement(By.id("userEmail"));
	//PageFactory - to save webelements in minimal syntax
	
	@FindBy(id="userEmail") // its as good as driver.findElement(By.id("userEmail"))
	WebElement UserEmailField; // The xpath will be saved in variable immediately next to the line
	
	@FindBy(id="userPassword") 
	WebElement passWordField; 
	
	@FindBy(id="login")
	WebElement loginButton;
	
	@FindBy(css="[class*='flyInOut']")
	WebElement errorMessage;
	
	public ProductCatelogue loginApplication(String UserName, String Password) {
		UserEmailField.sendKeys(UserName);
		passWordField.sendKeys(Password);
		loginButton.click();
		ProductCatelogue catelogue= new ProductCatelogue(driver);
		return catelogue;
	}
	public String loginErrorMessage() {
		
		waitForElementToAppear(errorMessage);
		return errorMessage.getText();
		
	}
	
	public void goTo() {
		
		driver.get("https://rahulshettyacademy.com/client");
		
	}
	
}
