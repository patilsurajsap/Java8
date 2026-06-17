package org.example;

import com.java8.factory.StudentFactory;
import com.java8.model.Student;

import java.util.Arrays;
import java.util.Optional;
import java.util.StringJoiner;
import java.util.concurrent.atomic.AtomicReference;

public class StreamReduce {

    public static void main(String[] args) {

        StudentFactory studentFactory = new StudentFactory();
        Student s = new Student();


        Optional<Student> reduce = studentFactory.getStudentList().stream().reduce( ((student1, student2) -> {

            String s1 = student1.getName() + ":" + student2.getName();
            s.setName(s1);
            return s;
        }));

        System.out.println(reduce.get().getName());


        String str = "suraj anandrao patil";

        Arrays.asList(str.split(" ")).stream().reduce((s1, s2) -> {

            String s4 = s1.substring(0, 1).toUpperCase() + s1.substring(1) + " "+ s2.substring(0, 1).toUpperCase() + s2.substring(1);

            return s4;
        }).ifPresent(System.out::println);

        StringJoiner stringBuffer = new StringJoiner(" ");
        Arrays.asList(str.split(" ")).forEach(s1 -> {
           stringBuffer.add(s1.substring(0, 1).toUpperCase() + s1.substring(1));
        });

        System.out.println(stringBuffer.toString());

    }
    
}
