package com.api.book.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="programmers")
public class Programmer {

//This is the sample json which will be need to add one to many project programmer. means one 
//project can be assigned to many programmers	
//	{
//        "id": 7,
//        "title": "Chat Gpt",
//        "programmer": [
//            {   
//                "id":1,
//                "title": "Steave jobs.",
//                "project": {
//                    "id":1
//                }
//            },
//            {
//                "id": 2,
//                "title": "Bill Gates.",
//                "project": {
//                    "id":1
//                }
//            }
//        ]
//    }

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String title;
	
	@ManyToOne
	@JoinColumn(name = "project_id")
	private Project project;

	
	public Programmer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Programmer(int id, String title, Project project) {
		super();
		this.id = id;
		this.title = title;
		this.project = project;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	@Override
	public String toString() {
		return "Programmer [id=" + id + ", title=" + title + ", project=" + project + "]";
	}
}
