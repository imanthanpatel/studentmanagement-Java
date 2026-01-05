package com.example.StudentManagementSystem.Service.Implementation;

import com.example.StudentManagementSystem.DTO.CourseDTO;
import com.example.StudentManagementSystem.Repositry.CourseRepositry;
import com.example.StudentManagementSystem.Service.CourseService;
import com.example.StudentManagementSystem.model.Course;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CourseImpl implements CourseService {

    private final CourseRepositry repositry;
    private final ModelMapper mapper;

    public CourseImpl(CourseRepositry repositry, ModelMapper mapper) {
        this.repositry = repositry;
        this.mapper = mapper;
    }


    @Override
    public CourseDTO createCourse(CourseDTO courseDTO) {
        Course course = mapper.map(courseDTO, Course.class);
        repositry.save(course);
        return mapper.map(course, CourseDTO.class);
    }

    @Override
    public boolean existByCode(String courseCode) {
        return repositry.existsByCourseCodeIgnoreCase(courseCode);
    }



}