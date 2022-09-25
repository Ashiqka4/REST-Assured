package tests;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.json.simple.JSONObject;
import io.restassured.http.ContentType;

public class TC7_Traveloka_API_IssueRequest {

	@Test
	public void issueCheckRequest() {

		JSONObject request = new JSONObject();

		request.put("uniqueId", "200ABC900");
		request.put("requestId", "zzz84");

		baseURI = "http://valptdqaldac01a.asp.dhisco.com:8085";

		given().
			header("Content-Type", "application/json").
			header("Authorization","Basic dHJhdmVsb2thOnRyYXZlbG9rYQ==").
			//auth().basic("traveloka", "traveloka").
			contentType(ContentType.JSON).
			accept(ContentType.JSON).
			body(request.toJSONString()).
		when().
			post("/traveloka/v1/issueCheckRequest").
		then().
			statusCode(200).
			body("booking.uniqueId", equalTo("200ABC900")).
			body("booking.status",equalTo("BOOKED")).
			body("booking.issuanceId",equalTo("44087128")).
			log().all();
	}
}