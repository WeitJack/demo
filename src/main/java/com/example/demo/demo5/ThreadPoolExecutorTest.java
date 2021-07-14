package com.example.demo.demo5;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.concurrent.*;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadPoolExecutorTest {
    private static final int CORE_POOL_SIZE = 5;
    private static final int MAX_POOL_SIZE = 10;
    private static final int QUEUE_CAPACITY = 100;
    private static final Long KEEP_ALIVE_TIME = 1L;
    public static void main(String[] args) throws ExecutionException, InterruptedException, ClassNotFoundException, InvocationTargetException, IllegalAccessException, InstantiationException {
        Data data = new Data();
        ThreadPoolExecutor executor = new ThreadPoolExecutor(
                CORE_POOL_SIZE,
                MAX_POOL_SIZE,
                KEEP_ALIVE_TIME,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(QUEUE_CAPACITY),
                new ThreadPoolExecutor.CallerRunsPolicy());
        for (int i = 0; i < 10; i++) {
            final Integer temp = i;
            executor.execute(()->{
                data.print(Integer.toString(temp));
            });
        }
        Class<?> clazz = Class.forName("com.example.demo.demo5.Data");
        Object obj= clazz.newInstance();
        Method[] methods = clazz.getDeclaredMethods();
        for (Method method:methods) {
            System.out.println(method.getName());
            if(method.getName().equals("print"))
                method.invoke(obj,"test");
            else
                method.invoke(obj);
        }
        executor.shutdown();
    }
}

class Call implements Callable<String> {
    @Override
    public String call() throws Exception {
        System.out.println("call():");
        return "susses";
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

    public void print(String mes){
        System.out.println(Thread.currentThread().getName() + "接收参数" + mes);
    }
}