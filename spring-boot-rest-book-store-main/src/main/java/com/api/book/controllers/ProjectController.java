package com.api.book.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.api.book.entities.Project;
import com.api.book.services.ProjectService;


@RestController
public class ProjectController {
	
	@Autowired
	private ProjectService projectService;
	
	@GetMapping("/projects")
	public ResponseEntity<List<Project>> getProject(){
		List<Project> list = this.projectService.getProjects();
		
		if(list.size() <= 0) {
			ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		
		return ResponseEntity.status(HttpStatus.CREATED).body(list);
	}
	
	@GetMapping("/projects/{projectId}")
	public ResponseEntity<Project> getProject(@PathVariable("projectId") int projectId){
		Project question = null;
		try {
			question = this.projectService.getProjectById(projectId);
			return ResponseEntity.ok(question);
		} catch(Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		
		
	}
	
	@PostMapping("/projects")
	public ResponseEntity<Project> addProject(@RequestBody Project project){
		try {
			this.projectService.addProject(project);
			return ResponseEntity.status(HttpStatus.CREATED).build();
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	@PutMapping("/projects/{projectId}")
	public ResponseEntity<Project> updateQuestion(@PathVariable("projectId") int projectId, @RequestBody Project project){
		try {
			this.projectService.updateProject(projectId, project);
			return ResponseEntity.ok().body(project);
		} catch(Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	@DeleteMapping("/projects/{projectId}")
	public ResponseEntity<Void> deleteProject(@PathVariable("projectId") int projectId) {
		try {
			this.projectService.deleteProject(projectId);
			return ResponseEntity.status(HttpStatus.OK).build();
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
}

