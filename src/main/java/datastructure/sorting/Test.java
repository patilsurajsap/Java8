package datastructure.sorting;


import java.util.*;

import java.util.LinkedHashMap;

import java.util.LinkedHashMap;
import java.util.Map;

 class DirectLRUCache<K, V> extends LinkedHashMap<K, V> {
    private final int capacity;

    public DirectLRUCache(int capacity) {
        // Calls the super constructor with accessOrder set to true
        super(capacity, 0.75f, true);
        this.capacity = capacity;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        return size() > this.capacity;
    }
}


 class LRUCache<K, V> {
    private final int capacity;
    private final LinkedHashMap<K, V> map;

    public LRUCache(int capacity) {
        this.capacity = capacity;

        // 1. Initial capacity
        // 2. Load factor (0.75 is default)
        // 3. accessOrder = true (Crucial for LRU: reorders elements on get/put)
        this.map = new LinkedHashMap<K, V>(capacity, 0.75f, true) {
            @Override
            protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
                // Evicts the least recently used element when size exceeds capacity
                return size() > LRUCache.this.capacity;
            }
        };
    }

    public V get(K key) {
        // Automatically moves the accessed key to the end of the list
        return map.getOrDefault(key, null);
    }

    public void put(K key, V value) {
        map.put(key, value);
    }

    // For debugging/printing the current cache state
    public void display() {
        System.out.println(map);
    }
}


public class Test {

    public static void main(String[] args) {
        int[] arr = {6,5,2,8,3,7};
        //test(arr);
       //
       //
        //printArr(arr);

        DirectLRUCache<Integer,String> map = new DirectLRUCache<>(3);
        map.put(1, "Suraj");
        map.put(2, "Ramesh");
        map.put(3, "Suresh");

        System.out.println(map.get(1));

        map.put(4, "Sagar Kumar");



        System.out.println();

        PriorityQueue<Integer>   pq = new PriorityQueue<>(Collections.reverseOrder());

        pq.add(3);
        pq.add(4);
        pq.add(1);
        pq.add(2);

        System.out.println(pq.poll());
        System.out.println(pq.poll());
    }

    private static void printArr(int[] arr) {

        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
    }

    private static void test(int[] arr) {

            int n = arr.length;
            int m = arr.length;
            int index=0;
            int temp=-1;
            int max = 0;
            for(int i=0 ; i<n; i++){
                 max = arr[0];
                index = 0;
                for(int j=0;j<m;j++){
                   // max = arr[j];
                    if(max<arr[j]){
                        max = arr[j];
                        index = j;
                    }
                }

                int temp1 = arr[index];
                arr[index] = arr[m-1];
                arr[m-1] = temp1;
                m=m-1;

                System.out.println();
                printArr(arr);
            }
        }
}
