package RestAssured.RestAssured;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class Test_GetMethod {

	@Test
	void test01()
	{
		Response res = RestAssured.get("https://reqres.in/api/users?page=2");
		
		System.out.println("Response Code:" + res.getStatusCode());
		System.out.println("Response Body:" + res.getBody());
	//	System.out.println("Response Body:" + res.getBody().asString()); // To print entire response body
		System.out.println("Response Time:" + res.getTime());
		System.out.println("Response Header:" + res.getHeader("Content-Type"));
		
		// validate status code with expected status code TRUE
		
		int ExpectedStatusCode = 200;
		int ActualStatusCode = res.getStatusCode();
		Assert.assertEquals(ExpectedStatusCode, ActualStatusCode); 
		
		/* validate status code with expected status code FALSE
		
		int ExpectedStatusCode = 201;
		int ActualStatusCode = res.getStatusCode();
		Assert.assertEquals(ExpectedStatusCode, ActualStatusCode);  */
	}
	
	@Test
	void test02() 
	{
		// given, when, then i.e. BDD Way
		RestAssured.baseURI= "https://reqres.in/api/users";
		RestAssured.given().queryParam("page", "2").when().get().then().statusCode(200);
		
	}
 }
