package com.example.streamapiandoptional.service;

import com.example.streamapiandoptional.domain.Employee;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {

    private final List<Employee> employees = new ArrayList<>();

    public void addTestData() {
        employees.add(new Employee("Иван", "Иванов", 50000, 1));
        employees.add(new Employee("Петр", "Петров", 60000, 1));
        employees.add(new Employee("Сидор", "Сидоров", 70000, 2));
        employees.add(new Employee("Анна", "Иванова", 55000, 2));
    }

    public List<Employee> getAllEmployees() {
        return employees;
    }
}