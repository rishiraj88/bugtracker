package rpay.bug.entities;

import java.nio.file.Path;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;
import lombok.NoArgsConstructor;
import rpay.bug.entities.enums.BugStatus;
import rpay.bug.entities.enums.BugType;
import rpay.bug.entities.enums.Priority;
import rpay.common.entities.Project;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.index.Indexed;


@Data
@NoArgsConstructor
@Document(collection="bug")
public class Bug {
  @Id
  private ObjectId id;

  private String code;
  private String summary;
  private String description;
  private Priority priority;
  private Project project;
  private User reporter;
  private User assignee;
  private LocalDateTime dateCreated;
  private LocalDateTime dateResolved;
  private LocalDateTime dateClosed;
  private BugType type;
  private BugStatus status;
  private List<Comment> comments;
  private List<String> workHistory;
  private Set<Path> attachments;
}
