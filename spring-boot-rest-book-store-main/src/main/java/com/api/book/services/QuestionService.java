package com.api.book.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.api.book.dao.QuestionRepository;
import com.api.book.entities.Question;

@Component
public class QuestionService {
	
	@Autowired
	private QuestionRepository questionRepository;
	
	public QuestionService() {
		
	}
	
	public List<Question> getQuestions(){
		List<Question> list = null;
		try {
			list = (List<Question>)this.questionRepository.findAll();
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return list;		
	}
	
	public Question getQuestionById(int id) {
		Question question = null;
		try {
			question = this.questionRepository.findById(id);
		} catch(Exception e) {
			e.printStackTrace();
		}
		return question;
	}
	
	public Question addQuestion(Question question) {
		Question result = null;
		try {
			result = this.questionRepository.save(question);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public Question updateQuestion(int questionId, Question question) {
		Question result = null;
		try {
			question.setQuestionId(questionId);
			result = this.questionRepository.save(question);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public Question deleteQuestion(int id) {
		try {
			this.questionRepository.deleteById(id);
		} catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
