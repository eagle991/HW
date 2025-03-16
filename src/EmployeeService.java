package com.example.service;

import com.example.model.Employee;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {
    private final List<Employee> employees = new ArrayList<>();

    public List<Employee> getAllEmployees() {
        return employees;
    }

    public void addEmployee(Employee employee) {
        employees.add(employee);
    }

    public void removeEmployee(Employee employee) {
        employees.remove(employee);
    }

    public Employee findEmployee(String firstName, String lastName) {
        return employees.stream()
                .filter(e -> e.getFirstName().equals(firstName) && e.getLastName().equals(lastName))
                .findFirst()
                .orElse(null);
    }
}