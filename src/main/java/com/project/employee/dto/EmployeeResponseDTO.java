package com.project.employee.dto;

public class EmployeeResponseDTO {

    private Integer id;
    private String empname;

    public EmployeeResponseDTO() {}

    public EmployeeResponseDTO(Integer id, String empname) {
        this.id = id;
        this.empname = empname;
    }

    public Integer getId()                 { return id; }
    public void setId(Integer id)          { this.id = id; }
    public String getEmpname()             { return empname; }
    public void setEmpname(String empname) { this.empname = empname; }
}