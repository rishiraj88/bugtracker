package rpay.common.entities;

import java.nio.file.Path;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;

import lombok.Data;
import lombok.NoArgsConstructor;
import rpay.common.entities.enums.BugStatus;
import rpay.common.entities.enums.BugType;
import rpay.common.entities.enums.Priority;

@Data
@NoArgsConstructor
public class Bug {
  private String summary;
  private String description;
  private Priority priority;
  private Project project;
  private User reporter;
  private User assignee;
  private LocalDate dateCreated;
  private LocalDate dateResolved;
  private LocalDate dateClosed;
  private BugType type;
  private BugStatus status;
  private List<Comment> comments;
  private List<String> workHistory;
  private Set<Path> attachments;
}
