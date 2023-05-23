package Collection;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;
import java.util.Random;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class Patch {
	{
		String Newtitle =GetRandomString();
		//creation
		RestAssured.baseURI="http://localhost:3000";
		//to get details in console
		Response Resp1=given()
				.contentType(ContentType.JSON)
		.body(" {\n"
				+  "\n"
				+"\"title\":\""+ Newtitle+"\"\n"
				+ "\n"
				+ "}")
		.when()
		.patch("/posts");
		//Response code of Post request
		assertEquals(Resp1.getStatusCode(),201);
		assertEquals(Resp1.jsonPath().getString("title"),Newtitle);
}
//code to generate random String for all the Requests
	public static String GetRandomString() {
		Random random=new Random();
		String NewTitle="New_"+random.nextInt();
		return NewTitle;
	}
	}