package Collection;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

import java.util.Random;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class Put {
	String something =GetRandomString();
		@Test
		public void m1(){
	//creation
	RestAssured.baseURI="http://localhost:3000";
	//to get details in console
	Response Resp1=given()
			.contentType(ContentType.JSON)
	.body(" {\n"
			+  "\n"
			+"\"title\":\""+ something+"\"\n"
			+ "\n"
			+ "}")
	.when()
	.put("/posts/1");
	//Response code of Post request
	assertEquals(Resp1.getStatusCode(),200);
	assertEquals(Resp1.jsonPath().getString("title"),something);
}
//code to generate random String for all the Requests
public static String GetRandomString() {
	Random random=new Random();
	String NewTitle="N1_"+random.nextInt();
	return NewTitle;
}

}
