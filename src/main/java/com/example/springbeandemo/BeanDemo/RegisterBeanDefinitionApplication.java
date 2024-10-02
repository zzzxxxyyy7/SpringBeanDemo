package com.example.springbeandemo.BeanDemo;

import com.example.springbeandemo.Bean.myBean;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class RegisterBeanDefinitionApplication {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext();

        // 注册 Bean
        annotationConfigApplicationContext.register(myBean.class);

        // 扫描包
        annotationConfigApplicationContext.scan("com.example.springbeandemo.Bean");

        // 打印 Bean
        for (String beanDefinitionName : annotationConfigApplicationContext.getBeanDefinitionNames()) {
            System.out.println("beanDefinitionName = " + beanDefinitionName);
        }
    }
}
