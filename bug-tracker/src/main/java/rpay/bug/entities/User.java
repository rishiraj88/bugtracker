package rpay.bug.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import rpay.bug.entities.constants.Role;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
  private String loginName = "rraj";
  private Role role = Role.ADMIN;
}
