package com.example.springbeandemo.Bean;

public class myBean {

    private String name;

    private String age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public void init(){
        System.out.println("execute com.example.springbeandemo.Bean.myBean.init");
    }

    public void destroy(){
        System.out.println("execute com.example.springbeandemo.Bean.myBean");
    }
}