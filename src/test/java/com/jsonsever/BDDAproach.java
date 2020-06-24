package com.jsonsever;

import static io.restassured.RestAssured.basePath;
import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.port;
import static io.restassured.RestAssured.*;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static org.hamcrest.Matchers.*;

public class BDDAproach {

		@BeforeMethod
		public void config() {

			baseURI = "https://reqres.in";

		}

		//@Test
		public void listUsers() {

			given().queryParam("page", "2").when().get("/api/users").then().assertThat().statusCode(200).and()
					.contentType(ContentType.JSON).and().time(lessThan(8000l));

		}
		
		@Test
		public void singleUsers() {
			
			given().pathParam("id", "2").when().get("/api/users/{id}").then().assertThat().statusCode(200).and()
			.body("data.id", equalTo(2)).body("data.first_name", equalTo("Janet"));
			
		}
		
	}

