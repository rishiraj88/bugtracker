package rrpay.bug.service;

import rrpay.bug.model.Bug;

import java.util.List;

public interface BugService {
    public List<Bug> getBugs();

    public Bug createBug(Bug bug);

    public Bug getBug(String code);

    public void deleteBug(String code);

    public void deleteAllBugs();

    public void updateBugDescription(String code, String description);
}
