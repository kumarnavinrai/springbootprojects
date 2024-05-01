package com.jwt.controller;


import com.jwt.model.Course;
import com.jwt.model.Student;
import com.jwt.repo.CourseRepository;
import com.jwt.repo.StudentRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/student/course")
public class StudentCourseController {

    private StudentRepository studentRepository;

    private CourseRepository courseRepository;

    public StudentCourseController(StudentRepository studentRepository,
                                   CourseRepository courseRepository) {
        this.studentRepository = studentRepository;
        this.courseRepository = courseRepository;
    }

    @PostMapping
    public Student saveStudentWithCourse(@RequestBody Student student){

        return   studentRepository.save(student);
    }

    @GetMapping
    public List<Student> findALlStudents(){
        List<Student> students = studentRepository.findAll();
        students.forEach(student -> student.setShouldIncludeBooks(false));
        return students;
    }

    @GetMapping("/{studentId}")
    public Student findStudent(@PathVariable Long studentId){
        return studentRepository.findById(studentId).orElse(null);
    }
    @GetMapping("/find/{name}")
    public List<Student> findStudentsContainingByName(@PathVariable String name){
        return studentRepository.findByNameContaining(name);
    }

    @GetMapping("/search/{price}")
    public List<Course> findCourseLessThanPrice(@PathVariable double price){
        return courseRepository.findByFeeLessThan(price);
    }

}