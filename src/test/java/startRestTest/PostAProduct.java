package startRestTest;

import org.apache.commons.lang3.RandomStringUtils;
import org.json.simple.JSONObject;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import BasePage.Base;
import io.restassured.path.json.JsonPath;

public class PostAProduct extends Base {

	@BeforeClass
	public void start() {
		restMethods();
		// RestAssured.baseURI=("http://localhost:3000");
		reqSpecification();

	}

	@Test(dataProvider = "ownData", priority = 1)
	public void postData(String id, String email, String first_name, String last_name, String avatar) {
RandomStringUtils ut=new RandomStringUtils();
		JSONObject obj = new JSONObject();
		obj.put("id", id+ut.randomAlphabetic(3));
		obj.put("emai", email+ut.randomAlphabetic(3));
		obj.put("first_name", first_name+ut.randomAlphabetic(3));
		obj.put("last_name", last_name+ut.randomAlphabetic(3));
		obj.put("avatar", avatar+ut.randomAlphanumeric(3));

		// req.headers("Content-type", "application/json");
		req.headers("Content-type", "application/json");
		req.body(obj.toJSONString());
		// namm ="POST";
//respOnse("/data/post")		;
		// respOnse("/users");
		namm = "POST";
		respOnse("/data");
		JsonPath bo = res.getBody().jsonPath();
		System.out.println(bo.getString("first_name"));

	}

	@Test(priority = 2)
	public void getData() {
		String bod2 = res.getBody().asPrettyString();
	     JsonPath bo=res.getBody().jsonPath();
	     System.out.println(bo);
		System.out.println(bod2);

	}
}
