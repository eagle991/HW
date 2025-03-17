package com.example.service;

import com.example.model.Employee;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeServiceTest {
    private EmployeeService employeeService;

    @BeforeEach
    void setUp() {
        employeeService = new EmployeeService();
    }

    @Test
    void testAddEmployee() {
        Employee employee = new Employee("John", "Doe", 1, 50000);
        employeeService.addEmployee(employee);
        assertEquals(1, employeeService.getAllEmployees().size());
    }

    @Test
    void testRemoveEmployee() {
        Employee employee = new Employee("John", "Doe", 1, 50000);
        employeeService.addEmployee(employee);
        employeeService.removeEmployee(employee);
        assertEquals(0, employeeService.getAllEmployees().size());
    }

    @Test
    void testFindEmployee() {
        Employee employee = new Employee("John", "Doe", 1, 50000);
        employeeService.addEmployee(employee);
        Employee found = employeeService.findEmployee("John", "Doe");
        assertNotNull(found);
        assertEquals("John", found.getFirstName());
    }
}