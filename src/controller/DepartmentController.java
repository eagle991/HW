package com.example.streamapiandoptional.controller;

import com.example.streamapiandoptional.domain.Employee;
import com.example.streamapiandoptional.service.DepartmentService;
import com.example.streamapiandoptional.service.EmployeeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/departments")
public class DepartmentController {

    private final DepartmentService departmentService;
    private final EmployeeService employeeService;

    public DepartmentController(DepartmentService departmentService, EmployeeService employeeService) {
        this.departmentService = departmentService;
        this.employeeService = employeeService;
    }

    @GetMapping("/add-data")
    public void addTestData() {
        employeeService.addTestData();
    }

    @GetMapping("/max-salary")
    public Employee getEmployeeWithMaxSalaryByDepartment(@RequestParam("departmentId") int departmentId) {
        return departmentService.getEmployeeWithMaxSalaryByDepartment(departmentId);
    }

    @GetMapping("/min-salary")
    public Employee getEmployeeWithMinSalaryByDepartment(@RequestParam("departmentId") int departmentId) {
        return departmentService.getEmployeeWithMinSalaryByDepartment(departmentId);
    }

    @GetMapping("/all")
    public Map<Integer, List<Employee>> getAllEmployeesByDepartment(
            @RequestParam(value = "departmentId", required = false) Integer departmentId) {
        if (departmentId == null) {
            return departmentService.getAllEmployeesGroupedByDepartment();
        }
        return Map.of(departmentId, departmentService.getAllEmployeesByDepartment(departmentId));
    }
}

