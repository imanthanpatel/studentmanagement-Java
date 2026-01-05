package com.example.StudentManagementSystem.Controller;


import com.example.StudentManagementSystem.DTO.CourseDTO;
import com.example.StudentManagementSystem.Service.CourseService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/course")
public class CourseController {

    private CourseService service;
    CourseController(CourseService service){
        this.service=service;
    }
    @GetMapping("/new")
    public String showCreatedCourse(Model model){
        model.addAttribute("courseDTO",new CourseDTO());
        return "add-course";
    }

    @GetMapping("/list")
    public String listCourse(){

        return "courses";
    }

    @PostMapping
    public String createcourse(@Valid @ModelAttribute("courseDTO")CourseDTO courseDTO,
                               BindingResult bindingResult,
                               Model model,
                               RedirectAttributes redirectAttributes){
        if(bindingResult.hasErrors()){ //will check that it is consisting of error
            return "add-course";
        }
        if(service.existByCode(courseDTO.getCourseCode())){
            bindingResult.rejectValue("courseCode","Code must be unique");
            return "add-cource";

        }
        service.createCourse(courseDTO);
        redirectAttributes.addAttribute("message","Cource is Created");


        return "/course/list";
    }


}
