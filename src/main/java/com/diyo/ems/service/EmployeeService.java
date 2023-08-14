package com.diyo.ems.service;

import com.diyo.ems.entity.Employee;
import com.diyo.ems.exception.EmployeeNotFoundException;
import com.diyo.ems.model.dto.EmployeeDto;
import com.diyo.ems.repository.EmployeeRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {


    /*@Autowired
    EmployeeRepository employeeRepository;*/

    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository){
        this.employeeRepository = employeeRepository;
    }

    public void addEmployee(Employee employee){
        employeeRepository.save(employee); // this inserts employee data into diyoemployee table
    }

    public List<Employee> getAllEmployees(){
        List<Employee> employees = employeeRepository.findAll();
        return employees;
    }

    public void addEmployeeList(List<Employee> employees){
        employeeRepository.saveAll(employees);
    }

    public EmployeeDto getEmployeeById(Long employeeId) throws EmployeeNotFoundException {
        Optional<Employee> employeeOptional = employeeRepository.findById(employeeId);
        if(employeeOptional.isPresent()) {
            //return employeeOptional.get();
            Employee emp = employeeOptional.get();
            EmployeeDto employeeDto = EmployeeDto.builder().build();
            /*return EmployeeDto.builder()
                    .employeeId(emp.getEmployeeId())
                    .fullName(emp.getFullName())
                    .build();*/
            BeanUtils.copyProperties(emp, employeeDto);
            // You can use ObjectMapper as well, do research on your own.
            return employeeDto;
        } else {
            throw new EmployeeNotFoundException("Employee having id "+employeeId+" not found!");
        }
    }

    public void deleteEmployeeById(Long employeeId){
        employeeRepository.deleteById(employeeId);
    }

    public String updateEmployee(Employee employee){
        Optional<Employee> employeeOptional = employeeRepository.findById(employee.getEmployeeId());
        if(employeeOptional.isPresent()){
            // If employee exists
            employeeRepository.save(employee);
            return "Employee updated successfully!";
        } else {
            return "Employee "+employee.getEmployeeId()+ " does not exist!";
        }
    }

    public String patchByEmployeeId(Employee emp) {
        Optional<Employee> employeeOptional = employeeRepository.findById(emp.getEmployeeId());
        if(employeeOptional.isPresent()){
            //Employee exists
            Employee existingEmployeeData = employeeOptional.get();
            if(emp.getFullName() != null) {
                existingEmployeeData.setFullName(emp.getFullName());
            }
            if(emp.getAddress() != null) {
                existingEmployeeData.setAddress(emp.getAddress());
            }
            if(emp.getEmail() != null) {
                existingEmployeeData.setEmail(emp.getEmail());
            }
            if(emp.getPhone() != null) {
                existingEmployeeData.setPhone(emp.getPhone());
            }
            if(emp.getTitle() != null) {
                existingEmployeeData.setTitle(emp.getTitle());
            }
            if(emp.getSalary() != null) {
                existingEmployeeData.setSalary(emp.getSalary());
            }
            /*if(emp.getCompany() != null) {
                existingEmployeeData.setCompany(emp.getCompany());
            }*/
            employeeRepository.save(existingEmployeeData);
            return "Employee updated partially!";
        } else {
            return "Employee "+emp.getEmployeeId()+" does not exist";
        }
    }

    public List<Employee> searchEmployeeBySalary(Integer salary) {
        return employeeRepository.findEmployeeBySalaryGreaterThan(salary);
    }
}
