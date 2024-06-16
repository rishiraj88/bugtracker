package rrpay.bug;

import io.restassured.RestAssured;
import org.hamcrest.Matchers;
import org.junit.Ignore;
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
		RestAssured.given().contentType("application/json").body(requestBody).when().post("/bugs/create").then().log().all().statusCode(201).body("code", Matchers.equalTo("INSTALMENTPAY-001")).body("summary", Matchers.equalTo("first bug in payment in instalments")).body("description", Matchers.equalTo("bug desc")).body("priority", Matchers.is("LOW"));
	}
/*
	@Test
	public void getBugs() {
		when(bugRepository.findAll()).thenReturn(List.of(
				new Bug(), new Bug(), new Bug()
		));
		assertEquals(3, bugService.getBugs().size());
	}

	@Test
	public void createBug() {
		Bug bug = new Bug();
		bug.setCode("INVOICEPAY-001");
		when(bugRepository.save(bug)).thenReturn(bug);
		assertEquals("INVOICEPAY-001", bugService.createBug(bug).getCode());
	}

	@Test
	public void deleteBug() {
		String code = "INVOICEPAY-001";
		Bug bug = new Bug();
		bug.setCode(code);
		when(bugRepository.deleteByCode(code)).thenReturn(bug);
		assertEquals(code, bugService.deleteBug(code).getCode());

	}

	@Test
	public void deleteAllBugs() {
		String code = "INVOICEPAY-001";
		Bug bug = new Bug();
		bug.setCode(code);
		doNothing().when(bugRepository).deleteAll();
	}

	@Test
	public void getBug() {
		String code = "INSTALMENTPAY-001";

		Bug bug = new Bug();
		bug.setCode(code);
		when(bugRepository.findByCode(code)).thenReturn(bug);
		assertEquals(code, bugService.getBug(code).getCode());
	}

	@Test
	public void updateBugDescription() {
		String code = "INSTALMENTPAY-001";
		String description = "new description";
		Bug bug = new Bug();
		bug.setDescription(description);

		when(bugRepository.findByCode(code)).thenReturn(bug);
		when(bugRepository.save(bug)).thenReturn(bug);

		assertEquals(description, bugService.updateBugDescription(code,description).getDescription());
	}

*/
	@Test
	void contextLoads() {
	}

}
