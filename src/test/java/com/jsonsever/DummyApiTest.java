package com.jsonsever;
import static io.restassured.RestAssured.basePath;
import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.port;
import static io.restassured.RestAssured.*;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static org.hamcrest.Matchers.*;

public class DummyApiTest {

	
	@BeforeMethod
	public void config() {
		
		baseURI="http://dummy.restapiexample.com/api/v1";
	}
	
	@Test
	public void get_Employees() {
		
		when().get("/employees").then().assertThat().statusCode(200).and()
		.contentType(ContentType.JSON).and().time(lessThan(8000l)).log().all();

	}
	
}
