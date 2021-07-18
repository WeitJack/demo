package com.example.demo.demo8;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class LambdaTest {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("luck");
        list.add("lock");
        list.stream().filter(l->(l.equals("luck"))).forEach(l->{
            System.out.println(l);
        });

        LambdaTest test = new LambdaTest();
        test.testFunction("test Function");
        test.testPredicate();
        test.testConsumer("test Consumer");
        test.testSupplier("test Supplier");
        test.testStream();
    }

    /**
     * test Function interface
     */
    public void testFunction(String tamp){
        Function function = t -> {
            return t;
        };
        System.out.println(function.apply(tamp));
    }

    /**
     * test Predicate interface
     */
    public void testPredicate(){
        Predicate predicate = t -> {
            return t.equals(t);
        };
        System.out.println(predicate.test("true"));
    }

    /**
     * test Consumer interface
     */
    public void testConsumer(String tamp){
        Consumer consumer = t -> {
            System.out.println(t);
            return;
        };
        consumer.accept(tamp);
    }

    /**
     * test Supplier interface
     */
    public void testSupplier(String tamp){
        Supplier supplier = () -> {
                return tamp;
        };
        System.out.println(supplier.get());
    }

    /**
     * test Stream function
     * 现有5个用户
     * 1、ID必须为偶数
     * 2、年龄超过18
     * 3、用户名转成大写
     * 4、用户名按倒序排列
     * 5、只输出一个用户
     */
    public void testStream(){
        List<User> users = new ArrayList<>();
        users.add(new User(1,17,"Xiong Da"));
        users.add(new User(2,18,"Xiong Er"));
        users.add(new User(3,19,"Zhang San"));
        users.add(new User(4,20,"Li Si"));
        users.add(new User(5,21,"Wang Wu"));
        users.stream().filter(u->(u.id % 2 == 0)).filter(u->(u.age > 18))
                .map(u->{return u.name.toUpperCase();}).sorted((u1,u2)->{return u2.compareTo(u1);})
                .limit(1).forEach(t->{
            System.out.println(t);
        });
    }
}

class User{
    Integer id;
    Integer age;
    String name;

    public User(Integer id, Integer age, String name) {
        this.id = id;
        this.age = age;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
