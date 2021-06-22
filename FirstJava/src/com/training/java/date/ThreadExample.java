package com.training.java.date;

import java.util.concurrent.atomic.AtomicInteger;

public class ThreadExample {

    public static int           counter;

    public static AtomicInteger counter2 = new AtomicInteger();

    public static synchronized void count() {
        ThreadExample.counter++;
    }

    public static void main(final String[] args) throws Exception {

        for (int iLoc = 0; iLoc < 10; iLoc++) {
            Thread n = new Thread(() -> {
                for (int jLoc = 0; jLoc < 100_000_000; jLoc++) {
                    ThreadExample.counter2.incrementAndGet();
                    // count();
                    //                    try {
                    //                        Thread.sleep(1);
                    //                    } catch (InterruptedException e) {
                    //                    }
                    //ThreadExample.counter++;
                }
            });
            n.setName("Counter-" + iLoc);
            n.start();
        }
        Thread.sleep(5_000);
        System.out.println(ThreadExample.counter);
    }
}
