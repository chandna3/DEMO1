package Collection;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class Get1 {
	
		@Test
		//Base URL 
		public void tc1() {
		RestAssured.baseURI="http://localhost:3000";
		
		
		Response Res=given()
		.when().get("/posts/2").then().extract().response();
		
	
		given()
		.when().get("/posts/2").then().log().all();
		
		//response is in Json format
		//change Response to string
		assertEquals(Res.getStatusCode(),200);
		assertEquals(Res.jsonPath().getString("id"), "2");
		assertEquals(Res.jsonPath().getString("title"), "title2023");

		}
		
	}
