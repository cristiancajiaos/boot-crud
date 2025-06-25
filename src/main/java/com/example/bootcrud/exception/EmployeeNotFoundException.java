package com.example.bootcrud.exception;

public class EmployeeNotFoundException extends Exception{
  private static final long serialVersionUID = 1;

  public EmployeeNotFoundException() {
  }

  public EmployeeNotFoundException(String message) {
    super(message);
  }
}
