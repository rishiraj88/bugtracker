package rrpay.bug.util;

import rrpay.bug.dto.BugDto;
import rrpay.bug.dto.ProjectDto;
import rrpay.bug.dto.UserDto;
import rrpay.bug.model.Bug;
import rrpay.bug.model.Project;
import rrpay.bug.model.User;

public class EntityDtoMapper {
    public static Bug dtoToEntity(BugDto dto) {
        Bug entity = new Bug(dto.getSummary(),dto.getDescription(),dto.getPriority(),dto.getStatus());
        entity.setCode(dto.getCode());
        entity.setPriority(dto.getPriority());
        entity.setProject(dtoToEntity(dto.getProjectDto()));
        entity.setReporter(dtoToEntity(dto.getReporterDto()));
        entity.setDateResolved(dto.getDateResolved());
        return entity;
    }

    public static BugDto entityToDto(Bug entity) {
        BugDto dto = new BugDto();
        dto.setCode(entity.getCode());
        dto.setSummary(entity.getSummary());
        dto.setSummary(entity.getSummary());
        dto.setDescription(entity.getDescription());
        dto.setPriority(entity.getPriority());
        dto.setPriority(entity.getPriority());
        dto.setProjectDto(entityToDto(entity.getProject()));
        dto.setReporterDto(entityToDto(entity.getReporter()));
        dto.setDateResolved(entity.getDateResolved());
        dto.setStatus(entity.getStatus());
        return dto;
    }

    public static Project dtoToEntity(ProjectDto dto) {
        Project entity = new Project();
        entity.setName(dto.name());
        entity.setDescription(dto.description());
        return entity;
    }
    public static ProjectDto entityToDto(Project entity) {
        ProjectDto dto = new ProjectDto(entity.getName(),entity.getDescription());

        return dto;
    }
    public static User dtoToEntity(UserDto dto) {
        User entity = new User();
        entity.setLoginName(dto.loginName());
        entity.setRole(dto.role());
        return entity;
    }
    public static UserDto entityToDto(User entity) {
        UserDto dto = new UserDto(entity.getLoginName(),entity.getRole());
        return dto;

    }
}
