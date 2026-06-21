package com.project.employee.service;

import com.project.employee.dto.EmployeeRequestDTO;
import com.project.employee.dto.EmployeeResponseDTO;
import com.project.employee.entity.Employee;
import com.project.employee.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EmployeeService {

    @Autowired
    EmployeeRepository repo;

    // Entity → ResponseDTO
    private EmployeeResponseDTO toDTO(Employee emp) {
        return new EmployeeResponseDTO(emp.getId(), emp.getEmpname());
    }

    // RequestDTO → Entity
    private Employee toEntity(EmployeeRequestDTO dto) {
        Employee emp = new Employee();
        emp.setEmpname(dto.getEmpname());
        return emp;
    }

    public EmployeeResponseDTO addEmployee(EmployeeRequestDTO dto) {
        return toDTO(repo.save(toEntity(dto)));
    }

    public List<EmployeeResponseDTO> getAllEmployees() {
        return repo.findAll()
                   .stream()
                   .map(this::toDTO)
                   .collect(Collectors.toList());
    }

    public Optional<EmployeeResponseDTO> getById(int id) {
        return repo.findById(id).map(this::toDTO);
    }

    public Optional<EmployeeResponseDTO> updateEmployee(int id, EmployeeRequestDTO dto) {
        return repo.findById(id).map(existing -> {
            existing.setEmpname(dto.getEmpname());
            return toDTO(repo.save(existing));
        });
    }

    public boolean deleteEmployee(int id) {
        if (repo.existsById(id)) {
            repo.deleteById(id);
            return true;
        }
        return false;
    }
}