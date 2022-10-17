package rpay.bug.entities;

import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import rpay.bug.entities.constants.ProjectMap;
import rpay.bug.entities.constants.Role;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Project {
  private String name = "DIRECTDEBITPAY"; //INVOICEPAY, INSTALMENTPAY, DIRECTDEBITPAY
  private String description ="Pay by Direct Debit"; //"Pay by Invoice", "Pay in Instalments", "Pay by Direct Debit"
  private User manager = new User("jbob", Role.PROJECT_MANAGER);
  private Set<User> developers;
  private Set<Bug> bugs;

  {
    this.description = ProjectMap.projects.get(this.name);
  }
}
