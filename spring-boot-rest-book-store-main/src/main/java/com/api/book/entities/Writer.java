package com.api.book.entities;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "writer")
public class Writer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

//    @ManyToMany(cascade = { CascadeType.ALL })

    @ManyToMany(mappedBy = "writer")
    private List<Paper> paper = new ArrayList<>();

	public Writer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Writer(Long id, String name, List<Paper> paper) {
		super();
		this.id = id;
		this.name = name;
		this.paper = paper;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Paper> getPaper() {
		return paper;
	}

	public void setPaper(List<Paper> paper) {
		this.paper = paper;
	}

	@Override
	public String toString() {
		return "Writer [id=" + id + ", name=" + name + ", paper=" + paper + "]";
	}
    
}
