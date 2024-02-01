package RestAssured.RestAssured;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;

public class CheckForValidResponse {
//https://reqres.in/api/users/2
	
	@Test
	public void GetSingleUser()
	{
		// Specify BaseURI
		RestAssured.baseURI= "https://reqres.in/api/users/2";

// Every request in Rest-Assured library is represented by INTERFACE called RequestSpecification.
//This interface allows you modify req, adding header or add authentication details.
		// Get request specification of the request
		
		RequestSpecification requestSpec = RestAssured.given();
        //given() ye Req Speciafication reference return karega 
		
		// Call get method
		Response response = requestSpec.get();
		
		// Gets response code
		int statusCode = response.getStatusCode();
		
		// Validate actual status code with expected status code
		Assert.assertEquals(statusCode , 200);
	}
}
