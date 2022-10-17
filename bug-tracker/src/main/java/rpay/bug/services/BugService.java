package rpay.bug.services;

import java.util.List;

import rpay.bug.entities.Bug;
import rpay.bug.entities.constants.BugStatus;

public interface BugService {

  public List<Bug> getBugs();

  public Bug createBug(Bug bug);

  public Bug deleteBug(String code);

  public void deleteAllBugs();

  public Bug getBug(String code);

  public Bug updateBugDescription(String code, String description);

}
