package setup;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import utils.AppUtils;


public class Setup {
	public static WebDriver driver;
	public static Properties prop;
	
	public Setup(){
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream(System.getProperty(AppUtils.USER_DIR)+ AppUtils.CONFIG_PATH);
			System.out.println("Setup" +System.getProperty(AppUtils.USER_DIR)+ AppUtils.CONFIG_PATH);
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public static void initialization(){
		ChromeOptions options = new ChromeOptions();
		options.addArguments("start-maximized","--disable-extensions");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver(options);
		//driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(AppUtils.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(AppUtils.IMPLICIT_WAIT, TimeUnit.SECONDS);
		
		
	}
	
}
