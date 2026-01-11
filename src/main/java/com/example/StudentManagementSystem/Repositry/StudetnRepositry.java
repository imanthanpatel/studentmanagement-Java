package com.example.StudentManagementSystem.Repositry;

import com.example.StudentManagementSystem.model.Course;
import com.example.StudentManagementSystem.model.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudetnRepositry extends JpaRepository<Student, Long> {

    boolean existsByEmailIgnoreCase(String email);

    boolean existsByPhone(String phone);

    Page<Student> findByActiveTrue(Pageable pageable);
}
