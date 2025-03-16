package com.example.service;

import com.example.model.Employee;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class DepartmentService {
    private final EmployeeService employeeService;

    public DepartmentService(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    public List<Employee> getEmployeesByDepartment(int department) {
        return employeeService.getAllEmployees().stream()
                .filter(e -> e.getDepartment() == department)
                .collect(Collectors.toList());
    }

    public double getSumSalaryByDepartment(int department) {
        return employeeService.getAllEmployees().stream()
                .filter(e -> e.getDepartment() == department)
                .mapToDouble(Employee::getSalary)
                .sum();
    }

    public double getMaxSalaryByDepartment(int department) {
        return employeeService.getAllEmployees().stream()
                .filter(e -> e.getDepartment() == department)
                .mapToDouble(Employee::getSalary)
                .max()
                .orElse(0);
    }

    public double getMinSalaryByDepartment(int department) {
        return employeeService.getAllEmployees().stream()
                .filter(e -> e.getDepartment() == department)
                .mapToDouble(Employee::getSalary)
                .min()
                .orElse(0);
    }

    public Map<Integer, List<Employee>> getEmployeesGroupedByDepartment() {
        return employeeService.getAllEmployees().stream()
                .collect(Collectors.groupingBy(Employee::getDepartment));
    }
}