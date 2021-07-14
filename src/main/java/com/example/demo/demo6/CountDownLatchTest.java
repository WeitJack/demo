package com.example.demo.demo6;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class CountDownLatchTest {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch count = new CountDownLatch(5);
        for (int i = 0; i < 5 ; i++) {
            final Integer temp = i;
            new Thread(()->{
                System.out.println(Thread.currentThread().getName()+ ":"+ temp);
                try {
                    TimeUnit.SECONDS.sleep(3);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                count.countDown();
            },String.valueOf(i)).start();
        }
        count.await();
        System.out.println("CountDown Test over!");
    }
}
