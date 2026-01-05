package com.example.StudentManagementSystem.DTO;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;


@Getter
@Setter
public class CourseDTO {


    private Long id;
    @NotBlank(message = "CourseName is recquired")
    @Size(max = 150,message = "Max 150 Char allowed")
    private String courseName;
    @NotBlank(message = "CourseCode is recquired")
    private String courseCode;
    @NotBlank(message = "Course description is recquired")
    private String duration;
    private boolean active;
    @NotNull(message = "Course fee is recquired")
    private BigDecimal fee;
    @NotBlank(message = "Description is recquired")
    @Size(max = 500,message = "Max 500 Char allowed")
    private String description;

}
