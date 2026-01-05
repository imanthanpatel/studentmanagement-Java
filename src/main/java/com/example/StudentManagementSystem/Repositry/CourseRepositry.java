package com.example.StudentManagementSystem.Repositry;

import com.example.StudentManagementSystem.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepositry extends JpaRepository<Course, Long> {

    boolean existsByCourseCodeIgnoreCase(String courseCode);

}

