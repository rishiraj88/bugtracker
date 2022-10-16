package rpay.bug.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import rpay.bug.entities.Bug;
import rpay.bug.services.BugService;

@RestController
@RequestMapping("/bugs")
public class BugController {
  
  @Autowired
  BugService bugService;

  @Autowired
  private RestTemplate restTemplate;

  @GetMapping("")
  public ResponseEntity<List<Bug>> getBugs() {
    List<Bug> bugs = bugService.getBugs();
    return ResponseEntity.ok(bugs);
  }

  @PostMapping("/createbug")
  public void createBug(@RequestBody Bug bug) {
    bugService.createBug(bug);
  }
}
