package com.diyo.ems.model;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ValidationErrorResponse {
    private String fieldName;
    private String errorMessage;
}
