package ravi.SeleniumFramework;

import java.io.IOException;
import java.util.List;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import testComponenet.BaseTest;

public class StandAlone  extends BaseTest{

	@Test
	
	public void submitOrder() throws IOException
	{

		String productName = "ZARA COAT 3";
		
		ProductCatalogue productCatalogue = landingPage.loginApplication("ravineelamshankar@gmail.com", "Selenium4me");
		// ProductCatalogue productCatalogue = new ProductCatalogue(driver);
		List<WebElement> products = productCatalogue.getProductList();
		productCatalogue.addProductToCart(productName);

		CartPage cartPage = productCatalogue.goToCartPage();

		Boolean match = cartPage.VerifyProductDisplay(productName);
		Assert.assertTrue(match);
		CheckoutPage CheckoutPage = cartPage.goToCheckout();
		CheckoutPage.selectCountry("india");
		ConfirmationPage ConfirmationPage = CheckoutPage.submitOrder();
		String confirmMessage = ConfirmationPage.getConfirmationMessage();

		Assert.assertTrue(confirmMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
		
		
	}

}
