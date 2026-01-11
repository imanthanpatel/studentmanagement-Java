package com.example.StudentManagementSystem.DTO;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StudentDTO {

    private Long id;

    @NotBlank(message = "Enter FullName")
    @Size(max = 150,message = "150 Char are allowed max")
    private String firstName;
    @NotBlank(message = "Enter FullName")
    @Size(max = 150,message = "150 Char are allowed max")
    private String lastName;

    @NotBlank(message = "Enter Valid Email")
    @Size(max = 150,message = "150 Char allowed ")
    private String email;

    @NotBlank(message = "Enter Contact No")
    @Size(max = 10,message = "10 Numbers are allowed ")
    private String phone;

    private boolean active = true;
    private String address;

}
