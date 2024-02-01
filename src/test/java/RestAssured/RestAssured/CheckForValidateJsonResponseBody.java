package RestAssured.RestAssured;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;


public class CheckForValidateJsonResponseBody {

	//https://reqres.in/api/users?page=2
	
	@Test
	public void UserListResponseBody()
	{
		// Get request specification of the request
		RequestSpecification requestSpec = RestAssured.given();
				
		// Specify BaseURI
		requestSpec.baseUri("https://reqres.in");	
		requestSpec.basePath("/api/users?page=2");	
		
		// Call get method
		Response response = requestSpec.get(); // Response object main store karenge jo get req se res milega
		
		// Read Response Body
		ResponseBody responseBody = response.getBody();
		
		String responseString = responseBody.asString();
		
		System.out.println(" Response Body:" + responseString);
		
		// Now we check if George is present in response body or not , so we use Contains Method
		
		Assert.assertEquals(responseString.contains("George"), true);
	}
}
