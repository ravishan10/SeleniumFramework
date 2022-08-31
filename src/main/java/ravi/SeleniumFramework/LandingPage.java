package ravi.SeleniumFramework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import raviAbstractComponent.AbstractComponent;

public class LandingPage extends AbstractComponent{

	WebDriver driver;

	public LandingPage(WebDriver driver) {
		super(driver);
		// Initialization
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}

	// WebElement userEmail = driver.findElement(By.id("userEmail"));
	// PageFactory 
	@FindBy(id = "userEmail")
	WebElement userEmail;

	@FindBy(id = "userPassword")
	WebElement password;

	@FindBy(id = "login")
	WebElement submit;
	
	public ProductCatalogue loginApplication(String email, String pasword) {
		
		userEmail.sendKeys(email);
		password.sendKeys(pasword);
		submit.click();
		ProductCatalogue productCatalogue = new ProductCatalogue(driver);
		return productCatalogue;
	}
	public void goTo() {
		
		driver.get("https://rahulshettyacademy.com/client");
	}
	

}
