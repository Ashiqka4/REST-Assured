package tests;

import org.testng.annotations.*;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.json.simple.JSONObject;
import io.restassured.http.ContentType;

public class Learning {
	
	@Test
	public void Post() {
		
		JSONObject request = new JSONObject();
		request.put("name", "AshiqKA");
		request.put("job", "Tester");
		
		baseURI = "https://reqres.in";
		
		given().
			header("Content-Type", "application/json").
			contentType(ContentType.JSON).
			accept(ContentType.JSON).
			body(request.toJSONString()).
		when().
			post("/api/users").
		then().
			statusCode(201).
			log().all();
		
	}
	
}