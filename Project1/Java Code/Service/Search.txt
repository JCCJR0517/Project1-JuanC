package com.example.studentapp.service;

import com.example.studentapp.model.Student;
import com.example.studentapp.model.Course;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


public class SearchService {

    public List<Student> searchStudentsByFirstName(List<Student> students, String firstName) {
        return students.stream()
                .filter(student -> student.getFirstName().equalsIgnoreCase(firstName))
                .collect(Collectors.toList());
    }

    public List<Course> searchCoursesByCourseNumber(Student student, String courseNumber) {
        return student.getCourses().stream()
                .filter(course -> course.getCourseNumber().equalsIgnoreCase(courseNumber))
                .collect(Collectors.toList());
    }
}
