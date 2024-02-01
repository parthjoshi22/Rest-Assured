package RestAssured.RestAssured;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class Test_PostMethod {
	@Test
	public void test03()
	{
		JSONObject jsonData = new JSONObject(); // We create json object i.e.jsonData
		jsonData.put("name", "Starc");   // We create parameter & we need to assign value
		jsonData.put("job", "QA");
		
		RestAssured.baseURI= "https://reqres.in/api/users";
		RestAssured.given().header("Content-type", "application/json").
		contentType(ContentType.JSON).
		body(jsonData.toJSONString()).
		when().post().
		then().statusCode(201).log().all();
		
	}
}
