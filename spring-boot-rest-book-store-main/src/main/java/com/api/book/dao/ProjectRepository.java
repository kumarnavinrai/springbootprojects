package com.api.book.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.book.entities.Project;


public interface ProjectRepository extends JpaRepository<Project, Integer> {
	public Project findById(int id);
}
