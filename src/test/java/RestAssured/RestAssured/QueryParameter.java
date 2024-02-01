package RestAssured.RestAssured;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class QueryParameter {
//https://reqres.in/api/users?page=2
	
	@Test
	public void filterData() 
	{
		// Get request specification of the request
		RequestSpecification requestSpec = RestAssured.given();
		
		// Specify BaseURI
		requestSpec.baseUri("https://reqres.in");	
		requestSpec.basePath("/api/users");	
		requestSpec.queryParam("page", 2).queryParam("id", 10);
		
		/* https://jsonpathfinder.com/
		 * ▼ 3:
			id:10
			email:byron.fields@reqres.in
			first_name:Byron
			last_name:Fields
			avatar:https://reqres.in/img/faces/10-image.jpg
		 */
		
		// Call get method
		Response response = requestSpec.get();
				
		// Read Response Body
		ResponseBody responseBody = response.getBody();
		String responseString = responseBody.asString();
		System.out.println(" Response Body:" + responseString);	
		
	}
}
