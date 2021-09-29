package seleniums;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pages.FormPage;
import utils.AppUtils;
import utils.ExcelUtils;

public class FormPageTest {

	FormPage formPage;
	ExcelUtils eUtils;
	
	@Test
	public void formTest() {
		formPage = new FormPage();
		Object data[][] = ExcelUtils.getTestData(System.getProperty(AppUtils.USER_DIR) + AppUtils.EXCEL_PATH, "in");
		formPage.formSubmit(data);
		
	}

	
	/*@DataProvider (name = "data-provider")
	public Object[][] getFormTestData() {
		Object data[][] = ExcelUtils.getTestData(System.getProperty(AppUtils.USER_DIR) + AppUtils.EXCEL_PATH, "in");
		System.out.println(data[0][0]+"in getformtestdata");
		return data;
	}
	
	@Test (dataProvider = "data-provider")
	public void formSubmitTest(String id, String EmailID, String Firstname, String Lastname, String Password,
			String Company, String Address1, String Address2, String City, String Code, String Phone) {
		System.out.println(id + "formSubmitTest" +EmailID + Lastname);
		formPage = new FormPage();
		//formPage.formSubmit();
		//Object[][] formData = ExcelUtils.getTestData(System.getProperty(AppUtils.USER_DIR) + AppUtils.EXCEL_PATH, "in");

	}*/

	
}
