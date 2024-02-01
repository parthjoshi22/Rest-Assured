package RestAssured.RestAssured;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class JsonObjecUsingJavaMap {

	// https://restful-booker.herokuapp.com/
	//https://restful-booker.herokuapp.com/apidoc/index.html
	//https://restful-booker.herokuapp.com/apidoc/index.html#api-Auth-CreateToken
	//https://restful-booker.herokuapp.com/auth
	

	@Test(enabled=false) // Means we disabled first test case , so only second tc will run
	public void createAuthToken()
	{
		/*{
    "username" : "admin",
    "password" : "password123"
}*/
		// Map ka objetc create kiya authToken
		Map<String, String> authToken = new HashMap<String, String>();
		authToken.put("username", "admin");
		authToken.put("password", "password123");
		
		Response response = RestAssured.given()
		.baseUri("https://restful-booker.herokuapp.com/auth")
		.contentType(ContentType.JSON)
		.body(authToken)
		.post(); // Response return karega & we stored in response object main store karenge
		
		response.prettyPrint(); 
		//// Console mmain response body print hoga means string main convert hoke print hoga
		
		//verify status code
		Assert.assertEquals(response.statusCode(), 200,"check for status code.");
	}	
	
    // https://reqres.in/api/users
	@Test
	public void createUser()
	{
		/*{
   "firstName":"Amod",
   "lastName":"Mahajan",
   "age": 28,
   "salary": 10000.56,
   "IsMarried":true,
   "Hobbies":["Music","Computer","Games"],
 "TechSkill":{
		"Programming language":"Java",
		"WebAutomation":"Selenium",
		"API testing" : "Rest Assured"
		   }
 }*/
		
		HashMap <String,Object> UserData = new HashMap<String,Object>();
		UserData.put("firstName", "Amod");
		UserData.put("lastName", "Mahajan");
		UserData.put("age", 28);
		
		ArrayList<String> hobbies = new ArrayList<String>();
		hobbies.add("Music");
		UserData.put("Hobbies",hobbies );
		
		HashMap <String,String> TechSkill = new HashMap<String,String>();
		TechSkill.put("API testing", "Rest Assured");
		UserData.put("TechSkill",TechSkill );
		
		Response response = RestAssured.given()
		.baseUri("https://reqres.in/api/users")
		.contentType(ContentType.JSON)
		.body(UserData)
		.post();
				
		response.prettyPrint();
				
		//verify status code
		Assert.assertEquals(response.statusCode(), 201,"check for status code.");
			
	}	
}
