package rrpay.bug.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import rrpay.bug.model.Project;
import rrpay.bug.model.enums.BugStatus;
import rrpay.bug.model.enums.BugType;
import rrpay.bug.model.enums.Priority;
import rrpay.bug.model.enums.Role;

import java.nio.file.Path;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@Data
@NoArgsConstructor
public class BugDTO {
  private String code;
  private String summary; //user input
  private String description; //user input
  private Priority priority = Priority.NONE;
  private ProjectDTO project;
  private UserDTO reporter;
  private UserDTO assignee;
  private LocalDateTime dateCreated;
  private LocalDateTime dateResolved;
  private LocalDateTime dateClosed;
  private BugType type;
  private BugStatus status = BugStatus.OPEN;
  private List<CommentDTO> comments;
  private List<String> workHistory;
  private Set<Path> attachments;

  {
    reporter = new UserDTO("rraj", Role.REPORTER);
    assignee = new UserDTO("mbibo",Role.DEVELOPER);
    dateCreated = LocalDateTime.now();
  }

}
