package rpay.bug.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rpay.bug.entities.Bug;
import rpay.bug.repositories.BugRepository;

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
  public void createBug(Bug bug) {
    bugRepository.save(bug);
  }
  
}
