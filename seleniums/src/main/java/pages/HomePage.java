package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import setup.Setup;

public class HomePage extends Setup{
	@FindBy(className = "login")
	@CacheLookup
	WebElement signIn;
	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	public void clickSignIn() {
		signIn.click();
	}
	
}
