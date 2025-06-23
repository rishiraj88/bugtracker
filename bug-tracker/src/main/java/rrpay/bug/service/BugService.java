package rrpay.bug.service;

import rrpay.bug.dto.BugDto;

import java.util.List;

public interface BugService {
    public List<BugDto> getBugs();

    public BugDto createBug(BugDto bug);

    public List<BugDto> getBugsByCode(String code);

    public BugDto getOneBugByCode(String code);

    public void deleteBug(String code);

    public void deleteAllBugs();

    public void updateBugDescription(String code, String description);
}
