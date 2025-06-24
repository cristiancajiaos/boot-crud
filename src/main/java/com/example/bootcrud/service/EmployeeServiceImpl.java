package com.example.bootcrud.service;

import com.example.bootcrud.dto.EmployeeDto;
import com.example.bootcrud.entity.Employee;
import com.example.bootcrud.mapper.EmployeeMapper;
import com.example.bootcrud.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService {

  @Autowired
  private EmployeeRepository employeeRepository;

  @Override
  public EmployeeDto createEmployee(EmployeeDto employeeDto) {
    Employee employee = EmployeeMapper.mapToEmployee(employeeDto);
    Employee createdEmployee = employeeRepository.save(employee);
    return EmployeeMapper.mapToEmployeeDto(createdEmployee);
  }
}
