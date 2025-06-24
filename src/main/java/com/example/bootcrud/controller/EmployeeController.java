package com.example.bootcrud.controller;

import com.example.bootcrud.dto.EmployeeDto;
import com.example.bootcrud.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {
  @Autowired
  private EmployeeService employeeService;

  @PostMapping(value = "/employee")
  public ResponseEntity<EmployeeDto> createEmployee(@RequestBody EmployeeDto employeeDto) {
    EmployeeDto createdEmployee = employeeService.createEmployee(employeeDto);
    return new ResponseEntity<>(createdEmployee, HttpStatus.CREATED);
  }
}
