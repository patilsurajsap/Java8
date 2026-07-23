package org.example;

import java.util.Arrays;
import java.util.OptionalInt;

public class StreamReduceFindMax {

    public static void main(String[] args) {

         int arr[] = {1, 2, 8, 4, 5};

         int max = java.util.Arrays.stream(arr).reduce(Integer.MIN_VALUE, (a, b) -> a > b ? a : b);

        OptionalInt min = Arrays.stream(arr).reduce( (a, b) -> a < b ? a : b);

        OptionalInt min1 = Arrays.stream(arr).min();

        System.out.println(max + ":" + min.getAsInt() + ":" + min1.getAsInt());
    }
}
