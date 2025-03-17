package com.example.model;

public class Employee {
    private String firstName;
    private String lastName;
    private int department;
    private double salary;

    // Конструктор, геттеры и сеттеры
    public Employee(String firstName, String lastName, int department, double salary) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.department = department;
        this.salary = salary;
    }

    // Геттеры и сеттеры
    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getDepartment() {
        return department;
    }

    public double getSalary() {
        return salary;
    }
}