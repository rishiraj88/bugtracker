package rpay.common.entities;

import java.util.Random;
import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import rpay.bug.entities.Bug;
import rpay.bug.entities.User;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Project {
  private String name; //INVOICEPAY, INSTALMENTPAY, DIRECTDEBITPAY
  private String description;
  private User manager;
  private Set<User> developers;
  private Set<Bug> bugs;
}
