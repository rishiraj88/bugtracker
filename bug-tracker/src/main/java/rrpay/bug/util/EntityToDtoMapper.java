package rrpay.bug.util;

import rrpay.bug.dto.BugDTO;
import rrpay.bug.dto.ProjectDTO;
import rrpay.bug.dto.UserDTO;
import rrpay.bug.kt.model.Bug;
import rrpay.bug.model.Project;
import rrpay.bug.model.User;

public class EntityToDtoMapper {
    public static Bug dtoToEntity(BugDTO dto) {
        Bug entity = new Bug(dto.getSummary(),dto.getDescription(),dto.getPriority(),dto.getStatus());
        entity.setCode(dto.getCode());
        entity.setPriority(dto.getPriority());
        entity.setProject(dtoToEntity(dto.getProjectDTO()));
        entity.setReporter(dtoToEntity(dto.getReporterDTO()));
        entity.setDateResolved(dto.getDateResolved());
        return entity;
    }

    public static BugDTO entityToDto(Bug entity) {
        BugDTO dto = new BugDTO();
        dto.setCode(entity.getCode());
        dto.setSummary(entity.getSummary());
        dto.setSummary(entity.getSummary());
        dto.setDescription(entity.getDescription());
        dto.setPriority(entity.getPriority());
        dto.setPriority(entity.getPriority());
        dto.setProjectDTO(entityToDto(entity.getProject()));
        dto.setReporterDTO(entityToDto(entity.getReporter()));
        dto.setDateResolved(entity.getDateResolved());
        dto.setStatus(entity.getStatus());
        return dto;
    }

    public static Project dtoToEntity(ProjectDTO dto) {
        Project entity = new Project();
        entity.setName(dto.name());
        entity.setDescription(dto.description());
        return entity;
    }
    public static ProjectDTO entityToDto(Project entity) {
        ProjectDTO dto = new ProjectDTO(entity.getName(),entity.getDescription());

        return dto;
    }
    public static User dtoToEntity(UserDTO dto) {
        User entity = new User();
        entity.setLoginName(dto.getLoginName());
        entity.setRole(dto.getRole());
        return entity;
    }
    public static UserDTO entityToDto(User entity) {
        UserDTO dto = new UserDTO();
        dto.setLoginName(entity.getLoginName());
        dto.setRole(entity.getRole());
        return dto;

    }
}
