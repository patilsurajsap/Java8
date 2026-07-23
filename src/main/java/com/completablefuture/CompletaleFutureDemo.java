package com.completablefuture;

import java.time.Duration;
import java.util.concurrent.Callable;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CompletaleFutureDemo {

    // Define a custom thread pool to avoid starving the default ForkJoinPool
    private final ExecutorService executor = Executors.newFixedThreadPool(1);

    public void getUserDashboardData(String userId) {

        // Task 1: Fetch user info asynchronously
        System.out.println("User INFO STARTED");
        CompletableFuture<String> userInfoFuture = CompletableFuture.supplyAsync(() -> {
            return fetchUserInfo(userId); // Simulates network call
        }, executor);
        System.out.println("ORDER INFO STARTED");

        // Task 2: Fetch order history asynchronously
        CompletableFuture<String> orderHistoryFuture = CompletableFuture.supplyAsync(() -> {
            return fetchOrderHistory(userId); // Simulates network call
        }, executor);

        // Combine both independent results when they are ready
        CompletableFuture<String> dashboardFuture = userInfoFuture.thenCombine(orderHistoryFuture,
                (userInfo, orderHistory) -> {
                    return "Dashboard data: [" + userInfo + " | " + orderHistory + "]";
                });

        // Consume the final aggregated data
        dashboardFuture.thenAccept(System.out::println);
    }

    private String fetchUserInfo(String userId) {
        try {
            Thread.sleep(Duration.ofSeconds(5));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("User INFO FETCTED");

        return "User Details for " + userId;
    }


    private String fetchOrderHistory(String userId) {

        try {
            Thread.sleep(Duration.ofSeconds(1));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Order return fetched");
        return "Orders: #101, #102";

    }


    public static void main(String[] args) {

        new CompletaleFutureDemo().getUserDashboardData("surajpatil123");
        System.out.println("---");
    }
}
