package rrpay.bug;

import io.restassured.RestAssured;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.context.annotation.Import;

@Import(TestcontainersConfiguration.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class BugTrackerApplicationTests {
	@LocalServerPort
	private Integer port;

	@BeforeEach
	void setup() {
		RestAssured.baseURI = "http://localhost";
		RestAssured.port = port;
	}
	@Test
	void shouldCreateBug() {
		String requestBody = """
				{
				    "code":"INSTALMENTPAY-001",
				    "summary": "first bug in payment in instalments",
				    "description":"bug desc",
				    "priority":"LOW",
				    "project":{
				      "name":"INSTALMENTPAY"
				    },
				    "reporter": {
				      "loginName": "rraj",
				      "role":"REPORTER"
				    },
				  "assignee": {
				      "loginName": "mbibo",
				      "role":"DEVELOPER"
				    },
				    "type":"SOFTWARE_BUG",
				  "status":"OPEN"
				  }
				""";
		RestAssured
				.given()
					.contentType("application/json").body(requestBody)
				.when()
					.post("/bugs/api/v2/")
				.then()
					.log().all().statusCode(201)
					.body("code", Matchers.equalTo("INSTALMENTPAY-001"))
					.body("summary", Matchers.equalTo("first bug in payment in instalments"))
					.body("description", Matchers.equalTo("bug desc"))
					.body("priority", Matchers.is("LOW"));
	}

	@Test
	void contextLoads() {
	}

}
