package com.example.demo.demo4;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class ProxyTest implements InvocationHandler {
    private final Object target;

    public ProxyTest(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("执行方法前");
        Object result = method.invoke(target,args);
        System.out.println("执行方法后");
        return result;
    }
}
