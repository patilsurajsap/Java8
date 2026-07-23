package com.optional;

import com.java8.model.Employee;

import java.util.Optional;

public class OptionalDemo {

    public static void main(String[] args) {

        Employee employee = new Employee();
        employee.setName("Suraj");
        employee.setAge(36);
        employee.setSalary(100);
        employee.setDepartment("IT");


        Optional<Employee> employee2 = Optional.ofNullable(employee).filter(employee1 -> employee.getSalary() > 200);

       employee2.ifPresent(employeeq -> System.out.println(employeeq));

    }
}
