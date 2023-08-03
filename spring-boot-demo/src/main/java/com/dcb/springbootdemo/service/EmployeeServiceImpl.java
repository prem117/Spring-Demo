package com.dcb.springbootdemo.service;

import com.dcb.springbootdemo.error.EmployeeNotFoundException;
import com.dcb.springbootdemo.model.Employee;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class EmployeeServiceImpl implements EmployeeService{
    List<Employee> employees=new ArrayList<>();
    @Override
    public Employee saveEmp(Employee emp) {
        if(emp.getEmployeeId()==null || emp.getEmployeeId().isEmpty()){
            emp.setEmployeeId(UUID.randomUUID().toString());
        }
        employees.add(emp);
        return emp;
    }

    @Override
    public List<Employee> getAllEmployee() {
        return employees;
    }



    @Override
    public Employee getEmployeeById(String id) {
        Employee e= employees.stream().filter(employee -> employee.getEmployeeId().equals(id))
                .findFirst().orElseThrow(()->new EmployeeNotFoundException("Record not found with id="+id));
        return e;
    }

    @Override
    public String deleteById(String id) {
       Employee emp=employees.stream().filter(e->e.getEmployeeId().equals(id))
               .findFirst()
               .get();
       employees.remove(emp);
       return id+"Employee  deleted successfully";
    }
}
