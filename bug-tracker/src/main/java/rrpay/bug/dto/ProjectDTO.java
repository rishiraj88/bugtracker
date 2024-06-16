package rrpay.bug.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import rrpay.bug.util.ProjectMap;

import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProjectDTO {
  private String name = "DIRECTDEBITPAY"; //INVOICEPAY, INSTALMENTPAY, DIRECTDEBITPAY
  private String description ="Pay by Direct Debit"; //"Pay by Invoice", "Pay in Instalments", "Pay by Direct Debit"
  //private User manager = new User("jbob", Role.PROJECT_MANAGER);
  //private Set<User> developers;
  //private Set<Bug> bugs;

  {
    this.description = ProjectMap.projects.get(this.name);
  }
}
