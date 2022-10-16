package rpay.bug.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import rpay.bug.entities.enums.Role;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
  private String loginName;
  private Role role;
}
