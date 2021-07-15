package com.example.demo.demo7;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

public class BlockQueenTest {
    public static void main(String[] args) throws InterruptedException {
        Queen queen = new Queen();
        try {
            queen.test1();
        }catch (Exception e){
            e.printStackTrace();
        }
        queen.test2();
        try {
            queen.test3();
        }catch (Exception e){
            e.printStackTrace();
        }
        queen.test4();
    }

}
class Queen{
    private BlockingQueue queue = new ArrayBlockingQueue(5);
    /**
     * test1 : 测试 抛出异常组（add - remove)
     */
    public void test1(){
        System.out.println("-------------------test1开启测试---------------------");
        for (int i = 0; i < 5; i++) {
            System.out.println(queue.add(i));
        }
        for (int i = 0; i < 6; i++){
            System.out.println(queue.remove());
        }
        System.out.println("-------------------test1结束测试---------------------");
    }

    /**
     * test2 : 测试 不抛出异常组（offer() - poll())
     */
    public void test2(){
        System.out.println("-------------------test2开启测试---------------------");
        for (int i = 0; i < 5; i++) {
            System.out.println(queue.offer(i));
        }
        for (int i = 0; i < 6; i++) {
            System.out.println(queue.poll());
        }
        System.out.println("-------------------test2结束测试---------------------");
    }

    /**
     * test4 : 测试 永久阻塞组(put - peek)
     * @throws InterruptedException
     */
    public void test3() throws InterruptedException {
        System.out.println("-------------------test3开启测试---------------------");
        for (int i = 0; i < 5; i++) {
            queue.put(i);
        }
        for (int i = 0; i < 5; i++) {
            System.out.println(queue.take());
        }
        System.out.println("-------------------test3结束测试---------------------");
    }

    /**
     * test4 : 测试 超时阻塞组(offer(,,) - poll(,))
     * @throws InterruptedException
     */
    public void test4() throws InterruptedException {
        System.out.println("-------------------test4开启测试---------------------");
        for (int i = 0; i < 6; i++) {
            System.out.println(queue.offer(i, 3, TimeUnit.SECONDS));
        }
        for (int i = 0; i < 6; i++) {
            System.out.println(queue.poll(3, TimeUnit.SECONDS));
        }
        System.out.println("-------------------test4结束测试---------------------");
    }
}
