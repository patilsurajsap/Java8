package org.example;

import com.java8.model.Student;

import java.util.HashMap;

public class HashMapKey {

    public static void main(String[] args) {
        HashMap<Student, String> studentHashMap = new HashMap<>();

        Student student1 = new Student(10,"John", "Mathematics");
        Student student2 = new Student(11, "Suraj",  "English");
        Student student3 = new Student(12, "Akshay",  "Marathi");

        studentHashMap.put(student1, "Student 1");
        studentHashMap.put(student2, "Student 2");
        studentHashMap.put(student3, "Student 3");

        System.out.println(studentHashMap.get(student1));

        student1.setName("Sandesh");

        System.out.println(studentHashMap.get(student1));

        System.out.println(studentHashMap);


        studentHashMap.keySet().stream().forEach(student -> System.out.println(student.getName()));

    }
}
