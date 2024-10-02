package com.example.springbeandemo.BeanDemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ClassPathXmlApplicationContextDemo {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("classpath:beans.xml");
        System.out.println(classPathXmlApplicationContext.getBean("xmlMyBean"));
    }
}
