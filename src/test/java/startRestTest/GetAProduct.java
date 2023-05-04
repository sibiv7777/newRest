package startRestTest;



import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import BasePage.Base;
import io.restassured.path.json.JsonPath;

public class GetAProduct extends Base {
	

	@BeforeClass
	public void start() {
		restMethods();
		reqSpecification();
		namm="GET1";
		respOnse("/data/8");
		System.out.println(res);
	}

	@Test
	public void responseBody() {
		log.getName();
		JsonPath jsonBody=res.getBody().jsonPath();
		System.out.println(jsonBody.getString("data.name[2]"));
		System.out.println();
		String body = res.getBody().asPrettyString();
		System.out.println(body);
	}

}
