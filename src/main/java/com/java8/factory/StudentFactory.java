package com.java8.factory;

import com.java8.model.Student;

import java.util.ArrayList;
import java.util.List;

public class StudentFactory {

    private static List<Student> studentList;
    {
        System.out.println("Initializing student list...");
        studentList = new ArrayList<>();
        studentList.add(new Student(1, "John Doe", "Computer Science"));
        studentList.add(new Student(2, "Jane Smith", "Mathematics"));
        studentList.add(new Student(3, "Alice Johnson", "Physics"));
        studentList.add(new Student(4, "Suraj Patil", "Mathematics"));

    }

    public StudentFactory() {
    }

    public static Student createStudent(int id, String name, String specilization){
        return new Student(id, name,specilization);
    }

    public static List<Student> getStudentList(){
        return  studentList;
    }

    public static boolean addStudentToList(Student student){
        return studentList.add(student);
    }


}
