package activities;

import java.util.HashMap;

import org.testng.annotations.Test;
import static org.hamcrest.CoreMatchers.equalTo;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class Activity1 {
	String url= "https://petstore.swagger.io/v2/pet";
	
	@Test(priority = 1)
	public void createpet() {
		HashMap<String, Object> reqbody= new HashMap<>();
		reqbody.put("id", 77232);
		reqbody.put("name", "Riley");
		reqbody.put("status", "alive");
		Response response = given().contentType(ContentType.JSON)
		        .body(reqbody).when().post(url);
		response.then().body("id", equalTo(77232));
		response.then().body("name", equalTo("Riley"));
		response.then().body("status", equalTo("alive"));
	}
	
	@Test(priority = 2)
	public void getpet() {
		Response response = given().
				baseUri("https://petstore.swagger.io/v2/pet")
				.contentType(ContentType.JSON)
		        .when().pathParam("petId", 77232)
		        .get("/{petId}");
		response.then().body("id", equalTo(77232));
		response.then().body("name", equalTo("Riley"));
		response.then().body("status", equalTo("alive"));
	}
	@Test(priority = 3)
	public void deletepet() {
		Response response = given().
				baseUri("https://petstore.swagger.io/v2/pet")
				.contentType(ContentType.JSON)
		        .when().pathParam("petId", 77232)
		        .delete("/{petId}");
		response.then().body("code", equalTo(200));
		response.then().body("message", equalTo("77232"));
	}

}
