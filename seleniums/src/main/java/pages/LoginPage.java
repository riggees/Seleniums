package pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import setup.Setup;

public class LoginPage extends Setup{
	
	@FindBy(css = "input[class*='count_in']")
	@CacheLookup
	WebElement emailAddress;
	
	@FindAll(@FindBy(css = "input[class*='is_required']"))
	@CacheLookup
	List<WebElement> multiSubmit;
	
	@FindBy(id = "SubmitCreate")
	@CacheLookup
	WebElement submit;
	
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	public void enterEmail(String emailID) {
		emailAddress.sendKeys(emailID);
	}
	
	public void submitEmail() {
		if (multiSubmit.size() != 0) {
			submit.click();
		}
		
		
	}

}
