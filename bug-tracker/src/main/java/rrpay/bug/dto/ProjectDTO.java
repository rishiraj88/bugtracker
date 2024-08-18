package rrpay.bug.dto;

import rrpay.bug.util.ProjectMap;

public record ProjectDTO(String name, String description) {
    public ProjectDTO(String name, String description) {
        if (null != name && !name.isEmpty()) this.name = name;
        else this.name = "DIRECTDEBITPAY";
        this.description = ProjectMap.projects.get(this.name);
    }
}
