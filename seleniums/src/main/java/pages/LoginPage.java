package pages;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.poi.util.SystemOutLogger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import setup.Setup;
import utils.AppUtils;
import utils.Screenshot;

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
	
	@FindBy(css = "div[class*='alert']")
	@CacheLookup
	WebElement alert;
	
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	public void enterEmail(String emailID) {
		emailAddress.sendKeys(emailID);
	}
	
	public String submitEmail() {
		if (multiSubmit.size() != 0) {
			submit.click();
		}
		WebDriverWait wait = new WebDriverWait (driver, 10);
		boolean isVisible = wait.until(ExpectedConditions.invisibilityOf(alert));
		if (isVisible){
			return AppUtils.FAIL;
		}else {
			return AppUtils.PASS;
		}
		
		
	}

}
