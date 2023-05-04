package startRestTest;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import BasePage.Base;
import io.restassured.path.json.JsonPath;

public class DeleteAProduct extends Base{

	@BeforeClass
	public void start() {
		restMethods();
		//RestAssured.baseURI=("http://localhost:3000");
		reqSpecification();
		
			}
	@Test
	public void get_del() {
		namm="GET1";
		respOnse("/data");
	JsonPath bo = res.getBody().jsonPath();
		System.out.println(bo.getString("first_name"));
		namm="DELETE";
		respOnse("/data/19B");
		JsonPath bo2= res.getBody().jsonPath();
		System.out.println(bo2.getString("id"));
		namm="GET1";
		System.out.println(respOnse("/data/21"));
			
		JsonPath bo1= res.getBody().jsonPath();
		System.out.println(bo1.get("first_name").equals("Kumarx"));
		//System.out.println(bo1.get("id[7]"));

		
	}
}
