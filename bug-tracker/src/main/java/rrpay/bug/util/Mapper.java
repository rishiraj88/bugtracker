package rrpay.bug.util;

import rrpay.bug.dto.BugDTO;
import rrpay.bug.dto.ProjectDTO;
import rrpay.bug.dto.UserDTO;
import rrpay.bug.model.Bug;
import rrpay.bug.model.Project;
import rrpay.bug.model.User;

public class Mapper {
    public static Bug dtoToEntity(BugDTO dto) {
        Bug entity = new Bug();
        entity.setCode(dto.getCode());
        entity.setSummary(dto.getSummary());
        entity.setDescription(dto.getDescription());
        entity.setPriority(dto.getPriority());
        entity.setPriority(dto.getPriority());
        entity.setProject(dtoToEntity(dto.getProjectDTO()));
        entity.setReporter(dtoToEntity(dto.getReporterDTO()));
        entity.setDateResolved(dto.getDateResolved());
        entity.setStatus(dto.getStatus());
        return entity;
    }

    public static BugDTO entityToDto(Bug entity) {
        BugDTO dto = new BugDTO();

        return dto;
    }

    public static Project dtoToEntity(ProjectDTO dto) {
        Project  entity = new Project();
        entity.setName(dto.getName());
        entity.setDescription(dto.getDescription());
        return entity;
    }
    public static User dtoToEntity(UserDTO dto) {
        User entity = new User();
        entity.setLoginName(dto.getLoginName());
        entity.setRole(dto.getRole());
        return entity;

    }
}
