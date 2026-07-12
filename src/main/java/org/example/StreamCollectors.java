package org.example;

import com.java8.factory.StudentFactory;
import com.java8.model.Employee;
import com.java8.model.Student;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamCollectors {

    static StudentFactory studentFactory = new StudentFactory();

    public static void main(String[] args) {

        //////// toMap() method
        // toMap method collects data into key value pair and store in map,
        // it takes two function as argument, first one is for key and second one is for value

        System.out.println("=====");
        System.out.println(studentFactory.getStudentList().stream().collect(Collectors
                .toMap((student)->{
                    return  student.getId();
                }, (student -> {
                    return student.getSpecilization();
                }))));
        System.out.println("=====");


        // toCollection() method
        // toCollection method collects data into a collection, it takes supplier as argument which is used
        LinkedHashSet<Student> collect = StudentFactory.getStudentList().stream().
                collect(Collectors.toCollection(() -> {
                    return new LinkedHashSet<>();
                }));

        //System.out.println(collect);

        LinkedHashSet<String> collect1 = StudentFactory.getStudentList().stream().map(Student::getName).
                collect(Collectors.toCollection(() -> {
                    return new LinkedHashSet<>();
                }));

        // System.out.println(collect1);


        ///// Collectors.groupingBy() method
        // groupingBy method is used to group data based on some criteria, it takes function as argument which is used to group data

        Map<String, Long> collect2 = StudentFactory.getStudentList().stream().
                collect(Collectors.groupingBy(Student::getSpecilization, Collectors.counting()));

        System.out.println("==================Grouping By=====================");
        System.out.println(collect2);

        Map<String, List<Student>> collect4 = StudentFactory.getStudentList().
                stream().collect(Collectors.groupingBy(Student::getSpecilization, Collectors.toList()));
        System.out.println(collect4);
        //// Collectors.partitioningBy() method
        // partitioningBy method is used to partition data based on some criteria, it takes predicate as argument which is used to partition data

        Map<Boolean, Long> collect3 = StudentFactory.getStudentList().stream().
                collect(Collectors.partitioningBy
                        (student -> student.getSpecilization().equals("Mathematics"), Collectors.counting()));

        System.out.println("==================Partitioning By=====================");
        System.out.println(collect3);


        Map<Boolean, List<Student>> mathematics = StudentFactory.getStudentList().stream().
                collect(Collectors.partitioningBy
                        (student -> student.getSpecilization().equals("Mathematics"), Collectors.toList()));

        System.out.println(mathematics);

        System.out.println("================== Averaging =====================");

        double avaerage = StudentFactory.getStudentList().stream().collect(Collectors.averagingInt(Student::getId)
                ).doubleValue();
        System.out.println("average :: " + avaerage);




        //---------------------- Employee List ------------------

        List<Employee> employees = Arrays.asList(
                new Employee("Alice", "IT", 120000, 30),
                new Employee("Bob", "IT", 95000, 26),
                new Employee("Charlie", "HR", 70000, 45),
                new Employee("David", "HR", 80000, 35),
                new Employee("Eve", "Finance", 140000, 40)
        );

        // group empoyee names by department
        Map<String, List<String>> employeeNamesByDepartment = employees.stream().collect(Collectors.groupingBy(Employee::getDepartment,
                Collectors.mapping(Employee::getName, Collectors.toList())));
        System.out.println("============================= Employee Names by Department =============================");
        System.out.println("Employee Names by Department: " + employeeNamesByDepartment);


        Map<String, Optional<Employee>> collect5 = employees.stream().collect(Collectors.groupingBy(
                emp -> emp.getDepartment(),
                Collectors.maxBy(Comparator.comparing(Employee::getSalary)))
        );
        System.out.println("Employee Names by Department: " + collect5);



        //============Collectors.joining() method
        // this returns only string/charsequence array object

        String collect6 = employees.stream().map(emp -> {
            return emp.getName();
        }).collect(Collectors.joining("|", "[", "]"));

        System.out.println("============================= Joining Employee Names =============================");
        System.out.println("Joined Employee Names: " + collect6);


        Employee employee = employees.stream().sorted(Comparator.comparing(Employee::getSalary).reversed()).skip(1).findFirst().get();
        System.out.println("Employee with second highest salary: " + employee.getName() + " - " + employee.getSalary());


        String tt = "erwe";
        Stream.of(tt.split("")).collect(Collectors.groupingBy(s -> s, Collectors.counting()))
                .entrySet().stream().filter(entry -> entry.getValue() > 1).forEach(entry -> System.out.println(entry.getKey() + " : " + entry.getValue()));
    }
}
