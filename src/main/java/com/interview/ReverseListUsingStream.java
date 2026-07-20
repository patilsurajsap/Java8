package com.interview;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class ReverseListUsingStream {

    public static void main(String[] args) {
        List<String> ll= Arrays.stream(Arrays.asList("suraj", "patil", "kolhpaur", "mh")
                .stream().reduce((s1, s2) -> {
                    return s2 + ":" + s1;
                }).get().split(":")).toList();

        System.out.println();
    }
}
