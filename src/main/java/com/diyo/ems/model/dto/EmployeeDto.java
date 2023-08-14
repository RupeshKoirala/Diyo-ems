package com.diyo.ems.model.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class EmployeeDto {
    private Long employeeId;
    private String fullName;
}
