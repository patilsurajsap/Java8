package org.example;

import com.java8.factory.StudentFactory;
import com.java8.model.Student;

import java.util.LinkedHashSet;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class StreamCollectors {

    static StudentFactory studentFactory = new StudentFactory();
    public static void main(String[] args) {

        //////// toMap() method
        // toMap method collects data into key value pair and store in map,
        // it takes two function as argument, first one is for key and second one is for value

        System.out.println(studentFactory.getStudentList().stream().collect(Collectors
                .toMap((student)->{
                    return  student.getId();
                }, (student -> {
                    return student.getSpecilization();
                }))));


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

    }
}
