package com.example.springbeandemo.BeanDemo;

import com.example.springbeandemo.Bean.ClassPathBean.MyController;
import com.example.springbeandemo.Bean.ClassPathBean.MyRepository;
import com.example.springbeandemo.Bean.ClassPathBean.MyService;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.annotation.ClassPathBeanDefinitionScanner;

public class ClassPathBeanDefinitionScannerDemo {
    public static void main(String[] args) {
        DefaultListableBeanFactory defaultListableBeanFactory = new DefaultListableBeanFactory();

        // 创建扫描器实例
        ClassPathBeanDefinitionScanner classPathBeanDefinitionScanner = new ClassPathBeanDefinitionScanner(defaultListableBeanFactory);

        // 扫描指定包下的类
        classPathBeanDefinitionScanner.scan("com.example.springbeandemo.Bean.ClassPathBean");

        System.out.println("MyController = " + defaultListableBeanFactory.getBean(MyController.class));
        System.out.println("MyService = " + defaultListableBeanFactory.getBean(MyService.class));
        System.out.println("MyRepository = " + defaultListableBeanFactory.getBean(MyRepository.class));
    }
}
