package com.interview;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executors;

public class Program {

    public static void main(String[] args) throws InterruptedException {

        CompletableFuture.supplyAsync(() -> {
                    // Step 1: Simulate fetching data from a database or API
                    System.out.println("Fetching data on: " + Thread.currentThread().getName());
                    return "user_id_42";
                })
                .thenApply(userId -> {
                    // Step 2: Transform the raw data
                    System.out.println("Transforming data on: " + Thread.currentThread().getName());
                    userId = "testid";

                    return "Welcome profile data for " + userId;
                })
                .thenAccept(profile -> {

                    // Step 3: Consume the final result (e.g., log it or display to user)
                    System.out.println("Consuming result: " + profile);
                })
                .exceptionally(ex -> {
                    // Step 4: Gracefully catch any exception thrown upstream
                    System.err.println("An error occurred: " + ex.getMessage());
                    return null;
                })
                .join();



        ThreadLocal<List<String>> threadLocal = new ThreadLocal();
        ArrayList<String> list = new ArrayList<>();
        list.add("test");
        list.add("test1");
        threadLocal.set(list);
       // threadLocal.set("test");

        System.out.println("ThreadLocal value: " + threadLocal.get());


        Thread thread = new Thread(() -> {
            System.out.println("ThreadLocal value in new thread: " + threadLocal.get());
            Duration.ofSeconds(5);
            System.out.println("ThreadLocal value: " + threadLocal.get());
        });

        thread.start();

        thread.join();



       // Duration.ofSeconds(20);
        System.out.println("Main End");

    }

    public  static  void threadCreate(){

        for (int i = 0; i < 200000000; i++) {
            new Thread(() -> {
                try {
                    System.out.println("Thread " + Thread.currentThread().getName() + " is running");
                    Thread.sleep(Duration.ofMinutes(2));
                    //Thread.currentThread().join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        }

        System.out.println("Main thread is running");

        Thread.ofVirtual();
        CompletableFuture completableFuture = new CompletableFuture();




    }
}
