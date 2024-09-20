package rrpay.bug.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;
import rrpay.bug.model.kt.enums.Role;
import rrpay.bug.util.ProjectMap;

import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection="project")
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
