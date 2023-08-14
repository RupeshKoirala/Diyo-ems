package com.diyo.ems.exception;

import com.diyo.ems.model.ValidationErrorResponse;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<List<ValidationErrorResponse>> handleMethodArgurmentNotValidException(MethodArgumentNotValidException e){
        List<ValidationErrorResponse> errorList = new ArrayList<>();
        e.getBindingResult().getFieldErrors().forEach(fieldError -> {
            ValidationErrorResponse validationErrorResponse = new ValidationErrorResponse(fieldError.getField(), fieldError.getDefaultMessage());
            errorList.add(validationErrorResponse);
        });
        //return ResponseEntity.internalServerError().body(errorList);
        return new ResponseEntity<>(errorList, HttpStatus.OK);
    }

    @ExceptionHandler({NullPointerException.class, ArithmeticException.class})
    public String handleNullPointerException(){
        return "";
    }

    @ExceptionHandler(ArrayIndexOutOfBoundsException.class)
    public String handleArrayIndexOutOfBoundException(ArrayIndexOutOfBoundsException ex){
        return ex.getMessage()+"-global exception handler";
    }

    @ExceptionHandler(EmployeeNotFoundException.class)
    public String handleEmployeeNotFoundException(EmployeeNotFoundException e){
        e.printStackTrace();
        return e.getMessage();
    }
}
