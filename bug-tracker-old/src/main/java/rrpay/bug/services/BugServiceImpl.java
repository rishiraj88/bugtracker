package rrpay.bug.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rrpay.bug.entities.Bug;
import rrpay.bug.repositories.BugRepository;

@Service
public class BugServiceImpl implements BugService {

  @Autowired
  BugRepository bugRepository;

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
  public Bug deleteBug(String code) {
    Bug bug = bugRepository.deleteByCode(code);
    return bug;
  }

  @Override
  public void deleteAllBugs() {
    bugRepository.deleteAll();
  }

  @Override
  public Bug getBug(String code) {
    return bugRepository.findByCode(code);
  }

  @Override
  public Bug updateBugDescription(String code, String description) {
    Bug bug = bugRepository.findByCode(code);
    bug.setDescription(description);
    return bugRepository.save(bug);
  }
  
}
