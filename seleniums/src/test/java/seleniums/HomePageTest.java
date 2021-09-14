package seleniums;

import java.util.Properties;

import org.testng.annotations.Test;

import pages.HomePage;
import setup.Setup;

public class HomePageTest extends Setup{
	
	HomePage homepage;
	
	@Test //(groups= "homepage", dependsOnMethods={"testAdd", "testDivide"})
	public void homeSubmit() {
		initialization();
		System.out.println(prop.getProperty("website"));
		driver.get(prop.getProperty("website"));
		homepage = new HomePage();
		homepage.clickSignIn();
	}
	
}
