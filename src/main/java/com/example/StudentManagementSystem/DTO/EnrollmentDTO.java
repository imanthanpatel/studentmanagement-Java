package com.example.StudentManagementSystem.DTO;

import lombok.Data;
import java.util.List;
import java.math.BigDecimal;

@Data
public class EnrollmentDTO {
    private Long studentId;
    private List<Long> courseIds;
    private BigDecimal totalFee;
}
