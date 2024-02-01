package RestAssured.RestAssured;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class Authorization {
//http://postman-echo.com/basic-auth
// Unauthorized
	@Test
	public void basicAuth() 
	{
		// Get request specification of the request
		RequestSpecification requestSpec = RestAssured.given();
		// Specify BaseURI
		requestSpec.baseUri("http://postman-echo.com");	
		requestSpec.basePath("/basic-auth");	
		
		// Call get method
		Response response = requestSpec.auth().preemptive().basic("postman", "password").get();
		// Print status line
		System.out.println(" Response Status:" + response.statusLine());
		// Read Response Body
		ResponseBody responseBody = response.getBody();
		String responseString = responseBody.asString();
		System.out.println(" Response Body:" + responseString);
	}
	
	@Test
	public void DigestAuth()
	{
		//https://httpbin.org/
		//Auth - Auth methods
		//GET/digest-auth/{qop}/{user}/{passwd}Prompts the user for authorization using Digest Auth.
		//https://httpbin.org/digest-auth/undefined/parth/parth
		
				RequestSpecification requestSpec = RestAssured.given();
				
				requestSpec.baseUri("https://httpbin.org");	
				requestSpec.basePath("/digest-auth/undefined/parth/parth");	
				
		
				Response response = requestSpec.auth().digest("parth", "parth").get();				
				System.out.println(" Digest Auth Response Status:" + response.statusLine());
		
				ResponseBody responseBody = response.getBody();
				String responseString = responseBody.asString();
				System.out.println(" Digest Auth Response Body:" + responseString);
	}
}
