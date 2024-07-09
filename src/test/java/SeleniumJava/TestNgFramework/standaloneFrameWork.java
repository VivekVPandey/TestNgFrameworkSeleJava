package SeleniumJava.TestNgFramework;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import SeleniumJava.TestComponents.BaseTest;
import SeleniumJava.TestComponents.Retry;
import SeleniumJava.abstrackComponents.AbstractComponents;
import SeleniumJava.pageObjects.LoginPage;
import SeleniumJava.pageObjects.ProductCatelogue;
import SeleniumJava.pageObjects.cartActions;
import SeleniumJava.pageObjects.orderDetailsPage;
import io.github.bonigarcia.wdm.WebDriverManager;
//working code
public class standaloneFrameWork extends BaseTest {
	String productName = "ADIDAS ORIGINAL";

		@Test (groups={"forwardOrder","sanity"}, dataProvider = "getData")
		
//		public void submitOrder(String email, String password, String productName) throws IOException, InterruptedException{
		public void submitOrder(HashMap<String, String> input) throws IOException, InterruptedException{

		ProductCatelogue catelogue= landing.loginApplication(input.get("email"), input.get("password"));
		List<WebElement> products= catelogue.getProductList();
		System.out.println(input.get("productName"));
		cartActions cartAct= catelogue.addProductToCart(input.get("productName"));
		cartAct.clickCart();
		Boolean match=cartAct.cartProductMatch(input.get("productName"));
		Assert.assertTrue(match);//validations should not go in page object file it should be in test case only
		cartAct.addCountry();
		String confirmMessage= cartAct.placeOrder();
		Assert.assertTrue(confirmMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
		System.out.println("Successfully validated the checkout flow");		
}

		@Test (groups="orderDetail", dependsOnMethods ="submitOrder",retryAnalyzer = Retry.class )
		public void orderDetailsValidation() throws InterruptedException {	
		ProductCatelogue catelogue= landing.loginApplication("Vivek@test.com", "Asdf@123");
		orderDetailsPage orderPage= catelogue.clickOrders();
		Boolean match= orderPage.verifyOrderDisplay(productName);
		Assert.assertTrue(match);
		Assert.assertTrue(false);
		System.out.println("executed");
	}
		

		
		
		@DataProvider
		public Object[][] getData() throws IOException
		{
//			HashMap< String, String> map= new HashMap<String, String>();
//			map.put("email", "Vivek@test.com");
//			map.put("password", "Asdf@123");
//			map.put("productName", "ZARA COAT 3");
//			
//			HashMap< String, String> map1= new HashMap<String, String>();
//			map1.put("email", "purvesh.s@ril.com");
//			map1.put("password", "Groww@01");
//			map1.put("productName", "ADIDAS ORIGINAL");
//			return new Object[][] {{map},{map1}};
			List<HashMap<String,String>> data = getJsonDataToMap(System.getProperty("user.dir")+"\\src\\test\\java\\SeleniumJava\\data\\PurchaseOrder.json");
			return new Object[][] {{data.get(0)},{data.get(1)}};
		}
		
//		HashMap< String, String> map= new HashMap<String, String>();
//		map.put("email", "Vivek@test.com");
//		map.put("password", "Asdf@123");
//		map.put("productName", "ZARA COAT 3");
//		
//		HashMap< String, String> map1= new HashMap<String, String>();
//		map1.put("email", "purvesh.s@ril.com");
//		map1.put("password", "Groww@01");
//		map1.put("productName", "ADIDAS ORIGINAL");
//return new Object [][] {{"Vivek@test.com", "Asdf@123","ADIDAS ORIGINAL"},{"purvesh.s@ril.com", "Groww@01","ZARA COAT 3"}};

}