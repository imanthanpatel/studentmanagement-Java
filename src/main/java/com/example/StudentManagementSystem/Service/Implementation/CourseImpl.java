package com.example.StudentManagementSystem.Service.Implementation;

import com.example.StudentManagementSystem.Controller.CourseController;
import com.example.StudentManagementSystem.DTO.CourseDTO;
import com.example.StudentManagementSystem.Repositry.CourseRepositry;
import com.example.StudentManagementSystem.Service.CourseService;
import com.example.StudentManagementSystem.model.Course;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CourseImpl implements CourseService {
    private   static final Logger log = LoggerFactory.getLogger(CourseImpl.class);

    private final CourseRepositry repositry;
    private final ModelMapper mapper;

    public CourseImpl(CourseRepositry repositry, ModelMapper mapper) {
        this.repositry = repositry;
        this.mapper = mapper;
    }


    @Override
    public CourseDTO createCourse(CourseDTO courseDTO) {

        log.info("Creating Course with unique code: {}",courseDTO.getCourseCode());
        Course course = mapper.map(courseDTO, Course.class);
//        course.setActive(true);
        repositry.save(course);
        return mapper.map(course, CourseDTO.class);
    }

    @Override
    public boolean existByCode(String courseCode) {
        log.info("Checking if Code exists : {}",courseCode);
        return repositry.existsByCourseCodeIgnoreCase(courseCode);
    }

    @Override
    public Page<CourseDTO> getCourses(int page, int size) {
        log.info("Fetching course list for page: {}", page);

        PageRequest pageRequest =
                PageRequest.of(page, size, Sort.by(Sort.Direction.DESC, "id"));

        return repositry.findByActiveTrue(pageRequest)
                .map((Course course) -> mapper.map(course, CourseDTO.class));
    }

    @Override
    @Transactional(readOnly = true)
    public CourseDTO getCourseById(Long id){
       Course course = repositry.findById(id)
                .orElseThrow(() -> new RuntimeException("No course Found"));
       return mapper.map(course,CourseDTO.class);
    }
    @Override
    public CourseDTO updateCourse(Long id,CourseDTO courseDTO){
        Course course = repositry.findById(id)
                .orElseThrow(() -> new RuntimeException("No course Found"));
        mapper.map(courseDTO,course);

       Course save =  repositry.save(course);

        return mapper.map(save, CourseDTO.class);
    }

    @Override
    public boolean existByCodeAndIdNot(String courseCode, Long id) {
        log.info("Code from update page : {} ,id {} ",courseCode,id);
        return repositry.existsByCourseCodeIgnoreCaseAndIdNot(courseCode,id);
    }


}