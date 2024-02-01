package RestAssured.RestAssured;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class Test_DeleteMethod {
	@Test
	public void test06()
	{
		JSONObject jsonData = new JSONObject(); 
		jsonData.put("name", "Josh");   
		jsonData.put("job", "Cloud");
		
		RestAssured.baseURI= "https://reqres.in/api/users/320";
		RestAssured.given().header("Content-type", "application/json").
		contentType(ContentType.JSON).
		body(jsonData.toJSONString()).
		when().delete().
		then().statusCode(204).log().all();
	}
}

