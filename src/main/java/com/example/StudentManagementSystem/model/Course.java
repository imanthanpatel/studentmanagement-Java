package com.example.StudentManagementSystem.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "courses")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(nullable = false)
    private String courseName;


    @Column(nullable = false,unique = true)
    private String courseCode;


    private String duration;

    @Column(name = "active",nullable = false)
    private boolean active;

    @Column(precision = 12,scale = 2,nullable = false)
    private BigDecimal fee;

    @Column(length = 1000)
    private String Description;

    @Column(nullable = false,updatable = false)

    private LocalDateTime createdAt;

    @PrePersist
    public void onCreate(){
        createdAt=LocalDateTime.now();
    }
}
