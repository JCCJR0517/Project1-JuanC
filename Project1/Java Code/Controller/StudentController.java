package com.example.studentapp.controller;

import com.example.studentapp.model.Student;
import com.example.studentapp.service.StudentService;
import com.example.studentapp.service.SearchService;
import com.example.studentapp.service.GpaCalculator;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


public class StudentController {
    private final StudentService studentService;
    private final SearchService searchService;
    private final GpaCalculator gpaCalculator;

    public StudentController(StudentService studentService, SearchService searchService, GpaCalculator gpaCalculator) {
        this.studentService = studentService;
        this.searchService = searchService;
        this.gpaCalculator = gpaCalculator;
    }

   
    public List<Student> fetchStudents(@RequestParam String url) {
        return studentService.fetchStudents(url);
    }

    
    public List<Student> searchStudents(@RequestParam String url, @RequestParam String firstName) {
        List<Student> students = studentService.fetchStudents(url);
        return searchService.searchStudentsByFirstName(students, firstName);
    }


    public double calculateStudentGPA(@RequestParam String url, @RequestParam String firstName) {
        List<Student> students = studentService.fetchStudents(url);
        Student student = searchService.searchStudentsByFirstName(students, firstName).get(0);
        return gpaCalculator.calculateGPA(student);
    }
}
