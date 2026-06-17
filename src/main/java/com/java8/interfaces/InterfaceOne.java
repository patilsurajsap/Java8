package com.java8.interfaces;


public interface InterfaceOne {

    default void printText()   {
        System.out.println("This is a default method in InterfaceOne");
    }
}
