package com.example.StudentManagementSystem.Service;

import com.example.StudentManagementSystem.DTO.CourseDTO;


public interface CourseService {
     CourseDTO createCourse(CourseDTO courseDTO);
     boolean existByCode(String courseCode);
}
