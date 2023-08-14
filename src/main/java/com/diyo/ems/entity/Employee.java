package com.diyo.ems.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "diyoemployee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "empid")
    private Long employeeId;
    @NotBlank(message = "Please provide employee fullname")
    private String fullName;
    private String address;
    @Email(message = "Please provide valid email address")
    private String email;
    @Min(value=1, message = "Salary cannot be less than 1.")
    private Double salary;
    //@Transient
    private String phone;
    //@Transient
    private String title;
    /*@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "company_id", referencedColumnName = "companyId")
    private Company company;*/
}
