package seleniums;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Random;

import org.apache.commons.lang3.CharSet;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.annotations.Test;

import pages.LoginPage;
import setup.Setup;
import utils.AppUtils;
import utils.ExcelUtils;
import utils.Screenshot;

public class LoginPageTest extends Setup{
	
	LoginPage login;
	ExcelUtils utils;
	
	@Test //(dependsOnGroups= {"homepage","database"},groups= "loginpage", alwaysRun=true)
	public void loginTest() throws EncryptedDocumentException, InvalidFormatException, IOException {
		if(driver.getTitle().contains("508")) {
			System.out.println("error in login form");
			driver.navigate().refresh();
			//driver.get(driver.getCurrentUrl());
		}
		login = new LoginPage();
		utils = new ExcelUtils();
		//String emailID = utils.getExceldata(System.getProperty(AppUtils.USER_DIR)+AppUtils.EXCEL_PATH,"in",1,1);
		byte[] array = new byte[7]; // length is bounded by 7
	    new Random().nextBytes(array);
	    String generatedString = new String(array, Charset.forName("UTF-8"));

	    System.out.println(generatedString);
		login.enterEmail(generatedString+"@test.com");
		String result = login.submitEmail();
		if (result == "fail") {
			Screenshot s = new Screenshot();
			s.TakeScreenshot();
		}
	}

}
