package ravi.SeleniumFramework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import raviAbstractComponent.AbstractComponent;

public class CheckoutPage extends AbstractComponent {
	
	WebDriver driver;
	
	public CheckoutPage(WebDriver driver) {
		super(driver);
		
		this.driver=driver;
		
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(css="input[placeholder='Select Country']")
	WebElement country;
	
	@FindBy(css=".action__submit")
	WebElement submit;
	
	@FindBy(xpath="//button[contains(@class,'group-item')] [2]")
	WebElement selectCountry;
	
	public void selectCountry(String countryName) {
		
		Actions a = new Actions(driver);
		a.sendKeys(country, countryName).build().perform();
		selectCountry.click();
	}
	public ConfirmationPage submitOrder() {
		submit.click();
		return new ConfirmationPage(driver);
		
	}

}
