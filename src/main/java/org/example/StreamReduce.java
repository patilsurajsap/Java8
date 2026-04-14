package org.example;

import com.java8.factory.StudentFactory;
import com.java8.model.Student;

import java.util.Optional;

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

    }
    
}
