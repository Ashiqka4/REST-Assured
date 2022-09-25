package tests;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;
import java.util.Map;

public class TC3_GetAndPostExamples {
	
	//@Test
	public void testGet() {
		
		baseURI = "https://reqres.in/api/";
		
		given().
			get("users?page=2").
		then().
			statusCode(200).
			body("data[4].first_name", equalTo("George")).
			body("data.first_name", hasItems("Michael","Lindsay","Tobias","Byron")).
			log().all();
	}
	
	@Test
	public void testPost() {
		
//		Map<String, Object> map = new HashMap<String, Object>();
//		map.put("name", "Ashiq");
//		map.put("job", "Tester");
//		
//		System.out.println(map);
		
//		JSONObject request = new JSONObject(map);
//		System.out.println(request);
		
		JSONObject request = new JSONObject();
		
		request.put("name", "AshiqK");
		request.put("job", "Tester");
		System.out.println(request);
		
//		System.out.println(request.toJSONString());
		
		baseURI = "https:/reqres.in";
		
		given().
			header("Content-Type", "application/json"). // in case of headers
			contentType(ContentType.JSON). // content type i am sending is of json
			accept(ContentType.JSON). // accept content type of json
			body(request.toJSONString()). // to make sure it converts to json string
		when().
			post("/api//users").
		then().
			statusCode(201).
			log().all();
	}

}
