package WeatherPageTest;

import CoreUtils.UtilitiesClass;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.http.entity.ContentType;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;

import java.io.IOException;

import static io.restassured.RestAssured.*;

public class WeatherInfoAPIPageTest extends UtilitiesClass {

    public WeatherInfoAPIPageTest() throws IOException {
        super();
    }

    public void WeatherThroughAPI()
    {
    	
        double Kelvin= 273.15;
        RestAssured.baseURI = prop.getProperty("APIUrl");
        RequestSpecification request = RestAssured.given();

        Response response = request.queryParam("q", "Pune")
                .queryParam("appid", "7fe67bf08c80ded756e598d6f8fedaea")
                .get("/weather").then().log().all().extract().response();

        String jsonString = response.asString();
        System.out.println(response.getStatusCode());
        JsonPath jsonPathValidator = response.jsonPath();

        String min= jsonPathValidator.getString("main.temp_min");
        double MinTemp= Double.parseDouble(min);
        double MinTemp_Cels= MinTemp - Kelvin;
        System.out.println(MinTemp_Cels);
        String Max= jsonPathValidator.getString("main.temp_max");
        double MaxTemp = Double.parseDouble(Max);
        double MaxTemp_Cels=MaxTemp - Kelvin;
        System.out.println(MaxTemp_Cels);

        Assert.assertEquals(jsonString.contains("Pune"), true);
        


    }

    public int ReturnAPIResponse(int temp)
    {
        return temp;
        
    }
}

