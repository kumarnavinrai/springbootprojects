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

import com.api.book.entities.Question;
import com.api.book.services.QuestionService;


@RestController
public class QuestionController {
	
	@Autowired
	private QuestionService questionService;
	
	@GetMapping("/questions")
	public ResponseEntity<List<Question>> getQuestion(){
		List<Question> list = this.questionService.getQuestions();
		
		if(list.size() <= 0) {
			ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		
		return ResponseEntity.status(HttpStatus.CREATED).body(list);
	}
	
	@GetMapping("/questions/{questionId}")
	public ResponseEntity<Question> getQuestion(@PathVariable("questionId") int questionId){
		Question question = null;
		try {
			question = this.questionService.getQuestionById(questionId);
			return ResponseEntity.ok(question);
		} catch(Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		
		
	}
	
	@PostMapping("/questions")
	public ResponseEntity<Question> addQuestion(@RequestBody Question question){
		try {
			this.questionService.addQuestion(question);
			return ResponseEntity.status(HttpStatus.CREATED).build();
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	@PutMapping("/questions/{questionId}")
	public ResponseEntity<Question> updateQuestion(@PathVariable("questionId") int questionId, @RequestBody Question question){
		try {
			this.questionService.updateQuestion(questionId, question);
			return ResponseEntity.ok().body(question);
		} catch(Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	@DeleteMapping("/questions/{questionId}")
	public ResponseEntity<Void> deleteQuestion(@PathVariable("questionId") int questionId) {
		try {
			this.questionService.deleteQuestion(questionId);
			return ResponseEntity.status(HttpStatus.OK).build();
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
}
