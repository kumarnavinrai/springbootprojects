package com.api.book.entities;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="projects")
public class Project {
	
//This is the sample json which will be need to add one to many project programmer. 
//means one project can be assigned to many programmers	
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
	
	@OneToMany(mappedBy = "project", cascade = CascadeType.ALL)
	private List<Programmer> programmer;

	public Project() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	public Project(int id, String title, List<Programmer> programmer) {
		super();
		this.id = id;
		this.title = title;
		this.programmer = programmer;
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



	public List<Programmer> getProgrammer() {
		return programmer;
	}



	public void setProgrammer(List<Programmer> programmer) {
		this.programmer = programmer;
	}



	@Override
	public String toString() {
		return "Project [id=" + id + ", title=" + title + ", programmer=" + programmer + "]";
	}



	
	

}
