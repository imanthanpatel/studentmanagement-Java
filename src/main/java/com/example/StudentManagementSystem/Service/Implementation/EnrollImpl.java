package com.example.StudentManagementSystem.Service.Implementation;

import com.example.StudentManagementSystem.DTO.EnrollmentDTO;
import com.example.StudentManagementSystem.Repositry.CourseRepositry;
import com.example.StudentManagementSystem.Repositry.StudetnRepositry;
import com.example.StudentManagementSystem.Service.EnrollmentService;
import com.example.StudentManagementSystem.model.Course;
import com.example.StudentManagementSystem.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EnrollImpl implements EnrollmentService {

    @Autowired
    private StudetnRepositry studentRepository;

    @Autowired
    private CourseRepositry courseRepository;

    @Transactional
    public void enrollStudent(EnrollmentDTO dto) {
        Student student = studentRepository.findById(dto.getStudentId())
                .orElseThrow(() -> new RuntimeException("Student not found"));

        List<Course> courses = courseRepository.findAllById(dto.getCourseIds());

        student.getCourses().clear(); // optional: remove previous enrollment
        student.getCourses().addAll(courses);

        studentRepository.save(student); // this will insert into enroll_stud
    }
}
