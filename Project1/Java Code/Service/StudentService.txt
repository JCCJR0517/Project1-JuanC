package com.example.studentapp.service;

import com.example.studentapp.model.Student;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
public class StudentService {
    private final RestTemplate restTemplate;

   
    public StudentService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }


    public List<Student> fetchStudents(String url) {
        // Fetch JSON array from the provided URL
        Student[] students = restTemplate.getForObject(url, Student[].class);
        // Convert the array into a List and return
        return Arrays.asList(students);
    }
}
