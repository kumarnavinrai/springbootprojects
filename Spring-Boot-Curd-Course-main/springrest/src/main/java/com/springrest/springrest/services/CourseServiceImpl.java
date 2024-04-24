package com.springrest.springrest.services;

//import java.util.ArrayList;
import java.util.List;
//import java.util.stream.Collectors;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springrest.springrest.dao.CourseDao;
import com.springrest.springrest.entities.Course;

@Service
public class CourseServiceImpl implements CourseService {
	
	@Autowired
	private CourseDao courseDao;
	
//	List<Course> list;
	
	public CourseServiceImpl() {
//		list=new ArrayList<>();
//		list.add(new Course(145,"Java Core Course","this course basic from Java."));	
//		list.add(new Course(147,"Spring Boot Course","Creating REST API."));
//		list.add(new Course(5555,"Spring Boot Course","Creating REST API."));
	}

	@Override
	public List<Course> getCourses() {
		return courseDao.findAll();
	}

	@Override
	public Course getCourse(long courseId) {
		
//		Course c = null;
//		for(Course course: list) {
//			if(course.getId() == courseId) {
//				c= course;
//				break;
//			}
//		}
		Optional<Course> optionalCourse = courseDao.findById(courseId);
		if (optionalCourse.isPresent()) {
		    Course course = optionalCourse.get();
		    return course;
		}

		return null;
	}

	@Override
	public Course addCourse(Course course) {
//		list.add(course);
		courseDao.save(course);
		return course;
	}

	@Override
	public Course updateCourse(long courseId, Course course) {

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
		courseDao.save(course);
		return course;
		
//		list.forEach(e -> {
//			if(e.getId() == courseId) {
//				e.setTitle(course.getTitle());
//				e.setDescription(course.getDescription());
//			}
//		});
	}

	@Override
	public Course deleteCourse(Long id) {
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
		Optional<Course> optionalCourse = courseDao.findById(id);
		if (optionalCourse.isPresent()) {
		    Course course = optionalCourse.get();
		    courseDao.delete(course);
			return course;
		}

		return null;
		
		//list=this.list.stream().filter(e->e.getId()!=id).collect(Collectors.toList());
	}

	@Override
	public void delCourse(long courseId) {
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
		
	}

}
