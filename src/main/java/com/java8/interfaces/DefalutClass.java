package com.java8.interfaces;

public class DefalutClass implements InterfaceOne, InterfaceTwo {


    @Override
    public void printText() {
        InterfaceOne.super.printText();
    }
}
