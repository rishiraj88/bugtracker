package rrpay.bug;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import rrpay.bug.dto.BugDTO;
import rrpay.bug.kt.model.Bug;
import rrpay.bug.repo.BugRepository;
import rrpay.bug.service.BugService;
import rrpay.bug.service.BugServiceImpl;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
public class BugTrackerServiceTest {
    @Autowired
    BugService bugService;

    @Mock
    BugRepository bugRepository;

    @Test
    public void createBug() {
        Bug bug = new Bug();
        bug.setCode("INVOICEPAY-001");
        when(bugRepository.save(bug)).thenReturn(bug);
        assertEquals("INVOICEPAY-001", bugService.createBug(new BugDTO()).getCode());
    }
/*


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
}
