package com.api.book.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.book.entities.Paper;

public interface PaperRepository extends JpaRepository<Paper,Integer>{
	public Paper findById(int id);

}
