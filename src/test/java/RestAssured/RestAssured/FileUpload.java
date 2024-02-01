package RestAssured.RestAssured;
import java.io.File;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class FileUpload {


	@Test(enabled = false)
	public void uploadFile()
	{
		//Create file file object
		
		File testFileUpload = new File("C:\\Users\\hp\\Desktop\\New Text Document.txt");

		//create Request Specification
		RequestSpecification requestSpec = RestAssured.given();
		
		//specify URL
		requestSpec.baseUri("http://httpbin.org/post");
		
		requestSpec.multiPart("files",testFileUpload);
        // file upload karne ke liye hum multiPart method use karenge
			
		requestSpec.contentType("multipart/form-data");
		
		//perform post request
		Response response = requestSpec.post();
		
		//print response body
		response.prettyPrint();
		
		//validate status code
		Assert.assertEquals(response.statusCode(), 200,"Check for status code");	
	
	}
	
// https://petstore.swagger.io/v2/pet/1/uploadImage
	
	@Test
	public void uploadImage()
	{
		//https://petstore.swagger.io/v2/pet/1/uploadImage
		
		//Create file file object
		
				File testFileUpload = new File("C:\\Users\\hp\\Desktop\\SolarFull_SeanDoran_2880FullwidthLede.jpg");

				//create Request Specification
				RequestSpecification requestSpec = RestAssured.given();
				
				//specify URL
				requestSpec.baseUri("https://petstore.swagger.io/v2/pet/1/uploadImage");
				
				requestSpec.multiPart("file",testFileUpload);
				
				requestSpec.contentType("multipart/form-data");
				
				//perform post request
				Response response = requestSpec.post();
				
				//print response body
				response.prettyPrint();
				
				//validate status code
				Assert.assertEquals(response.statusCode(), 200,"Check for status code");				
				
	}
}
