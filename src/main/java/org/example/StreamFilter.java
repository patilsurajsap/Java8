package org.example;

import com.java8.factory.StudentFactory;
import com.java8.model.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class StreamFilter {

    public StreamFilter() {
    }

    public static void main(String[] args) {
        StudentFactory studentFactory = new StudentFactory();
        List<Student> studentList = StudentFactory.getStudentList();


        studentList.stream().filter(student -> student.getSpecilization().equals("Mathematics"))
                .forEach(student -> System.out.println(student.getName()));


        Predicate<Student> predicate =  student -> student.getSpecilization().equals("Mathematics");

            studentList.stream().filter(predicate)
                    .forEach(student -> System.out.println(student.getName()));

        List<String> names = new ArrayList<>();

        for(Student student : studentList){
            if(student.getSpecilization().equals("Mathematics")){
                names.add(student.getName());
            }
        }

            names.forEach(name -> System.out.println(name));
    }
}
