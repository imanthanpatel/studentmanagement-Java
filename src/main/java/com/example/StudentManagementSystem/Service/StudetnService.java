package com.example.StudentManagementSystem.Service;

import com.example.StudentManagementSystem.DTO.StudentDTO;
import org.springframework.data.domain.Page;

import java.util.List;

public interface StudetnService {
    List<StudentDTO> getAllStudent();
    StudentDTO createStudent(StudentDTO studentDTO);
    boolean existByEmail(String email);
    boolean existByPhone(String phone);
    Page<StudentDTO> getStudent(int page, int size);
    StudentDTO getStudentById(Long id);
    StudentDTO updateStudent(Long id,StudentDTO studentDTO);

}
