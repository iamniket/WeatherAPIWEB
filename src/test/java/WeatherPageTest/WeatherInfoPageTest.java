package WeatherPageTest;

import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;

import CoreUtils.UtilitiesClass;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.mock.web.DelegatingServletInputStream;

import com.aventstack.extentreports.ExtentTest;

public class WeatherInfoPageTest extends UtilitiesClass {


    public WeatherInfoPageTest() throws IOException {

        super();

    }

    public void getTemperaturePune() throws InterruptedException {
    	
    	

        Thread.sleep(15000);
        if (driver.findElement(By.linkText(prop.getProperty("nothanks4"))).isDisplayed()) {
            driver.findElement(By.linkText(prop.getProperty("nothanks4"))).click();
        }
        Thread.sleep(5000);

        WebElement element = driver.findElement(By.xpath(prop.getProperty("SubMenu")));
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", element);

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.findElement(By.xpath(prop.getProperty("Weather"))).click();

        Thread.sleep(5000);

        driver.findElement(By.xpath(prop.getProperty("SearchBox"))).sendKeys("Pune");

		Thread.sleep(5000);

        driver.findElement(By.xpath(prop.getProperty("PuneCity"))).click();

		Thread.sleep(5000);

        driver.findElement(By.xpath(prop.getProperty("PuneCityMap"))).click();

		Thread.sleep(5000);

        String Pune = driver.findElement(By.xpath(prop.getProperty("PuneMH"))).getText();

        if (Pune.equalsIgnoreCase("Pune, Maharashtra")) {
            assertTrue(true);
        } else {
            assertTrue(false);
        }

        String TempDegrees = driver.findElement(By.xpath(prop.getProperty("TempinDegrees"))).getText();
        String TempFahren = driver.findElement(By.xpath(prop.getProperty("TempinFahren"))).getText();


        String tempone =extractInt(TempDegrees);

        String temptwo =extractInt(TempFahren);

        System.out.println(tempone);
        System.out.println(temptwo);
        
    	

    }
}
