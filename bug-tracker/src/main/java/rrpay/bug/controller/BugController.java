package rrpay.bug.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import rrpay.bug.dto.BugDTO;
import rrpay.bug.model.Bug;
import rrpay.bug.service.BugService;

import static rrpay.bug.util.Mapper.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/bugs")
@RequiredArgsConstructor
public class BugController {
    private BugService bugService;

    @GetMapping("")
    public ModelAndView landingPage(ModelMap model) {
        return new ModelAndView("forward:/bugs/list");
    }

    @GetMapping("/list")
    public ResponseEntity<List<BugDTO>> getBugs() {
        List<Bug> bugs = bugService.getBugs();
        if (null == bugs || bugs.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
        List<BugDTO> bugsResponse = new ArrayList<>();
        bugs.forEach(bug -> bugsResponse.add(entityToDto(bug)));
        return new ResponseEntity<>(bugsResponse, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<BugDTO> createBug(@RequestBody BugDTO bugRequest) {
        BugDTO bug = entityToDto(bugService.createBug(dtoToEntity(bugRequest)));
        return ResponseEntity.status(HttpStatus.CREATED).body(bug);
    }

    @GetMapping("/list/{code}")
    public ResponseEntity<BugDTO> getBug(@PathVariable String code) {
        Bug bug =bugService.getBug(code);
        if(null == bug)
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        return  new ResponseEntity<>(entityToDto(bug),HttpStatus.OK);
    }

    @DeleteMapping("/delete/{code}")
    public ResponseEntity<Void> deleteBug(@PathVariable String code) {
        bugService.deleteBug(code);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @DeleteMapping("/deleteall")
    public ResponseEntity<Void> deleteAllBugs(){
        bugService.deleteAllBugs();
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PatchMapping("/updatedesc/{code}")
    public ResponseEntity<Bug> updateBugDescription(@PathVariable String code, @RequestBody String description){
        bugService.updateBugDescription(code,description);
        return  ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
