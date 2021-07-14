package com.example.demo.demo1;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class JucTest {
    public static void main(String[] args) {
        Data data = new Data();
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    data.increase();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        },"A").start();
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    data.decrease();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        },"B").start();
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    data.increase();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        },"C").start();
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    data.decrease();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        },"D").start();
    }

}
class Data{
    Lock lock = new ReentrantLock();
    Condition condition = lock.newCondition();
    private int number;
    public void increase(){
        lock.lock();
        try{
            while (number != 0){
                condition.await();
            }
            number++;
            System.out.println(Thread.currentThread().getName() + "=>" + number);
            condition.signalAll();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }

    }

    public void decrease() {
        lock.lock();
        try {
            while (number == 0){
                condition.await();
            }
            number--;
            System.out.println(Thread.currentThread().getName() + "=>" + number);
            condition.signalAll();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }

    }
}
