package com.springbootproject.projectmanagementsystem.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.springbootproject.projectmanagementsystem.model.Project;

public interface ProjectService {
	Project createProject(Project project);
    List<Project> getAllProjects();
    Project getProjectById(Long id);
    Project updateProject(Long id, Project project);
    void deleteProjectById(Long id);

}
