package rpay.bug;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import rpay.bug.entities.Bug;
import rpay.bug.repositories.BugRepository;
import rpay.bug.services.BugService;

@SpringBootTest
class BugTrackerApplicationTests {

	@Autowired
	private BugService bugService;

	@Test
	void contextLoads() {
	}

	@MockBean
	private BugRepository bugRepository;

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

}
