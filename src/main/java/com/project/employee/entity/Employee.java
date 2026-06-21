package com.project.employee.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
@Table(name = "employees")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank(message = "Name is required")
    private String empname;

    public Employee() {}

    public Integer getId()                        { return id; }
    public void setId(Integer id)                 { this.id = id; }
    public String getEmpname()                    { return empname; }
    public void setEmpname(String empname)        { this.empname = empname; }
}