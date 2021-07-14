package com.example.demo.demo4;

public class ProxyMain {
    public static void main(String[] args) {
        SendMessage message = (SendMessage) ProxyFactory.getProxy(new SendMessageImpl());
        message.mes("test");
    }

}
