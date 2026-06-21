package com.project.employee.dto;

import jakarta.validation.constraints.NotBlank;

public class EmployeeRequestDTO {

    @NotBlank(message = "Name is required")
    private String empname;

    public String getEmpname()             { return empname; }
    public void setEmpname(String empname) { this.empname = empname; }
}