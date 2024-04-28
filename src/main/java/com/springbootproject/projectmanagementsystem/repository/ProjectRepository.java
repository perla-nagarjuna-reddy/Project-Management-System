package com.springbootproject.projectmanagementsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springbootproject.projectmanagementsystem.model.Project;

public interface ProjectRepository extends JpaRepository<Project,Long>{
	boolean existsByName(String name);
}
