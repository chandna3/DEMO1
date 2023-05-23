package Collection;

import static org.testng.Assert.assertEquals;

import org.junit.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;



public class Get {
	public void tc1() {
		//Base URL 
		RestAssured.baseURI="http://localhost:3000";
		
		Response res = given()
		.get("/posts")
		.then()	
		.extract().response();
		
		System.out.println(res.getStatusCode());
		
		}

}

