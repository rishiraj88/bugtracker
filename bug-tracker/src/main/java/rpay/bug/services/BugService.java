package rpay.bug.services;

import java.util.List;

import rpay.bug.entities.Bug;

public interface BugService {

  public List<Bug> getBugs();

  public Bug createBug(Bug bug);

  public Bug deleteBug(String code);

  public void deleteAllBugs();

  public Bug getBug(String code);

}
