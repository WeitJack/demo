package com.example.demo.demo3;

import java.io.Serializable;

public class Student implements Serializable {

    private static final long serialVersionUID = -6060343040263809614L;

    private String userName;
    private String password;
    private String year;

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public Student(String userName, String password, String year) {
        this.userName = userName;
        this.password = password;
        this.year = year;
    }
}
