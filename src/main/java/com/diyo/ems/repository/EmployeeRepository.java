package com.diyo.ems.repository;

import com.diyo.ems.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    @Query(value = "select * from diyoemployee where salary > :sal", nativeQuery = true)
    public List<Employee> searchEmployeeBySalary(Integer sal);

    /*@Query(value = "select * from diyoemployee where salary > :salary and department = :dept", nativeQuery = true)
    public List<Employee> searchEmployeeBySalaryAndDepartment(Integer salary, String dept);*/

    //Query Methods
    public List<Employee> findByFullNameAndAddress(String f, String a); // select * from diyoemployee where full_name=f and address=a;

    public List<Employee> findEmployeeBySalaryGreaterThan(Integer sal); // select * from diyoemployee where salary > sal
}
