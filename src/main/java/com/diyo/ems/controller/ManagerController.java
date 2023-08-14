package com.diyo.ems.controller;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ManagerController {

    @Operation(summary = "Get welcome message from manager")
    @GetMapping("/manager")
    public String welcomeEmployees(){
        return "Hello from manager";
    }
}
