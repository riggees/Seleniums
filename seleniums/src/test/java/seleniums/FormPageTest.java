package seleniums;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pages.FormPage;
import utils.AppUtils;
import utils.ExcelUtils;

public class FormPageTest {

	FormPage formPage;
	ExcelUtils eUtils;

	@Test(dataProvider = "getFormTestData")
	public void formSubmitTest(String id, String EmailID, String Firstname, String Lastname, String Password,
			String Company, String Address1, String Address2, String City, String Code, String Phone) {
		System.out.println(id + EmailID + Lastname);
		formPage = new FormPage();
		Object[][] formData = ExcelUtils.getTestData(System.getProperty(AppUtils.USER_DIR) + AppUtils.EXCEL_PATH, "in");

	}

	@DataProvider
	public Object[][] getFormTestData() {
		Object data[][] = ExcelUtils.getTestData(System.getProperty(AppUtils.USER_DIR) + AppUtils.EXCEL_PATH, "in");
		return data;
	}
}
