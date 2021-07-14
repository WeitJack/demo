package com.example.demo.demo6;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class SemaphoreTest {
    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(5);
        for (int i = 0; i < 10; i++) {
            final Integer temp = i;
            new Thread(()->{
                try {
                    semaphore.acquire();
                    System.out.println("线程" + temp + "进入");
                    TimeUnit.SECONDS.sleep(3);
                    System.out.println("线程" + temp + "退出");
                    semaphore.release();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        }

    }
}
