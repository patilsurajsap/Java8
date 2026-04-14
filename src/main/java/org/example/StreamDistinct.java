package org.example;

import com.java8.factory.StudentFactory;

// distinct internally used equals and hashcode method to compare the objects and remove the duplicates
public class StreamDistinct {

    static StudentFactory studentFactory = new StudentFactory();
    public static void main(String[] args) {
        studentFactory.getStudentList().stream().distinct().forEach(student -> System.out.println(student.getName()));
    }
}
