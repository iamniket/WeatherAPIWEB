package CoreUtils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import TestUtils.TestUtilsClass;

public class UtilitiesClass {
	
    public static WebDriver driver;
	public static Properties prop;
	ExtentReports extent;

	
	public UtilitiesClass() throws IOException
	{
	    prop= new Properties();
		FileInputStream file = new FileInputStream("C:\\Users\\patilni\\eclipse-workspace\\HybridAPI&UI\\src\\main\\java\\ConfigFiles\\ObjectRepo.properties");
		prop.load(file);
	}
	
	
	public void initailisation()

	{
		
		  String BrowserName = prop.getProperty("BrowserName");
		  
		  if(BrowserName.equals("chrome")) {
		  System.setProperty("webdriver.chrome.driver","C:\\SeleniumDrivers\\chromedriver.exe"); 
		  driver=new ChromeDriver(); 
		  }
		  
		  else if(BrowserName.equals("Firefox")) {
		  System.setProperty("webdriver.gecko.driver", "C:\\SeleniumDrivers\\geckodriver.exe"); 
		  driver=new FirefoxDriver();
		  
		  }
		 
	    driver.get(prop.getProperty("WebNDTVUrl"));
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtilsClass.PageLoad_TimeOut, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtilsClass.Implicite_wait, TimeUnit.SECONDS);
		
		
	}
	
	
	public boolean isElementPresent(WebDriver driver,By locator){

	    if(driver.findElements(locator).size()!=0)
	    {
	        return true;

	    }
	    else
	    {
	        return false;
	    }
	}

	public String extractInt(String str)
	{
	
		str = str.replaceAll("[^\\d]", " ");

	
		str = str.trim();

		
		str = str.replaceAll(" +", " ");

		if (str.equals(""))
			return "-1";

		return str;
	}
	
	public void ExtentReport()
	{
		String path =System.getProperty("user.dir")+"\\reports\\index.html";

		ExtentSparkReporter reporter = new ExtentSparkReporter(path);

		reporter.config().setReportName("Web Automation Results");

		reporter.config().setDocumentTitle("Test Results");

		extent =new ExtentReports();

		extent.attachReporter(reporter);

		extent.setSystemInfo("QA", "Niket");
	}

	public void teardown()
	{	
		driver.quit();
	}
	
	public void extentflush()
	{
		extent.flush();
	}
	

}
