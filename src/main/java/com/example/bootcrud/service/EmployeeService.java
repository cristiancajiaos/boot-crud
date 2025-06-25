package com.example.bootcrud.service;

import com.example.bootcrud.dto.EmployeeDto;
import com.example.bootcrud.exception.EmployeeNotFoundException;

public interface EmployeeService {
  EmployeeDto createEmployee(EmployeeDto employeeDto);

  EmployeeDto getEmployeeById(Long employeeId) throws EmployeeNotFoundException;

}
