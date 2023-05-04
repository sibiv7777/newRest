package BasePage;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.DataProvider;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

	public class Base {

		public static Logger log = LogManager.getLogger(Base.class);
		public static RequestSpecification req;
		public static Response res;
		public static String namm;

		public void logTest() {
			if (10 < 11) {
				log.debug("this is Debug");
				log.info("this is info");
				log.warn("this is warn");
				log.error("this is error");
			} else {
				System.out.println("11 is greater than 10");
			}
	
			System.out.println("hello");

		}

		@DataProvider(name = "ownData")
		public String[][] data() {

			String[][] dat = { { "21", "Suresh@reqres.in", "Suresh", "Kumar", "Manager" },
					{ "20", "ramesh@reqres.in", "Ramesh", "Kumar", "CEO" },
					{ "19", "gopi@reqres.in", "Gopi", "Kumar", "Sales" } };
			return dat;
		}

		public static String restMethods() {
			String uri = RestAssured.baseURI = "http://localhost:3000";
			return uri;
		}

		public static void reqSpecification() {
			req = RestAssured.given();
		}

		public static Response respOnse(String use) {
			// req.request(Method.GET,"use");
			// namm=nam.toString();

			switch (namm) {
			case "GET1": {
				res = req.request(Method.GET, use);
				break;
			}
			case "POST": {
				res = req.request(Method.POST, use);
				break;
			}
			case "GET2": {
				res = req.request(Method.GET, use);
				break;
			}
			case "DELETE": {
				res = req.request(Method.DELETE);
				break;
			}
			}
			return res;

		}



}
