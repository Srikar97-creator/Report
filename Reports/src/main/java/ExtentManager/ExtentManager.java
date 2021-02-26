package ExtentManager;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import Util.UtilClass;


public class ExtentManager {
	public static ExtentHtmlReporter htmlReporter;
	public static ExtentReports extent;
	public static ExtentTest test;
	UtilClass utilclass=new UtilClass();

	public void setExtent() {
		htmlReporter=new ExtentHtmlReporter("C:\\Users\\admin\\Desktop\\Selenium\\Reports\\test-output\\extentreports\\"+utilclass.getCurrentTime()+".html");
	
		htmlReporter.loadXMLConfig("C:\\Users\\admin\\Desktop\\Selenium\\Reports\\extent-config.xml");
		 htmlReporter.config().setDocumentTitle("Automation Test Report");
		 htmlReporter.config().setReportName("Ecommerce Test Automation Report");
		 htmlReporter.config().setTheme(Theme.DARK);

		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);

		extent.setSystemInfo("HostName", "MyHost");
		extent.setSystemInfo("ProjectName", "EcommerceTest");
		extent.setSystemInfo("Tester", "srikar");
		extent.setSystemInfo("OS", "Win10");
		extent.setSystemInfo("Browser", "Chrome");
	}

	
	public void endReport() {
		extent.flush();
	}
}
