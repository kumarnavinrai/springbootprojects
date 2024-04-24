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
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "paper")
public class Paper {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//  @NotBlank(message = "User Name can not be empty !!")
//	@Size(min = 3, max = 12, message = "User name must be between 3 - 12 characters !!")
//	private String userName;
//
//	@Email(regexp = "^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$")
//	private String email;
//	
//	@AssertTrue(message = "Must agree terms and condition !!")
//	private boolean agreed;
    
    @NotBlank(message = "Title is mandatory")
    @Size(min = 2, max = 30, message = "Title should be between 2 and 30 characters")
    private String title;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "paper_writer",
            joinColumns = @JoinColumn(name = "writer_id"),
            inverseJoinColumns = @JoinColumn(name = "paper_id"))
    private List<Writer> writer = new ArrayList<>();

	public Paper() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Paper(Long id,
			@NotBlank(message = "Title is mandatory") @Size(min = 2, max = 30, message = "Title should be between 2 and 30 characters") String title,
			List<Writer> writer) {
		super();
		this.id = id;
		this.title = title;
		this.writer = writer;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public List<Writer> getWriter() {
		return writer;
	}

	public void setWriter(List<Writer> writer) {
		this.writer = writer;
	}

	@Override
	public String toString() {
		return "Paper [id=" + id + ", title=" + title + ", writer=" + writer + "]";
	}
	
}
