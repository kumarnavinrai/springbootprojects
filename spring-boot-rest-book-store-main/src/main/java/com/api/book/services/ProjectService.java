package com.api.book.services;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.api.book.dao.ProjectRepository;
import com.api.book.entities.Project;

@Component
public class ProjectService {
	
	@Autowired
	private ProjectRepository projectRepository;
	
	public ProjectService() {
		
	}
	
	public List<Project> getProjects(){
		List<Project> list = null;
		try {
			list = (List<Project>)this.projectRepository.findAll();
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return list;		
	}
	
	public Project getProjectById(int id) {
		Project project = null;
		try {
			project = this.projectRepository.findById(id);
		} catch(Exception e) {
			e.printStackTrace();
		}
		return project;
	}
	
	public Project addProject(Project project) {
		Project result = null;
		try {
			result = this.projectRepository.save(project);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public Project updateProject(int projectId, Project project) {
		Project result = null;
		try {
			project.setId(projectId);
			result = this.projectRepository.save(project);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public Project deleteProject(int id) {
		try {
			this.projectRepository.deleteById(id);
		} catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}

