package com.api.book.controllers;

import java.util.List;

import jakarta.validation.Valid;
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

import com.api.book.entities.Book;
import com.api.book.services.BookService;

@RestController
public class BookCotroller {
	
	@Autowired
	private BookService bookService;
	
	@GetMapping("/books")
	public List<Book> getBooks() {
		
		return this.bookService.getBooks();
	}
	
	@GetMapping("/booksnew")
	public ResponseEntity<List<Book>> getBooksNew() {
		List<Book> list = this.bookService.getBooks();
		
		if(list.size() <= 0) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		
		return ResponseEntity.status(HttpStatus.CREATED).body(list);
	}
	
	
	
	@GetMapping("/books/{bookId}")
	public Book getBook(@PathVariable String bookId)
	{
		 //return this.courseService.getCourse(Long.parseLong(courseId));
		return null;
	}
	
	@PostMapping(path="/books",consumes="application/json")
	public Book addBook(@RequestBody Book book) {
		//return this.courseService.addCourse(course);
		return null;
	}
	
	@PostMapping("/booksnew")
	public ResponseEntity<Book> addBookNew(@Valid @RequestBody Book book) {
		
		try {
			this.bookService.addBook(book);
			//return ResponseEntity.of(Optional.of(b));
			return ResponseEntity.status(HttpStatus.CREATED).build();
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	@PutMapping("/books/{id}")
	public Book updateBook(@PathVariable("id") Long id, @RequestBody Book book ) {
		
		//return this.courseService.updateCourse(id, course);
		return null;
		
	}
	
	@PutMapping("/booksnew/{bookId}")
	public ResponseEntity<Book> updateBookNew(@RequestBody Book book, @PathVariable("bookId") int bookId) {
		try {
			this.bookService.updateBook(bookId, book);
			return ResponseEntity.ok().body(book);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

	
	@GetMapping("/booksnew/{id}")
	public ResponseEntity<Book> getBookNew(@PathVariable("id") int id){
		try {
			//if book not found
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
		
		
		//if book found
		//return ResponseEntity.of(Optional.of(book));
	}
	
	@DeleteMapping("/books/{id}")
	public Book deleteBook(@PathVariable("id") Long id) {
		//return this.courseService.deleteCourse(id);
		return null;
	}
	
	@DeleteMapping("/booksnew/{bookId}")
	public ResponseEntity<Void> deleteBookNew(@PathVariable("bookId") int bookId) {
		try {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
}
