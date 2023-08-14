package com.diyo.ems.service;

import com.diyo.ems.entity.Company;
import com.diyo.ems.repository.CompanyRepository;
import org.springframework.stereotype.Service;

@Service
public class CompanyService {
    private final CompanyRepository companyRepository;

    public CompanyService(CompanyRepository companyRepository){
        this.companyRepository = companyRepository;
    }
    public void addCompany(Company company){
        //business logic
        /*company.getEmployees().forEach(employee -> {
            employeeRepository.findbYEmail(employee.getEmail())
        });
        //new emplist.add();
        company.setEmployees(newemplist);*/
        companyRepository.save(company);
    }
}
