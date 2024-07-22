package rrpay.bug.service;

import rrpay.bug.dto.BugDTO;
import rrpay.bug.model.Bug;

import java.util.List;

public interface BugService {
    public List<BugDTO> getBugs();

    public Bug createBug(BugDTO bug);

    public List<BugDTO> getBugsByCode(String code);

    public BugDTO getOneBugByCode(String code);

    public void deleteBug(String code);

    public void deleteAllBugs();

    public String updateBugDescription(String code, String description);
}
