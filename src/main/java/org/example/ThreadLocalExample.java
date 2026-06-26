package org.example;

import java.time.Duration;
import java.util.Random;

class ThreadTest extends Thread {

   ThreadLocal<String> threadLocal = new ThreadLocal<>();


    public ThreadTest(String name) {
        super(name);

    }

    @Override
    public void run() {
        Duration.ofSeconds(5);
        this.threadLocal.set(this.getName() + " - " + this.getName());
        System.out.println("Thread :: " + this.getName() + ":"+ threadLocal.get());

    }


}

public class ThreadLocalExample {
    public static void main(String[] args) throws InterruptedException {

        ThreadTest thread1 = new ThreadTest("Thread-1");
        ThreadTest thread2 = new ThreadTest("Thread-2");
        ThreadTest thread3 = new ThreadTest("Thread-3");

        thread1.start();
        thread2.start();
        thread3.start();

        thread1.join();
        thread2.join();
        thread3.join();
    }


    static void  print( ThreadLocal threadLocal){
        System.out.println("print ::  " + threadLocal.get());
    }
}
