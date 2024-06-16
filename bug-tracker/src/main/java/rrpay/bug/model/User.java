package rrpay.bug.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import rrpay.bug.model.enums.Role;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
  private String loginName = "rraj";
  private Role role = Role.ADMIN;
}
