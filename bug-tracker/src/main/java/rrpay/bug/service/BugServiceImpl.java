package rrpay.bug.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import rrpay.bug.model.Bug;
import rrpay.bug.repo.BugRepository;

import java.util.List;
@Service @RequiredArgsConstructor
public class BugServiceImpl implements BugService {
    private final BugRepository bugRepository;

    @Override
    public List<Bug> getBugs() {
        List<Bug> bugs = bugRepository.findAll();
        return bugs;
    }

    @Override
    public Bug createBug(Bug bug) {
        return bugRepository.save(bug);
    }

    @Override
    public List<Bug> getBugsByCode(String code) {
        return bugRepository.findByCode(code);
    }

    @Override
    public void deleteBug(String code) {
        bugRepository.deleteByCode(code);
    }

    @Override
    public void deleteAllBugs() {
        bugRepository.deleteAll();
    }

    @Override
    public void updateBugDescription(String code, String description) {
        Bug bug = bugRepository.findByCode(code).get(0);
        bug.setDescription(description);
        bugRepository.save(bug);
    }
}
