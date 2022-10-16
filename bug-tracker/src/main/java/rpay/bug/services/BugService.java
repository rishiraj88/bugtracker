package rpay.bug.services;

import java.util.List;

import rpay.bug.entities.Bug;

public interface BugService {

  public List<Bug> getBugs();

  public void createBug(Bug bug);

}
