package com.diyo.ems.controller;

import com.diyo.ems.entity.Company;
import com.diyo.ems.model.Project;
import com.diyo.ems.service.CompanyService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/companies")
public class CompanyController {

    private final CompanyService companyService;

    @Autowired
    private Project project;

    public CompanyController(CompanyService companyService){
        this.companyService = companyService;
    }
    @Operation(summary = "API to save new company details")
    @PostMapping
    public void addCompany(@RequestBody Company company){
        companyService.addCompany(company);
    }

    @GetMapping("/project")
    public void getProjectDetails(){
        project.display();
    }
}
