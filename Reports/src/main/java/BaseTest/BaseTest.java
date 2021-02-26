package BaseTest;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import ExtentManager.ExtentManager;
import Util.UtilClass;


public class BaseTest {
	public static WebDriver driver;
	UtilClass utilclass = new UtilClass();

	protected Properties data;
	ExtentManager extentmanager = new ExtentManager();

	public BaseTest() {
		data = new Properties();
		try {
			data.load(new FileReader(
					"C:\\Users\\admin\\Desktop\\Selenium\\Reports\\src\\test\\resources\\data"));
		} catch (IOException e) { // TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@BeforeSuite
	public void BeforeSuite() {
		
		extentmanager.setExtent();
	}

	@AfterSuite
	public void AfterSuite() {
		extentmanager.endReport();
	}

	@BeforeMethod
	public void setup() {

		System.setProperty("webdriver.chrome.driver", data.getProperty("driverpath"));
		driver = new ChromeDriver();
		driver.get(data.getProperty("url"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

	}

	@AfterMethod
	public void tearDown() throws IOException {
		driver.close();
	}

	public String screenShot(WebDriver driver, String filename) {

		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File source = takesScreenshot.getScreenshotAs(OutputType.FILE);
		String destination = "C:\\Users\\admin\\Desktop\\Selenium\\Reports\\test-output\\screenshots\\"
				+ utilclass.getCurrentTime() + ".jpg";
		File finalDestination = new File(destination);
		try {
			FileUtils.copyFile(source, finalDestination);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.getMessage();
		}
		return destination;

	}

}
