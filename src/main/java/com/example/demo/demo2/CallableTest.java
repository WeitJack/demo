package com.example.demo.demo2;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class CallableTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Callable call = new Call();
        FutureTask task = new FutureTask(call);
        new Thread(()->{
            task.run();
        }).start();
        String test = (String) task.get();
        System.out.println(test);
    }
}


class Call implements Callable<String> {
    @Override
    public String call() throws Exception {
        System.out.println("call():");
        return "susses";
    }

}

