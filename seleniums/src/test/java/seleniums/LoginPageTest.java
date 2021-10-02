package seleniums;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.annotations.Test;

import pages.LoginPage;
import setup.Setup;
import utils.AppUtils;
import utils.ExcelUtils;

public class LoginPageTest extends Setup{
	
	LoginPage login;
	ExcelUtils excelUtils;
	
	@Test //(dependsOnGroups= {"homepage","database"},groups= "loginpage", alwaysRun=true)
	public void loginTest() throws EncryptedDocumentException, InvalidFormatException, IOException {
		if(driver.getTitle().contains("508")) {
			System.out.println("error in login form");
			driver.navigate().refresh();
			//driver.get(driver.getCurrentUrl());
		}
		login = new LoginPage();
		excelUtils = new ExcelUtils();
		//String emailID = utils.getExceldata(System.getProperty(AppUtils.USER_DIR)+AppUtils.EXCEL_PATH,"in",1,1);
		String generatedString = AppUtils.getAlphaNumericString(8);
	    System.out.println(generatedString);
		login.enterEmail(generatedString+"@test.com");
		String result = login.submitEmail();
		if (result == AppUtils.FAIL) {
			AppUtils.TakeScreenshot();
	
		}
	}

}
