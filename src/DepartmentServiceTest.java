package com.example.service;

import com.example.model.Employee;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

class DepartmentServiceTest {
    @Mock
    private EmployeeService employeeService;

    @InjectMocks
    private DepartmentService departmentService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetEmployeesByDepartment() {
        when(employeeService.getAllEmployees()).thenReturn(Arrays.asList(
                new Employee("John", "Doe", 1, 50000),
                new Employee("Jane", "Doe", 1, 60000)
        ));

        List<Employee> employees = departmentService.getEmployeesByDepartment(1);
        assertEquals(2, employees.size());
    }

    @Test
    void testGetSumSalaryByDepartment() {
        when(employeeService.getAllEmployees()).thenReturn(Arrays.asList(
                new Employee("John", "Doe", 1, 50000),
                new Employee("Jane", "Doe", 1, 60000)
        ));

        double sum = departmentService.getSumSalaryByDepartment(1);
        assertEquals(110000, sum);
    }

    @Test
    void testGetEmployeesGroupedByDepartment() {
        when(employeeService.getAllEmployees()).thenReturn(Arrays.asList(
                new Employee("John", "Doe", 1, 50000),
                new Employee("Jane", "Doe", 2, 60000)
        ));

        Map<Integer, List<Employee>> grouped = departmentService.getEmployeesGroupedByDepartment();
        assertEquals(2, grouped.size());
    }
}