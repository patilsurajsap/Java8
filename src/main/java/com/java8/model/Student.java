package com.java8.model;

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
}
