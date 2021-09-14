package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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
	
	
	@FindBy(css = "//div[contains(@id,'uniform-days')]//descendant::option[contains(@value,'1')]")
	@CacheLookup
	WebElement dobDay;
	
	
	@FindBy(id="months")
	WebElement month;
	
	@FindBy(id="years")
	WebElement year;
	
	@FindBy(id = "div[class='checkbox']> div[class='checker']:not(#uniform-newsletter)")
	@CacheLookup
	WebElement checkbox;
	
	@FindBy(id = "input[id^='comp']")
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
	
	public FormPage() {
		PageFactory.initElements(driver,this);
	}
	
	public void formSubmit(Object[][] formData) {
		gender.click();
	}
}
