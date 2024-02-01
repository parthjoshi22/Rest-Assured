package RestAssured.RestAssured;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Authorization3 {
	//https://openweathermap.org/current
	//https://api.openweathermap.org/data/2.5/weather?q={city name}&appid={API key}

	@Test
	public void GetWeatherDataByCity()
	{
		//create request specification
		RequestSpecification requestSpec = RestAssured.given();
		requestSpec.baseUri("https://api.openweathermap.org");
		requestSpec.basePath("/data/2.5/weather");
		requestSpec.queryParam("q", "delhi").queryParam("appid", "ed9997485c5aebf644a45kef046becfceb6e6");
		Response response = requestSpec.get();

	}
}
