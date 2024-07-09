package SeleniumJava.TestNgFramework;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import SeleniumJava.TestComponents.BaseTest;
import SeleniumJava.abstrackComponents.AbstractComponents;
import SeleniumJava.pageObjects.LoginPage;
import SeleniumJava.pageObjects.ProductCatelogue;
import SeleniumJava.pageObjects.cartActions;
import io.github.bonigarcia.wdm.WebDriverManager;
//working code
public class loginErrorHandling extends BaseTest {

		@Test
		public void loginError() throws IOException, InterruptedException{
		landing.loginApplication("Vivek@test.com", "Asdf@123");
		System.out.println(landing.loginErrorMessage());
		//LoginPage.loginApplication("asdfds.com","asdfsd");
		
}



}
