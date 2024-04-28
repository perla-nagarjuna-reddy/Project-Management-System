package com.springbootproject.projectmanagementsystem.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springbootproject.projectmanagementsystem.exceptions.ProjectAlreadyExistsException;
import com.springbootproject.projectmanagementsystem.exceptions.ResourceNotFoundException;
import com.springbootproject.projectmanagementsystem.model.Project;
import com.springbootproject.projectmanagementsystem.repository.ProjectRepository;
import com.springbootproject.projectmanagementsystem.service.ProjectService;
@Service
public class ProjectServiceImpl implements ProjectService {
	
    @Autowired
    private ProjectRepository projectctRepository;
    
    
    @Override
    public Project createProject(Project project){
    	if(project.getName() != null && projectctRepository.existsByName(project.getName())){
    		throw new ProjectAlreadyExistsException("Project Already Exists with the name "+ project.getName());
    	}
    	return projectctRepository.save(project);
    	
    }

    @Override
    public List<Project> getAllProjects() {
    	System.out.println(projectctRepository.findAll());
        return projectctRepository.findAll();
        
    }
    

    @Override
    public Project getProjectById(Long id){
        Optional<Project> projectOptional = projectctRepository.findById(id);
        if(projectOptional.isPresent()){
            return projectOptional.get();
        }
        throw new ResourceNotFoundException("Project not found with id: " + id);
    }



	@Override
    public Project updateProject(Long id, Project project) {
    	Optional<Project> projectOptional = projectctRepository.findById(id);
        if (projectOptional.isPresent()) {
        	Project existingProject = projectOptional.get();
        	existingProject.setName(project.getName());
        	existingProject.setDescription(project.getDescription());
        	existingProject.setStartDate(project.getStartDate());
        	existingProject.setEndDate(project.getEndDate());
            return projectctRepository.save(existingProject);
        } else {
            throw new ResourceNotFoundException("Project not found with id: " + id);
        }
    }

    @Override
    public void deleteProjectById(Long id) {
        if (projectctRepository.existsById(id)) {
        	projectctRepository.deleteById(id);
        } else {
            throw new ResourceNotFoundException("Project not found with id: " + id);
        }
    }
}