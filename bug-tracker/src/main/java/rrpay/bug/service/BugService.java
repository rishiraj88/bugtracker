package rrpay.bug.service;

import rrpay.bug.dto.BugDto;
import rrpay.bug.model.Bug;

import java.util.List;

public interface BugService {
    public List<BugDto> getBugs();

    public Bug createBug(BugDto bug);

    public List<BugDto> getBugsByCode(String code);

    public BugDto getOneBugByCode(String code);

    public void deleteBug(String code);

    public void deleteAllBugs();

    public void updateBugDescription(String code, String description);
}
