package com.example.emsbackend.mapper;

import com.example.emsbackend.dto.ProjectDto;
import com.example.emsbackend.entity.Project;

public class ProjectMapper {
    public static ProjectDto mapToProjectDto(Project project){
        ProjectDto projectDto = new ProjectDto(
                project.getId(),
                project.getProjectName(),
                project.getProjectDec(),
                project.getEmployees()

        );
        return projectDto;
    }

    public static Project mapToProject(ProjectDto projectDto){
        Project project = new Project(
                projectDto.getId(),
                projectDto.getProjectName(),
                projectDto.getProjectDec(),
                projectDto.getEmployees()
        );
        return project;
    }
}
