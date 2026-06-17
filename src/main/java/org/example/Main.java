package org.example;


import java.util.Arrays;
import java.util.OptionalInt;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        int sum = Arrays.stream(new int[] {7, 5, 9, 2, 8, 1}).reduce(0, (a, b) -> a+b);
        System.out.println(sum);


        OptionalInt g = Arrays.stream(new int[] {7, 5, 9, 2, 8, 1}).reduce( (a, b) ->

        {
            return  a<b?a:b;
        });
        System.out.println(g.getAsInt());


        int count = Arrays.stream(new int[] {5,7, 5, 9, 2, 8, 1}).reduce(0, (a, b) ->

        {
            return  a;
        });
        System.out.println(count);


    }

}