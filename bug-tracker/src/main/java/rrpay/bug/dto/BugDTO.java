package rrpay.bug.dto;

import java.nio.file.Path;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

import lombok.Data;
import lombok.NoArgsConstructor;
import rrpay.bug.model.enums.BugStatus;
import rrpay.bug.model.enums.BugType;
import rrpay.bug.model.enums.Priority;
import rrpay.bug.model.enums.Role;

@Data
@NoArgsConstructor
public class BugDTO {
  private String code;
  private String summary; //user input
  private String description; //user input
  private Priority priority = Priority.NONE;
  private ProjectDTO projectDTO; //set to default value
  private UserDTO reporterDTO; //set to default value, later on may be auto-assigned from Principal (SSO)
  private UserDTO assigneeDTO; //set to default value
  private LocalDateTime dateCreated; //set to current time
  private LocalDateTime dateResolved;
  private LocalDateTime dateClosed;
  private BugType type; //set to default value
  private BugStatus status = BugStatus.OPEN; //default value
  private List<CommentDTO> commentDTOs;
  private List<String> workHistory;
  private Set<Path> attachments;

  {
    projectDTO = new ProjectDTO(null,null);
    reporterDTO = new UserDTO("rraj", Role.REPORTER);
    assigneeDTO = new UserDTO("mbibo",Role.DEVELOPER);
    dateCreated = LocalDateTime.now();
    type = BugType.SOFTWARE_BUG;
  }
}
