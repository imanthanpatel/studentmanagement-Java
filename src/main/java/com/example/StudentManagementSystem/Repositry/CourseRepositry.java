package com.example.StudentManagementSystem.Repositry;

import com.example.StudentManagementSystem.model.Course;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepositry extends JpaRepository<Course, Long> {

    boolean existsByCourseCodeIgnoreCase(String courseCode);
    boolean existsByCourseCodeIgnoreCaseAndIdNot(String courseCode,Long id);

    Page<Course> findByActiveTrue(Pageable pageable);


}
