package WeatherTest;

import WeatherPageTest.WeatherInfoAPIPageTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;

import java.io.IOException;

public class WeatherInfoAPITest extends WeatherInfoAPIPageTest {

    public WeatherInfoAPITest() throws IOException {
    	

    }

    WeatherInfoAPIPageTest weatherinfoAPI= new WeatherInfoAPIPageTest();

    @Test

    public void validateAPITemp()
    {
    	ExtentReport();
    	
        weatherinfoAPI.WeatherThroughAPI();
        
        extentflush();
       
    }
}
