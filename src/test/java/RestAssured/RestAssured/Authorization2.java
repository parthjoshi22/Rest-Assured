package RestAssured.RestAssured;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Authorization2 {
	@Test
	public void BearerToken()
	{
		//https://gorest.co.in/public/v2/users
		RequestSpecification requestSpec = RestAssured.given();
		
		requestSpec.baseUri("https://gorest.co.in");
		requestSpec.basePath("/public/v2/users");
		
		JSONObject payLoad= new JSONObject(); // We create json object i.e.payLoad
		payLoad.put("name", "Smith");   // We create parameter & we need to assign value
		payLoad.put("job", "Dev");
		payLoad.put("gender", "Male");
		
		// We create string variable for Bearer Token i.e. AuthToken
		
		String AuthToken = "Bearer 866218be3a275e793abe788f9a83a53da434004c5718abdc6215cd26d5fc6be2bhh";
		
		// Above token will go as part of header so now we create header for it
		
		requestSpec.headers("Authorization", AuthToken).
		contentType(ContentType.JSON).
		body(payLoad.toJSONString()); // payLoad will go as part request body
		
		//perform post request
		Response response = requestSpec.post();
		
		//validate status code 
		Assert.assertEquals(response.statusCode(), 201,"check for status code");
			
		//print status line & response boy
		System.out.println("Responsne status line:" + response.statusLine());
		System.out.println("Response body:" + response.body().asString());
	} 


}
