package rrpay.bug.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import rrpay.bug.util.ProjectMap;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProjectDTO {
/*  Default project name is:
  DIRECTDEBITPAY
*/
  private String name = "DIRECTDEBITPAY";
  private String description;
  {
    this.description = ProjectMap.projects.get(this.name);
  }
}
