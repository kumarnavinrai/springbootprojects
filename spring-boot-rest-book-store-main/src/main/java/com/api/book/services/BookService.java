package com.api.book.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.api.book.dao.BookRepository;
import com.api.book.entities.Book;
//import com.springrest.springrest.dao.CourseDao;
//import com.springrest.springrest.entities.Course;

@Component
public class BookService {
	
	@Autowired
	private BookRepository bookRepository;
	
//	List<Course> list;
	
	public BookService() {
//		list=new ArrayList<>();
//		list.add(new Course(145,"Java Core Course","this course basic from Java."));	
//		list.add(new Course(147,"Spring Boot Course","Creating REST API."));
//		list.add(new Course(5555,"Spring Boot Course","Creating REST API."));
	}

	//@Override
	public List<Book> getBooks() {
		//return courseDao.findAll();
		List<Book> list=(List<Book>)this.bookRepository.findAll();
		return list;
	}
	
	public Book getBookById(int id) {
		Book book = null;
		try {
			book=this.bookRepository.findById(id);
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return book;
	}

	//@Override
	public Book getBook(int bookId) {
		
//		Course c = null;
//		for(Course course: list) {
//			if(course.getId() == courseId) {
//				c= course;
//				break;
//			}
//		}
//		Optional<Course> optionalCourse = courseDao.findById(courseId);
//		if (optionalCourse.isPresent()) {
//		    Course course = optionalCourse.get();
//		    return course;
//		}
		Book book = null;
		try {
			book=this.bookRepository.findById(bookId);
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return book;
	}

	//@Override
	public Book addBook(Book book) {
//		list.add(course);
		//courseDao.save(course);
		Book result = this.bookRepository.save(book);
		return result;
	}

	//@Override
	public Book updateBook(int bookId, Book book) {

//		Course c = null;
//		for(Course coursesingle: list) {
//			if(coursesingle.getId() == courseId) {
//				coursesingle.setTitle(course.getTitle());
//				coursesingle.setDescription(course.getDescription());
//				c = coursesingle;
//				break;
//			}
//			
//		}
		//courseDao.save(course);
		//return course;
		book.setId(bookId);
		this.bookRepository.save(book);
		return book;
		
//		list.forEach(e -> {
//			if(e.getId() == courseId) {
//				e.setTitle(course.getTitle());
//				e.setDescription(course.getDescription());
//			}
//		});
	}

	//@Override
	public Book deleteBook(int id) {
//		Course c = null;
//		for(Course coursesingle: list) {
//			if(coursesingle.getId() == id) {
//				c = coursesingle;
//				break;
//			}
//			
//		}
//		if (c != null) {
//            list.remove(c);
//        }
//		Optional<Course> optionalCourse = courseDao.findById(id);
//		if (optionalCourse.isPresent()) {
//		    Course course = optionalCourse.get();
//		    courseDao.delete(course);
//			return course;
//		}

		this.bookRepository.deleteById(id);
		return null;
		
		//list=this.list.stream().filter(e->e.getId()!=id).collect(Collectors.toList());
	}

//	@Override
//	public void delCourse(long courseId) {
//		Course c = null;
//		for(Course coursesingle: list) {
//			if(coursesingle.getId() == courseId) {
//				c = coursesingle;
//				break;
//			}
//			
//		}
//		if (c != null) {
//            list.remove(c);
//        }
		
		//list=this.list.stream().filter(e->e.getId()!=id).collect(Collectors.toList());
		
//	}

}
