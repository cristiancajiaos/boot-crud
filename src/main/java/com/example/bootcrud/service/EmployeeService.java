package com.example.bootcrud.service;

import com.example.bootcrud.dto.EmployeeDto;
import com.example.bootcrud.exception.EmployeeNotFoundException;
import java.util.List;

public interface EmployeeService {
  EmployeeDto createEmployee(EmployeeDto employeeDto);

  EmployeeDto getEmployeeById(Long employeeId) throws EmployeeNotFoundException;

  List<EmployeeDto> getEmployees();

}
