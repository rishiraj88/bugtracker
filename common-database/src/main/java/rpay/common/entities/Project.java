package rpay.common.entities;

import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Project {
  private String name;
  private String description;
  private User manager;
  private Set<User> developers;
  private Set<Bug> bugs;
}
