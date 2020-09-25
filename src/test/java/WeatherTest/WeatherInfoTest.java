package WeatherTest;

import java.io.IOException;

import org.testng.annotations.*;

import com.aventstack.extentreports.ExtentTest;

import CoreUtils.UtilitiesClass;
import WeatherPageTest.WeatherInfoPageTest;



public class WeatherInfoTest extends WeatherInfoPageTest{

	public WeatherInfoTest() throws IOException
	{
		
	}
	WeatherInfoPageTest weatherinfo = new WeatherInfoPageTest();
	
	@BeforeTest
	
	public void setupMethod() throws IOException
	{
		ExtentReport();

		initailisation();

	}
	
	@Test
	
	public void validateTemp() throws IOException, InterruptedException {
		
		

		weatherinfo.getTemperaturePune();
		
	
	}
	
	
	
	@AfterTest
	
	public void closebrowser()
	{
		driver.quit();
		extentflush();
	}

}
