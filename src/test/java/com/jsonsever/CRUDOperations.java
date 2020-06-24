package com.jsonsever;

import org.json.simple.JSONObject;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static  io.restassured.RestAssured.*;

public class CRUDOperations {
	
	@BeforeMethod
	public void config() {
		
		baseURI="http://localhost";
		port=3000;
		basePath="";
	}

	//@Test
	public void getPosts() {
		
		Response res = get("/posts");
		System.out.println(res.getHeaders());
		System.out.println("------------------------------------------------------------------------------------------------------");
		//to print res in json format
		System.out.println(res.prettyPrint());
		System.out.println("-------------------------------------------------------------------------------------------------------");
		System.out.println("res time "+res.getTime()+"ms status code = "+res.getStatusCode());
		
	}
	
	//@Test
	public void createPost() {
		
		JSONObject jo=new JSONObject();
		jo.put("title", "xyz");
		jo.put("author", "abc");

		RequestSpecification reqspec = given();
		reqspec.contentType(ContentType.JSON);
		reqspec.body(jo.toJSONString());
		Response res = reqspec.post("/posts");
		System.out.println(res.prettyPrint());
		
	}
	
	//@Test
	public void patchPosts() {
		
		JSONObject jo=new JSONObject();
		jo.put("author", "abc123");

		RequestSpecification reqspec = given();
		reqspec.contentType(ContentType.JSON);
		reqspec.body(jo.toJSONString());
		Response res = reqspec.patch("/posts/8");
		System.out.println(res.prettyPrint());
		
	}
	
	//@Test
	public void putPosts() {
		
		JSONObject jo=new JSONObject();
		jo.put("title", "xyz123");
		jo.put("author", "abc234");

		RequestSpecification reqspec = given();
		reqspec.contentType(ContentType.JSON);
		reqspec.body(jo.toJSONString());
		Response res = reqspec.put("/posts/7");
		System.out.println(res.prettyPrint());
		
	}
	
	@Test
	public void deletePosts() {

		RequestSpecification reqspec = given();
		
		Response res = reqspec.delete("/posts/7");
		System.out.println(res.prettyPrint());
		
	}
	
	
}
