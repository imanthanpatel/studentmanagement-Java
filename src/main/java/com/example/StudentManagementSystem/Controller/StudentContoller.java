package com.example.StudentManagementSystem.Controller;

import com.example.StudentManagementSystem.DTO.CourseDTO;
import com.example.StudentManagementSystem.DTO.StudentDTO;
import com.example.StudentManagementSystem.Service.StudetnService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
@Slf4j
@Controller
@RequestMapping("/student")
public class StudentContoller {

    private StudetnService service;

    StudentContoller(StudetnService service) {
        this.service = service;
    }

    @GetMapping("/new")
    public String showCreatedStudent(Model model) {
        model.addAttribute("studentDTO", new StudentDTO());
        return "add-student";
    }

    @GetMapping("/list")
    public String listStudent(@RequestParam(defaultValue = "0") int page,
                              @RequestParam(defaultValue = "3") int size,
                              Model model,
                              @RequestParam(value = "message",required = false)String message) {
        Page<StudentDTO> studentDTOS = service.getStudent(page, size);
        model.addAttribute("studentDTOS",studentDTOS);
        model.addAttribute("message",message);
        return "students";
    }

    @PostMapping
    public String createStudent(
            @Valid @ModelAttribute("studentDTO") StudentDTO studentDTO,
            BindingResult bindingResult,
            RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {//will check that it is consisting of error
            return "add-student";
        }

        if (service.existByEmail(studentDTO.getEmail())) {
            bindingResult.rejectValue("email", null, "Email must be unique");
            return "add-student";
        }

        service.createStudent(studentDTO);
        redirectAttributes.addFlashAttribute("message", "Student created successfully ✅");

        return "redirect:/student/list";
    }
    @GetMapping("/{id}")
    public String getCourseById(@PathVariable Long id,Model model){
        StudentDTO student = service.getStudentById(id);
        model.addAttribute("student",student);

        return  "view-student";

    }
    @GetMapping("/edit/{id}")
    public String editStudent(@PathVariable Long id, Model model) {

        StudentDTO studentDTO = service.getStudentById(id);
        model.addAttribute("studentDTO", studentDTO);

        return "edit-student";
    }
    @PostMapping("/update/{id}")
    public String updateCourse(@PathVariable Long id,
                               @Valid @ModelAttribute("studentDTO")StudentDTO studentDTO,
                               BindingResult bindingResult,
                               Model model,
                               RedirectAttributes redirectAttributes){


        service.updateStudent(id,studentDTO);
        redirectAttributes.addAttribute("message","Student is updated Successfully");

//        .info("POST /{id}/update - update course Successfully");
        log.info("post /{id}/update - update Student Succesfully");


        return "redirect:/student/list";


    }
}