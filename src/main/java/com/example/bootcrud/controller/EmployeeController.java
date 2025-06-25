package com.example.bootcrud.controller;

import com.example.bootcrud.dto.EmployeeDto;
import com.example.bootcrud.exception.EmployeeNotFoundException;
import com.example.bootcrud.service.EmployeeService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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

  @GetMapping(value = "/employee/{employeeId}")
  public ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable("employeeId") Long employeeId)
      throws EmployeeNotFoundException {
    try {
      EmployeeDto employee = employeeService.getEmployeeById((employeeId));
      return new ResponseEntity<>(employee, HttpStatus.OK);
    } catch (EmployeeNotFoundException ex) {
      throw ex;
    }
  }

  @GetMapping(value = "/employees")
  public ResponseEntity<List<EmployeeDto>> getEmployees() {
    List<EmployeeDto> employees = employeeService.getEmployees();
    return new ResponseEntity<>(employees, HttpStatus.OK);
  }

  // @PutMapping(value = "/employee", consumes = {"application/json"})
  @PutMapping(value = "/employee")
  public ResponseEntity<EmployeeDto> updateEmployee(@RequestBody EmployeeDto employeeDto)
      throws EmployeeNotFoundException {
    try {
      EmployeeDto updatedEmployee = employeeService.updateEmployee(employeeDto);
      return new ResponseEntity<>(updatedEmployee, HttpStatus.OK);
    } catch (EmployeeNotFoundException ex) {
      throw ex;
    }
  }

  @DeleteMapping(value = "/employee/{employeeId}")
  public ResponseEntity<HttpStatus> deleteEmployee(@PathVariable("employeeId") Long employeeId)
      throws EmployeeNotFoundException {
    try {
      employeeService.deleteEmployee(employeeId);
      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    } catch (EmployeeNotFoundException employeeNotFoundException) {
      throw employeeNotFoundException;
    }
  }
}
