package activities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import static org.hamcrest.CoreMatchers.equalTo;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import io.restassured.response.Response;

public class Activity2 {
	@Test(priority=1)
	public void addNewUserFromFile() throws IOException {
		FileInputStream inputJSON = new FileInputStream("path/to/userInfo.json");
 
		Response response = given()
			.baseUri("https://petstore.swagger.io/v2/user") 
			.header("Content-Type", "application/json") 
			.body(inputJSON) 
			.when().post(); 
 
		inputJSON.close();

		response.then().body("code", equalTo(200));
		response.then().body("message", equalTo("9901"));
	}
	
	@Test(priority=2)
	public void getUserInfo() {
		File outputJSON = new File("src/test/java/activities/userGETResponse.json");
 
		Response response = given()
			.baseUri("https://petstore.swagger.io/v2/user") 
			.header("Content-Type", "application/json") 
			.pathParam("username", "justinc") 
			.when().get("/{username}"); 
		
		String resBody = response.getBody().asPrettyString();
 
		try {
			outputJSON.createNewFile();
			FileWriter writer = new FileWriter(outputJSON.getPath());
			writer.write(resBody);
			writer.close();
		} catch (IOException excp) {
			excp.printStackTrace();
		}
		response.then().body("id", equalTo(9901));
		response.then().body("username", equalTo("justinc"));
		response.then().body("firstName", equalTo("Justin"));
		response.then().body("lastName", equalTo("Case"));
		response.then().body("email", equalTo("justincase@mail.com"));
		response.then().body("password", equalTo("password123"));
		response.then().body("phone", equalTo("9812763450"));
	}
	
	@Test(priority=3)
	public void deleteUser() throws IOException {
		Response response = given()
			.baseUri("https://petstore.swagger.io/v2/user") 
			.header("Content-Type", "application/json") 
			.pathParam("username", "justinc") 
			.when().delete("/{username}"); 
		response.then().body("code", equalTo(200));
		response.then().body("message", equalTo("justinc"));
	}
}
