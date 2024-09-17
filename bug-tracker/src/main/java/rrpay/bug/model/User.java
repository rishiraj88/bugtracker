package rrpay.bug.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;
import rrpay.bug.model.kt.enums.Role;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection="user")
public class User {
  private String loginName = "rraj";
  private Role role = Role.ADMIN;
}
