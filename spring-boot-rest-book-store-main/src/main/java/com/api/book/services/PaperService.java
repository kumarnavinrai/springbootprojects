
package com.api.book.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.api.book.dao.PaperRepository;
import com.api.book.entities.Paper;

@Component
public class PaperService {
	
	@Autowired
	private PaperRepository paperRepository;
	
	public PaperService() {
		
	}
	
	public List<Paper> getPapers(){
		List<Paper> list = null;
		try {
			list = (List<Paper>)this.paperRepository.findAll();
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return list;		
	}
	
	public Paper getPaperById(int id) {
		Paper paper = null;
		try {
			paper = this.paperRepository.findById(id);
		} catch(Exception e) {
			e.printStackTrace();
		}
		return paper;
	}
	
	public Paper addPaper(Paper paper) {
		Paper result = null;
		try {
			result = this.paperRepository.save(paper);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public Paper updatePaper(Long paperId, Paper paper) {
		Paper result = null;
		try {
			paper.setId(paperId);
			result = this.paperRepository.save(paper);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public Paper deletePaper(int id) {
		try {
			this.paperRepository.deleteById(id);
		} catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}

