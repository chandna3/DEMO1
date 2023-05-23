package Collection;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import java.util.Random;

public class Delete {
	public static String title=GetRandomString();
	@Test
	public void TC1()
	{
		//creation
		RestAssured.baseURI="http://localhost:3000";
		//to get details in console
		Response Resp1=given()
				.contentType(ContentType.JSON)
		.body(" {\n"
				+  "        \"title\":\""+ title+"\",\n"
				+ "        \"author\": \"lalli\"\n"
				+ "}")
		.when()
		.post("/posts");
		//Display
		assertEquals(Resp1.getStatusCode(),201);
		System.out.println("*******Created Successfully ******");
		given().get("/posts").then().log().all();
		System.out.println("*******Logged all the responses ******");
		
		
		
		String NewlyaddedpostId=Resp1.jsonPath().getString("id");
		//Deletion
		Response RespOfDeletionReq =given().delete("/posts/"+NewlyaddedpostId+"");
		
		//verify if the above created data is deleted
		assertEquals(RespOfDeletionReq.statusCode(),200);
		System.out.println("The status code after deletion is as expected:"+RespOfDeletionReq.statusCode());
	}
	
		//code to generate random string for all the requests
		public static String GetRandomString() {
			Random random=new Random();
			String NewTitle="New_"+random.nextInt();
			return NewTitle;
			
	}

}
