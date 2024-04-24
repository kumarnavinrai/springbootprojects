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

import com.api.book.entities.Paper;
import com.api.book.services.PaperService;

import jakarta.validation.Valid;


@RestController
public class PaperContoller {
	
	@Autowired
	private PaperService paperService;
	
	@GetMapping("/papers")
	public ResponseEntity<List<Paper>> getPaper(){
		List<Paper> list = this.paperService.getPapers();
		
		if(list.size() <= 0) {
			ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		
		return ResponseEntity.status(HttpStatus.CREATED).body(list);
	}
	
	@GetMapping("/papers/{paperId}")
	public ResponseEntity<Paper> getPaper(@PathVariable("paperId") int paperId){
		Paper paper = null;
		try {
			paper = this.paperService.getPaperById(paperId);
			return ResponseEntity.ok(paper);
		} catch(Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		
		
	}
	
	@PostMapping("/papers")
	public ResponseEntity<Paper> addPaper(@Valid @RequestBody Paper paper){
		try {
			this.paperService.addPaper(paper);
			return ResponseEntity.status(HttpStatus.CREATED).build();
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	@PutMapping("/papers/{paperId}")
	public ResponseEntity<Paper> updatePaper(@PathVariable("paperId") Long paperId, @RequestBody Paper paper){
		try {
			this.paperService.updatePaper(paperId, paper);
			return ResponseEntity.ok().body(paper);
		} catch(Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	@DeleteMapping("/papers/{paperId}")
	public ResponseEntity<Void> deletePaper(@PathVariable("paperId") int paperId) {
		try {
			this.paperService.deletePaper(paperId);
			return ResponseEntity.status(HttpStatus.OK).build();
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
}

