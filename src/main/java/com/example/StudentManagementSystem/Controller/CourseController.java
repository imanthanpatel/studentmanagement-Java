package com.example.StudentManagementSystem.Controller;


import com.example.StudentManagementSystem.DTO.CourseDTO;
import com.example.StudentManagementSystem.Service.CourseService;
import com.example.StudentManagementSystem.exception.GlobalExceptionHandler;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/course")
public class CourseController {

    private   static final Logger log = LoggerFactory.getLogger(CourseController.class);

    private final CourseService service;

    @Autowired
    CourseController(CourseService service){
        this.service=service;
    }
    @GetMapping("/new")
    public String showCreatedCourse(Model model){
        log.info("Get /course/new - Showing Create course page.");
        model.addAttribute("courseDTO",new CourseDTO());
        return "add-course";
    }

    @GetMapping("/list")
    public String listCourse(@RequestParam(defaultValue = "0")int page,
                            @RequestParam(defaultValue = "3")int size,
                             Model model,
                             @RequestParam(value = "message", required=false)String message){
        log.info("Get /course/list - Showing List page.");
        Page<CourseDTO> courseDTOS = service.getCourses(page, size);
        model.addAttribute("courseDTOS",courseDTOS);
        model.addAttribute("message",message);
        return "courses";
    }


    @PostMapping
    public String createcourse(@Valid @ModelAttribute("courseDTO")CourseDTO courseDTO,
                               BindingResult bindingResult,
                               Model model,
                               RedirectAttributes redirectAttributes){
        log.info("Post /course -  Create course Recquest Recived.");
        if(bindingResult.hasErrors()){//will check that it is consisting of error
            log.error("Page /course -Returned Due to validation error.");
            return "add-course";
        }
        if(service.existByCode(courseDTO.getCourseCode())){
            log.error("Page /course -Code must be Uinque.");

            bindingResult.rejectValue("courseCode","Code must be unique");
            return "add-cource";

        }
        service.createCourse(courseDTO);
        redirectAttributes.addAttribute("message","Cource is Created");

        log.info("POST /course - Course created succesfully");


        return "redirect:/course/list";
    }

    @GetMapping("/{id}")
    public String getCourseById(@PathVariable Long id,Model model){
        CourseDTO course = service.getCourseById(id);
        model.addAttribute("course",course);

        return  "view-course";

    }
    @GetMapping("/{id}/edit")
    public String editCourse(@PathVariable Long id,Model model){
        CourseDTO course = service.getCourseById(id);
        model.addAttribute("course",course);

        return  "edit-course";

    }
    @PostMapping("/{id}/update")
    public String updateCourse(@PathVariable Long id,
                               @Valid @ModelAttribute("courseDTO")CourseDTO courseDTO,
                               BindingResult bindingResult,
                               Model model,
                               RedirectAttributes redirectAttributes){

        log.info("Post /{id}/update -  Update course Recquest Recived. {}",id);

        if(bindingResult.hasErrors()){//will check that it is consisting of error
            log.error("Post /{id}/update  -Returned Due to validation error.");
            return "edit-course";
        }
        if(service.existByCodeAndIdNot(courseDTO.getCourseCode(),id)){
            log.error("Post /{id}/update  -Code must be Uinque.");

            bindingResult.rejectValue("courseCode","Code must be unique");
            return "edit-course";

        }
        service.updateCourse(id,courseDTO);
        redirectAttributes.addAttribute("message","Cource is updated Successfully");

        log.info("POST /{id}/update - update course Successfully");


        return "redirect:/course/list";


    }



}
