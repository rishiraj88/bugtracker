package rrpay.bug.entities;

import java.nio.file.Path;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;
import lombok.NoArgsConstructor;
import rrpay.bug.entities.constants.BugStatus;
import rrpay.bug.entities.constants.BugType;
import rrpay.bug.entities.constants.Priority;
import rrpay.bug.entities.constants.Role;

@Data
@NoArgsConstructor
@Document(collection="bug")
public class Bug {
  @Id
  private ObjectId id;

  private String code;
  private String summary; //user input
  private String description; //user input
  private Priority priority = Priority.NONE;
  private Project project;
  private User reporter;
  private User assignee;
  private LocalDateTime dateCreated;
  private LocalDateTime dateResolved;
  private LocalDateTime dateClosed;
  private BugType type;
  private BugStatus status = BugStatus.OPEN;
  private List<Comment> comments;
  private List<String> workHistory;
  private Set<Path> attachments;

  {
    reporter = new User("rraj", Role.REPORTER);
    assignee = new User("mbibo",Role.DEVELOPER);
    dateCreated = LocalDateTime.now();
  }

}
