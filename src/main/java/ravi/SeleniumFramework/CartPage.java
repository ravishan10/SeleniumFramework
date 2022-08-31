package ravi.SeleniumFramework;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import raviAbstractComponent.AbstractComponent;

public class CartPage extends AbstractComponent{
	
	WebDriver driver;
	
	@FindBy(css=".cartSection h3")
	List<WebElement> cartItems;
	
	@FindBy(css=".totalRow button")
	WebElement checkoutEle;
	
	
	public CartPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
		
	}
	public Boolean VerifyProductDisplay(String productName) {
		
		Boolean match = cartItems.stream().anyMatch(cartProduct -> cartProduct.getText().equalsIgnoreCase(productName));
		return match;
		
	}
	
	public CheckoutPage goToCheckout() {
		
		checkoutEle.click();
		
		return new CheckoutPage(driver);
		
	}

}
