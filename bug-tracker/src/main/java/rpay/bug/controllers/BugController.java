package rpay.bug.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import rpay.bug.entities.Bug;
import rpay.bug.entities.constants.BugStatus;
import rpay.bug.services.BugService;

@RestController
@RequestMapping("/bugs")
public class BugController {
  
  @Autowired
  BugService bugService;

  @GetMapping("")
  public ModelAndView welcome() {
    return new ModelAndView("redirect:/bugs/list");
  }

  @GetMapping("/list")
  public ResponseEntity<List<Bug>> getBugs() {
    List<Bug> bugs = bugService.getBugs();

    if(0 >= bugs.size()) {
      return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
    return ResponseEntity.of(Optional.of(bugs));
  }

  @PostMapping("/create") //201 created
  public ResponseEntity<Bug> createBug(@RequestBody Bug bug) {
    Bug bugg = bugService.createBug(bug);
    return ResponseEntity.status(HttpStatus.CREATED).body(bugg);
  }

  @GetMapping("/list/{code}") //done
  public ResponseEntity<Bug> getBug(@PathVariable String code) {
    Bug bug = bugService.getBug(code);

    if(null == bug) {
      return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
    return ResponseEntity.of(Optional.of(bug));
  }

  @DeleteMapping("/delete/{code}") //done
  public ResponseEntity<Void> deleteBug(@PathVariable String code) {
    bugService.deleteBug(code);
    return  ResponseEntity.status(HttpStatus.NO_CONTENT).build();
  }

  @DeleteMapping("/deleteall")
  public ResponseEntity<Void> deleteAllBugs() {
    bugService.deleteAllBugs();
    return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
  }

  @PutMapping("/updatedesc/{code}")
  public ResponseEntity<Bug> updateBug(@PathVariable String code, @RequestBody String description) {
    bugService.updateBugDescription(code, description);
    return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
  }
}
