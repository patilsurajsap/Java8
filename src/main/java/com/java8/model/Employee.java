package com.java8.model;

import lombok.*;

@AllArgsConstructor
@Data
@NoArgsConstructor
@Getter
@Setter
public class Employee {
    private String name;
    private String department;
    private double salary;
    private int age;



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }


/* public Employee(String david, String hr, int i, int i1) {
        this.name = david;
        this.department = hr;
        this.salary = i;
        this.age = i1;
    }*/

    // Constructors, Getters, and Overridden toString() omitted for brevity
}