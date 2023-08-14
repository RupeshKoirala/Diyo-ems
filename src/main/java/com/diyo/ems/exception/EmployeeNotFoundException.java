package com.diyo.ems.exception;

public class EmployeeNotFoundException extends Exception{
    public EmployeeNotFoundException(String errorMessage) {
        super(errorMessage);
    }
}
