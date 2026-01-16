package com.example.StudentManagementSystem.Controller;

import com.example.StudentManagementSystem.DTO.EnrollmentDTO;
import com.example.StudentManagementSystem.Service.CourseService;
import com.example.StudentManagementSystem.Service.EnrollmentService;
import com.example.StudentManagementSystem.Service.StudetnService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@RequestMapping("/enroll")
public class EnrollmentController {

    private final CourseService courseService;
    private final StudetnService studetnService;
    private final EnrollmentService enrollmentService;

    @GetMapping
    public String enrollPage(Model model) {
        model.addAttribute("courses", courseService.getCourses(0, 100).getContent());
        model.addAttribute("students", studetnService.getAllStudent());
        model.addAttribute("enrollment", new EnrollmentDTO());
        return "enroll";
    }
    @PostMapping("/save")
    public String saveEnrollment(@ModelAttribute("enrollment") EnrollmentDTO enrollmentDTO) {
        enrollmentService.enrollStudent(enrollmentDTO);
        return "redirect:/success";
    }
}
