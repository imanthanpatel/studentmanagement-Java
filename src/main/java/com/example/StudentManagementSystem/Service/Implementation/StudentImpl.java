package com.example.StudentManagementSystem.Service.Implementation;

import com.example.StudentManagementSystem.DTO.StudentDTO;
import com.example.StudentManagementSystem.Repositry.StudetnRepositry;
import com.example.StudentManagementSystem.Service.StudetnService;
import com.example.StudentManagementSystem.exception.UserNotFoundException;
import com.example.StudentManagementSystem.model.Student;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional
public class StudentImpl implements StudetnService {
    private static final Logger log = LoggerFactory.getLogger(StudentImpl.class);

    private StudetnRepositry repositry;
    private ModelMapper mapper;


    StudentImpl(StudetnRepositry repositry,ModelMapper mapper){
        this.repositry=repositry;
        this.mapper=mapper;
    }


    @Override
    public List<StudentDTO> getAllStudent() {
        return repositry.findAll()
                .stream()
                .map(student -> mapper.map(student, StudentDTO.class))
                .toList();
    }

    @Override
    public StudentDTO createStudent(StudentDTO studentDTO) {
        log.info("Creating Course With Id : {}",studentDTO.getId());
        Student student = mapper.map(studentDTO,Student.class);
        repositry.save(student);
        return mapper.map(student,StudentDTO.class);
    }

    @Override
    public boolean existByEmail(String email) {
        log.info("Checking If Email Exist : {}",email);
        return repositry.existsByEmailIgnoreCase(email);
    }

    @Override
    public boolean existByPhone(String phone) {
        log.info("Checking If PhoneNo Exist : {}",phone);
        return repositry.existsByPhone(phone);
    }

    @Override
    public Page<StudentDTO> getStudent(int page, int size) {
        log.info("Fetching Student List for pagination : {}",page);
        PageRequest pageRequest = PageRequest.of(page, size, Sort.by(Sort.Direction.ASC,"id"));

        return repositry.findByActiveTrue(pageRequest)
                .map((student) -> mapper.map(student, StudentDTO.class));
    }

    @Override
    public StudentDTO getStudentById(Long id) {
        Student student = repositry.findById(id)
                .orElseThrow(() -> new UserNotFoundException("User not found with "));
        return mapper.map(student,StudentDTO.class);
    }

    @Override
    public StudentDTO updateStudent(Long id, StudentDTO studentDTO) {
        Student student = repositry.findById(id)
                .orElseThrow(() -> new UserNotFoundException("User not found with "));
        mapper.map(studentDTO,student);

        Student save = repositry.save(student);
        return mapper.map(save,StudentDTO.class);


    }
}
