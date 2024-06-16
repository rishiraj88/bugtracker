package rrpay.bug.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import rrpay.bug.model.enums.Role;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
  private String loginName = "rraj";
  private Role role = Role.ADMIN;
}
