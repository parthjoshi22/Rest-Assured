package RestAssured.RestAssured;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class ValidateXMLResponse {

	@Test
	public void GetTravellersData()
	{
		//create request Specification
				RequestSpecification requestSpec = RestAssured.given();
				
				//http://restapi.adequateshop.com/api/Traveler?page=1
				//specify url
				requestSpec.baseUri("http://restapi.adequateshop.com");
				requestSpec.basePath("/api/Traveler");
				
				//add query parameter
				requestSpec.queryParam("page", "1");
				
				//specify header
				requestSpec.header("accept","application/xml");
				
				//perform get request 
				Response response = requestSpec.get();
				
				response.prettyPrint();
// Request ke sath PayLoad jata hai ..means Data jaata hai
}
}