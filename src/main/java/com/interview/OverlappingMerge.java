package com.interview;

import java.util.*;
import java.util.stream.Collectors;

public class OverlappingMerge {

    //Input: [[1,3],[2,6],[8,10]]
    // Output: [[1,6],[8,10]]
    public static void main(String[] args) {

        int[][] arr = {{1,3},{2,6},{8,10}};


        Set<int[]> resultList =  new LinkedHashSet<>();
        Optional<int[]> reduce = Arrays.asList(arr).stream().reduce((arr1, arr2) -> {

            int result[] = new int[2];
            if (arr1[1] > arr2[0]) {
                result[0] = arr1[0];
                result[1] = arr2[1];
                resultList.add(result);
            }
            else{
                resultList.add(arr1);
                resultList.add(arr2);
            }

            return result;
        });

        System.out.println();
    }
}
