package com.api.book.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.book.entities.Question;

public interface QuestionRepository extends JpaRepository<Question, Integer> {
	public Question findById(int id);
}
