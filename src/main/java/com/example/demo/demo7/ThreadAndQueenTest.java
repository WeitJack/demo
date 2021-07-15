package com.example.demo.demo7;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ThreadAndQueenTest {
    public static void main(String[] args) {
        BlockingQueue queue = new ArrayBlockingQueue(6);
        new Thread(()->{
            for (int i = 0; i < 100; i++) {
                System.out.println(Thread.currentThread().getName() + ':' + queue.add(i));
            }
        },"add").start();

        new Thread(()->{
            for (int i = 0; i < 100; i++) {
                System.out.println(Thread.currentThread().getName() + ':' + queue.remove());
            }
        },"remove").start();
    }
}
