package com.dcb.springbootdemo.service;

import com.dcb.springbootdemo.model.Employee;

import java.util.List;

public interface EmployeeService {
    Employee saveEmp(Employee emp);

    List<Employee> getAllEmployee();

    Employee getEmployeeById(String id);

    String deleteById(String id);
}
