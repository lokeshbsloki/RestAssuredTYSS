package com.jsonsever;

import org.apache.poi.util.IOUtils;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class createRepo {
	
	@BeforeMethod
	public void config() {
		
		baseURI="https://api.github.com";
		
	}
	//@Test
	public void createRepo() throws Exception {
		
		FileInputStream fis = new FileInputStream("G:\\MyJavaProject\\RestAssuredTYSS\\src\\test\\resources\\JSON\\createRepo.json");
		given().auth().preemptive().basic("lokeshbsloki", "Lokeshbsgithub@1").contentType(ContentType.JSON).body(IOUtils.toByteArray(fis))
		.when().post("/user/repos").then().log().all().assertThat().statusCode(201);
		
	}
	
	@Test
	public void createRepoWithToken() throws Exception {
		
		FileInputStream fis = new FileInputStream("G:\\MyJavaProject\\RestAssuredTYSS\\src\\test\\resources\\JSON\\createRepo.json");
		given().header("Authorization", "Bearer 8930d7d214e4a1e1d05721a258af7ce428cb35d2")
		.contentType(ContentType.JSON).body(IOUtils.toByteArray(fis))
		.when().post("/user/repos").then().log().all().assertThat().statusCode(201);
		
	}

}
