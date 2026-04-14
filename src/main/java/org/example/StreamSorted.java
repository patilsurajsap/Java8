package org.example;

import com.java8.factory.StudentFactory;

public class StreamSorted {


    StudentFactory studentFactory = new StudentFactory();

    public static void main(String[] args) {
            StudentFactory studentFactory = new StudentFactory();

            studentFactory.getStudentList().stream().sorted((s1, s2) -> s2.getName().compareTo(s1.getName()))
                    .forEach(student -> System.out.println(student.getName()));

       System.out.println("==================================");

        studentFactory.getStudentList().stream().sorted((s1, s2) -> s1.getName().length() - s2.getName().length())
                .forEach(student -> System.out.println(student.getName()));
    }
}
