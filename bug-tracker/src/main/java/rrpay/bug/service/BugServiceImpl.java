package rrpay.bug.service;

import org.springframework.stereotype.Service;
import rrpay.bug.dto.BugDTO;
import rrpay.bug.model.Bug;
import rrpay.bug.repo.BugRepository;
import rrpay.bug.util.Mapper;

import static rrpay.bug.util.Mapper.*;

import java.util.List;
@Service
public class BugServiceImpl implements BugService {
    private BugRepository bugRepository;

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
    public Bug getBug(String code) {
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
        Bug bug = bugRepository.findByCode(code);
        bug.setDescription(description);
        bugRepository.save(bug);
    }
}
