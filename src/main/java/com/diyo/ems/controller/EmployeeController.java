package com.diyo.ems.controller;

import com.diyo.ems.entity.Employee;
import com.diyo.ems.exception.EmployeeNotFoundException;
import com.diyo.ems.model.dto.EmployeeDto;
import com.diyo.ems.repository.EmployeeRepository;
import com.diyo.ems.service.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    // Field injection
    /*@Autowired
    EmployeeService employeeService;*/

    @Value("${address}")
    private String addressFromPropFile;

    //Constructor injection
    private final EmployeeService empService;

    public EmployeeController(EmployeeService employeeService){
        this.empService = employeeService;
    }

    //http://localhost:8080/employees/welcome
    @GetMapping("/welcome")
    public String welcome() {
        return "Hello Students!";
    }

    //http://localhost:8080/employees/welcome/Rojal
    @GetMapping("/welcome/{name}")
    public String welcome1(@PathVariable("name") String fullName) {
        System.out.println(fullName);
        return "Hello "+fullName;
    }

    //http:localhost:8080/employees/salary/100/200
    @GetMapping("/salary/{salary1}/{salary2}")
    public String getTotalSalary(@PathVariable("salary1") Integer salary1, @PathVariable("salary2") Integer salary2){
        Integer totalSalary = salary1+salary2;
        return "Your total salary is "+totalSalary;
    }

    //http://localhost:8080/employees/salary?salary1=100&salary2=200
    @GetMapping("/salary")
    public String getTotalSalary1(@RequestParam("salary1") Integer s1, @RequestParam("salary2") Integer s2){
        Integer totalSalary = s1+s2;
        return "Total salary is "+totalSalary;
    }

    //http://localhost:8080/employees/login
    @PostMapping("/login")
    public String login(@RequestBody String username){
        return "Username is: "+username;
    }

    //http://localhost:8080/employees
    @PostMapping
    public String addEmployee(@Valid @RequestBody Employee emp){
        empService.addEmployee(emp);
        return "Employee saved successfully!";
    }

    @PostMapping("/bulk")
    public String registerEmployees(@RequestBody List<Employee> employees) {
        empService.addEmployeeList(employees);
        return "All employees saved successfully!";
    }

    @GetMapping
    public ResponseEntity<List<Employee>> getAllEmployees(){
        List<Employee> employees = empService.getAllEmployees();
        return ResponseEntity.ok().body(employees);
    }

    @GetMapping("/{empId}")
    public ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable("empId") Long employeeId) throws EmployeeNotFoundException {
        EmployeeDto employeeDto = empService.getEmployeeById(employeeId);
        return ResponseEntity.ok(employeeDto);
    }

    @DeleteMapping("/{empId}")
    public ResponseEntity<String> deleteEmployeeById(@PathVariable("empId") Long empId){
        empService.deleteEmployeeById(empId);
        return ResponseEntity.ok("Employee deleted successfully!");
    }

    @PutMapping
    public ResponseEntity<String> updateEmployeeById(@RequestBody Employee employee){
        String result = empService.updateEmployee(employee);
        return ResponseEntity.ok(result);
    }

    @PatchMapping
    public String patchByEmployeeId(@RequestBody Employee emp){
        String result = empService.patchByEmployeeId(emp);
        return result;
    }

    @GetMapping("/searchbysalary/{salary}")
    public List<Employee> searchEmployeeBySalary(@PathVariable Integer salary){
        System.err.println(addressFromPropFile);
        return empService.searchEmployeeBySalary(salary);
    }

    @GetMapping("/address")
    public ResponseEntity<String> getProfileAddress(){
        return ResponseEntity.ok(addressFromPropFile);
    }
}