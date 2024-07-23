package rrpay.bug.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import rrpay.bug.util.ProjectMap;

record ProjectDTO(
    String name,
    String description) {
  public ProjectDTO(
      String name,
      String description) {
    this.name = "DIRECTDEBITPAY";
    this.description = ProjectMap.projects.get(this.name);
  }
}
