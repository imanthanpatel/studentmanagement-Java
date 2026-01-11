package com.example.StudentManagementSystem.Service;

import com.example.StudentManagementSystem.DTO.CourseDTO;
import org.springframework.data.domain.Page;


public interface CourseService {
     CourseDTO createCourse(CourseDTO courseDTO);
     boolean existByCode(String courseCode);
     Page<CourseDTO> getCourses(int page, int size);
    CourseDTO getCourseById(Long id);
    CourseDTO updateCourse(Long id,CourseDTO courseDTO);
    boolean existByCodeAndIdNot(String courseCode,Long id);
}
