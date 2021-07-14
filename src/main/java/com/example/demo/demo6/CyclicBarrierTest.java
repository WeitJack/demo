package com.example.demo.demo6;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;

public class CyclicBarrierTest {
    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(7,()->{
            System.out.println("CyclicBarrier Test Over!");
        });
        for (int i = 0; i < 7; i++) {
            final Integer temp = i;
            new Thread(()->{
                System.out.println(Thread.currentThread().getName() + ":" + temp);
                try {
                    TimeUnit.SECONDS.sleep(3);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                try {
                    cyclicBarrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            },"Thread"+i).start();
        }

    }
}
