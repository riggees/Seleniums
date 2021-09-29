package pages;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import setup.Setup;

public class FormPage extends Setup{
	
	
	@FindBy(xpath = "//input[@type='radio'][1]")
	@CacheLookup
	WebElement gender;

	@FindBy(css = "input[id='customer_firstname']")
	@CacheLookup
	WebElement firstName;
	
	@FindBy(xpath =  "//input[@id='customer_lastname']")
	@CacheLookup
	WebElement lastName;
	
	@FindBy(xpath = "//div[contains(@class,'asswor')]//descendant::input")
	@CacheLookup
	WebElement password;
	
	
	@FindBy(xpath = "//div[contains(@id,'uniform-days')]//descendant::option[contains(@value,'1')]")
	@CacheLookup
	WebElement dobDay;
	
	
	@FindBy(id="months")
	WebElement month;
	
	@FindBy(id="years")
	WebElement year;
	
	@FindBy(css = "div[class='checkbox']> div[class='checker']:not(#uniform-newsletter)")
	@CacheLookup
	WebElement checkbox;
	
	@FindBy(css = "input[id^='comp']")
	@CacheLookup
	WebElement company;
	
	@FindBy(css = "input[name='address1']")
	@CacheLookup
	WebElement address1;
	
	@FindBy(css = "label[for='city']+input")
	@CacheLookup
	WebElement city;
	
	@FindBy(css = "select[name='id_state']>option[value='9']")
	@CacheLookup
	WebElement state;
	
	@FindBy(css = "label[for='postcode']+input")
	@CacheLookup
	WebElement zipCode;
	
	@FindBy(css = "input[name='phone_mobile']")
	@CacheLookup
	WebElement phone;
	
	@FindBy(id = "SubmitCreate")
	@CacheLookup
	WebElement country;
	
	@FindBy(css = "input[name='alias']")
	@CacheLookup
	WebElement alias;
	
	@FindBy(css = "button[name='submitAccount']")
	@CacheLookup
	WebElement register;
	
	@FindBy(css = "div[class*='alert']")
	@CacheLookup
	WebElement alert;
	
	
	
	public FormPage() {
		PageFactory.initElements(driver,this);
	}
	
	public void formSubmit(Object[][] formData) {
		System.out.println(formData[0][0]+"formsubmit");
		gender.click();
		WebDriverWait wait = new WebDriverWait (driver, 15);
		wait.until(ExpectedConditions.elementToBeClickable(gender));
		gender.click();
		firstName.sendKeys(formData[0][2].toString());
		lastName.sendKeys(formData[0][3].toString());
		password.sendKeys(formData[0][4].toString());
		dobDay.click();
		//driver.findElement(By.cssSelector("input[id^='first']")).sendKeys("TestFirst");
		//driver.findElement(By.cssSelector("label[for='lastname']+input")).sendKeys("TestLast");
		
		Select month = new Select(this.month);
		month.selectByValue("6"); 
		Select year = new Select(this.year);
		year.selectByValue("1991");
		checkbox.click();
		address1.sendKeys(formData[0][6].toString());
		city.sendKeys(formData[0][8].toString());
		state.click();
		zipCode.sendKeys(formData[0][9].toString());
		phone.sendKeys(formData[0][10].toString());
		alias.click();
		register.click();	
		
		if(alert.isDisplayed()) {
			JavascriptExecutor js = (JavascriptExecutor)driver;
			js.executeScript("window.scrollBy(0,600)");
			TakesScreenshot scrShot =((TakesScreenshot)driver);
			File errorshot = scrShot.getScreenshotAs(OutputType.FILE);
			try {
				FileUtils.copyFile(errorshot, new File("./Screenshots/Screen.png"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
