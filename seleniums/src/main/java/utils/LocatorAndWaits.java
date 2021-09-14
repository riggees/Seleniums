package utils;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import setup.Setup;

public class LocatorAndWaits extends Setup{
	public static WebElement GetElement(int a, String locatorValue)
	{
		switch(a)
		{
		case 1:
			return  driver.findElement(By.className(locatorValue));
		case 2:
			return  driver.findElement(By.id(locatorValue));
		case 3:
			return  driver.findElement(By.xpath(locatorValue));
		case 4:
			return  driver.findElement(By.name(locatorValue));
		case 5:
			return  driver.findElement(By.tagName(locatorValue));
		case 6:
			return  driver.findElement(By.linkText(locatorValue));
		case 7:
			return  driver.findElement(By.partialLinkText(locatorValue));
		case 8:
			return  driver.findElement(By.cssSelector(locatorValue));
		default:
			return  driver.findElement(By.id(locatorValue));
		}
	}
	

	public static List<WebElement> GetElements(int a, String locatorValue)
	{
		switch(a)
		{
		case 1:
			return  driver.findElements(By.className(locatorValue));
		case 2:
			return  driver.findElements(By.id(locatorValue));
		case 3:
			return  driver.findElements(By.xpath(locatorValue));
		case 4:
			return  driver.findElements(By.name(locatorValue));
		case 5:
			return  driver.findElements(By.tagName(locatorValue));
		case 6:
			return  driver.findElements(By.linkText(locatorValue));
		case 7:
			return  driver.findElements(By.partialLinkText(locatorValue));
		case 8:
			return  driver.findElements(By.cssSelector(locatorValue));
		default:
			return  driver.findElements(By.id(locatorValue));
		}
	}

	public static By Location(int a, String locatorValue)
	{
		switch(a)
		{
		case 1:
			return By.className(locatorValue);
		case 2:
			return By.id(locatorValue);
		case 3:
			return By.xpath(locatorValue);
		case 4:
			return By.name(locatorValue);
		case 5:
			return By.tagName(locatorValue);
		case 6:
			return By.linkText(locatorValue);
		case 7:
			return By.partialLinkText(locatorValue);
		case 8:
			return By.cssSelector(locatorValue);
		default:
			return By.id(locatorValue);
		}
	}
	
	public static void WDWait(int a,int duration,String locator)
	{
		WebDriverWait wait =new WebDriverWait( driver,duration);
		wait.until(ExpectedConditions.presenceOfElementLocated(Location(a,locator)));
	}
	
}
