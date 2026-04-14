package com.java8.model;

import java.util.Objects;

public class Student {

    int id;
    String name;
    String specilization;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpecilization() {
        return specilization;
    }

    public void setSpecilization(String specilization) {
        this.specilization = specilization;
    }

    public Student(int id, String name, String specilization) {
        this.id = id;
        this.name = name;
        this.specilization = specilization;
    }

    public Student() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return id == student.id && Objects.equals(name, student.name) && Objects.equals(specilization, student.specilization);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, specilization);
    }
}
