package startRestTest;

import org.testng.AssertJUnit;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import BasePage.Base;
import io.restassured.path.json.JsonPath;

public class GetAll extends Base {
	@BeforeClass
	public void start() {
		log.info("started the log");
		log.getName();
		// Base base = new Base();
		restMethods();
		// RestAssured.baseURI = "https://reqres.in/api";
		reqSpecification();
		
	}

	@Test(priority=1)
	public void statusCode() {
		namm="GET2";
		respOnse("/data");
		log.info("running step status code, priority 1");
		int responseStatusCode = res.getStatusCode();
		System.out.println(responseStatusCode);
		AssertJUnit.assertEquals(responseStatusCode, 200);
	

	}

	@Test(priority=2)
	public void responseBody() {
		log.info("running step response body, priority 3");
		JsonPath resBody = res.getBody().jsonPath();
		System.out.println(resBody.getString("data[1].name"));
		log.info("first_name matches Lindsay");
		System.out.println(res.getBody().asPrettyString());
		
		
	}
	
	@Test(priority=3)
	public void responseHeader() {
		log.info("running step responseHeader, priority 2");
		
		if(res.getHeader("Content-type").equals("applicaion/json; charset=utf-8")){
				System.out.println("content-type is application/json");}
				else	{System.out.println(res.getHeaders());}
	}
		
	}
	

