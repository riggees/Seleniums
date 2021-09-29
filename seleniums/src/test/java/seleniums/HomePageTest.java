package seleniums;

import org.testng.annotations.Test;

import pages.HomePage;
import setup.Setup;

public class HomePageTest extends Setup{
	
	HomePage homepage;
	
	@Test //(groups= "homepage", dependsOnMethods={"testAdd", "testDivide"})
	public void homeSubmit() {
		initialization();
		driver.get(prop.getProperty("website"));
		if(driver.getTitle().contains("508")) {
			System.out.println("error in home form");
			driver.navigate().refresh();
			//driver.get(driver.getCurrentUrl()); //driver.navigate().to(driver.getCurrentUrl());
			//driver.findElement(By textboxLocator).sendKeys(Keys.F5); driver.findElement(By textboxLocator).sendKeys("\uE035");
		}
		homepage = new HomePage();
		homepage.clickSignIn();
	}
	
}
