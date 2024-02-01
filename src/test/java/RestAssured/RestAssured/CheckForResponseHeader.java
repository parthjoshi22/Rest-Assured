package RestAssured.RestAssured;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


public class CheckForResponseHeader {
// https://reqres.in/api/users/2
	@Test
	public void GetSingleUser()
	{
		// Get request specification of the request
		RequestSpecification requestSpec = RestAssured.given();
				
		// Specify BaseURI
		requestSpec.baseUri("https://reqres.in");	
		requestSpec.basePath("/api/users/2");	
		
		// Call get method
		Response response = requestSpec.get();
		
		// Validate Response Header Content Type
		String contentType = response.getHeader("Content-Type");
		
		System.out.println("Value Of Content-Type:" + contentType);
		
		// Validate header Content-Type, Expected Value application/json; charset=utf-8
		
		Assert.assertEquals(contentType, "application/json; charset=utf-8");
		
	/*	// Validate Response Header Connection
        String connection= response.getHeader("connection");
		
		System.out.println("Value Of connection:" + connection);   */
		
	/*	// Read all response Header Attributes/Keys and Prints their values     
		
		Headers headerList = response.getHeaders();
		
		// Iterate over header list
		for(Header header:headerList) 
		{
		  System.out.println("Key:" + header.getName() + "Value:" + header.getValue());
		}
			*/
	}
}