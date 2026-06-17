package com.java8.interfaces;

public interface InterfaceTwo {

    default void printText()   {
        System.out.println("This is a default method in InterfaceTwo");
    }
}