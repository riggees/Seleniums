package utils;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import setup.Setup;

public class AppUtils extends Setup {
	public static final int PAGE_LOAD_TIMEOUT = 20;
	public static final int IMPLICIT_WAIT = 20;
	public static final String USER_DIR = "user.dir";
	public static final String CONFIG_PATH = "\\src\\main\\java\\configData\\config.properties";
	public static final String EXCEL_PATH = "\\src\\main\\java\\testData\\TestData.xlsx";
	
	public void TakeScreenshot() {
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String currentDir = System.getProperty("user.dir");
		try {
			FileUtils.copyFile(scrFile, new File(currentDir + "/screenshots/" + System.currentTimeMillis() + ".png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
