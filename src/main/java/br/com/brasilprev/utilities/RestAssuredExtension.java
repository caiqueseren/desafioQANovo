package br.com.brasilprev.utilities;

import java.net.URI;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ResponseOptions;
import io.restassured.specification.RequestSpecification;

public class RestAssuredExtension {

	public static RequestSpecification Request;

	public RestAssuredExtension() {
		//Arrange
		RequestSpecBuilder builder = new RequestSpecBuilder();
		builder.setBaseUri("http://localhost:8080");
		builder.setContentType(ContentType.JSON);
		RequestSpecification requestSpec = builder.build();
		Request = RestAssured.given().spec(requestSpec);

	}

	public static ResponseOptions<Response> GetOps(String url){
		try {
			return Request.get(new URI(url));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
