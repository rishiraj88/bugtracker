package rrpay.bug.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import rrpay.bug.dto.BugDTO;
import rrpay.bug.service.BugService;

import java.util.List;

import static rrpay.bug.util.EntitoDtoMapper.entityToDto;

@RestController
@RequestMapping("/bugs")
@RequiredArgsConstructor
public class BugController {
    // @RequiredArgsConstructor annotation takes care of autowiring by constructor
    // When @RequiredArgsConstructor is not applied, the final data members (properties) are to be initialized using a parameterized constructor.
    // Hence no need for @Autowired annotation on the field declaration
    private final BugService bugService;

    @GetMapping("/")
    public ResponseEntity<List<BugDTO>> getBugs() {
        List<BugDTO> bugs = bugService.getBugs();
        if (null == bugs || bugs.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
        return new ResponseEntity<>(bugs, HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<BugDTO> createBug(@RequestBody BugDTO bugRequest) {
        BugDTO bug = entityToDto(bugService.createBug(bugRequest));
        return ResponseEntity.status(HttpStatus.CREATED).body(bug);
    }

    @GetMapping("/{code}")
    public ResponseEntity<BugDTO> getOneBugByCode(@PathVariable String code) {
        BugDTO bug =bugService.getOneBugByCode(code);
        if(null == bug)
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        return  new ResponseEntity<>(bug,HttpStatus.OK);
    }

    @DeleteMapping("/{code}")
    public ResponseEntity<Void> deleteBug(@PathVariable String code) {
        bugService.deleteBug(code);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @DeleteMapping("/")
    public ResponseEntity<Void> deleteAllBugs(){
        bugService.deleteAllBugs();
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PatchMapping("/{code}")
    public ResponseEntity<String> updateBugDescription(@PathVariable String code, @RequestBody String description){
        String serviceResponse = bugService.updateBugDescription(code,description);
        return ResponseEntity.status(HttpStatus.OK).body(serviceResponse);
    }
}
