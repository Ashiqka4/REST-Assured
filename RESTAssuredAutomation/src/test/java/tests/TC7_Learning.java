package tests;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import io.restassured.http.ContentType;
import static io.restassured.RestAssured.*;

public class TC7_Learning {
	
	@Test
	public void issueCheckRequest() {
		
		JSONObject request = new JSONObject();
		
		request.put("uniqueId", "200ABC900");
		request.put("requestId", "zzz84");
		
		//baseURI = "valptdqaldac01a.asp.dhisco.com:8085";
		
		given().
			header("Content-Type", "application/json").
			header("Authorization","Basic dHJhdmVsb2thOnRyYXZlbG9rYQ==").
			//auth().basic("traveloka", "traveloka").
			contentType(ContentType.JSON).
			accept(ContentType.JSON).
			body(request.toJSONString()).
		when().
			post("http://valptdqaldac01a.asp.dhisco.com:8085/traveloka/v1/issueCheckRequest").
		then().
			statusCode(200).
			log().all();
		
	}
	

}
