package org.example;

public class StreamReduceFindMax {

    public static void main(String[] args) {

         int arr[] = {1, 2, 8, 4, 5};

         int max = java.util.Arrays.stream(arr).reduce(Integer.MIN_VALUE, (a, b) -> a > b ? a : b);

        System.out.println(max);
    }
}
