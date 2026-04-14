package org.example;

import com.java8.factory.StudentFactory;

import java.util.List;
import java.util.stream.Collectors;

public class StreamMapAndFlatMap {

    public static void main(String[] args) {

        StudentFactory studentFactory = new StudentFactory();
        //map
        List<String> collect = StudentFactory.getStudentList().stream().map(student -> student.getName())
                .collect(Collectors.toUnmodifiableList());

        System.out.println("Suraj");





    }
}
