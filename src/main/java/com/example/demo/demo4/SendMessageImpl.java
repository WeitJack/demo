package com.example.demo.demo4;

public class SendMessageImpl implements SendMessage {
    @Override
    public String mes(String mes) {
        System.out.println(mes);
        return mes;
    }
}
