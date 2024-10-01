package com.example.springbeandemo.BeanDemo;

import com.example.springbeandemo.Bean.myBean;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.support.GenericBeanDefinition;

public class BeanDefinitionRegistryDemo {
    public static void main(String[] args) {
        // 实现了 BeanDefinitionRegister
        DefaultListableBeanFactory defaultListableBeanFactory = new DefaultListableBeanFactory();

        // 创建BeanDefinition
        GenericBeanDefinition genericBeanDefinition = new GenericBeanDefinition();
        genericBeanDefinition.setBeanClass(myBean.class);

        // 注册Bean
        defaultListableBeanFactory.registerBeanDefinition("myBean", genericBeanDefinition);

        // 获取Bean定义
        BeanDefinition myBean = defaultListableBeanFactory.getBeanDefinition("myBean");
        System.out.println("Bean定义的类名 = " + myBean.getBeanClassName());

        // 判断是否包含该Bean
        boolean isContain = defaultListableBeanFactory.containsBeanDefinition("myBean");
        System.out.println("是否包含该Bean = " + isContain);

        // 获取所有Bean定义的名称
        String[] beanDefinitionNames = defaultListableBeanFactory.getBeanDefinitionNames();
        System.out.println("Bean定义的名称 = " + String.join(",", beanDefinitionNames));

        // 获取Bean定义的数量
        int beanDefinitionCount = defaultListableBeanFactory.getBeanDefinitionCount();
        System.out.println("Bean定义的数量 = " + beanDefinitionCount);

        // 判断Bean名称是否被使用
        boolean isBeanNameInUse  = defaultListableBeanFactory.isBeanNameInUse("myBean");
        System.out.println("Bean名称(myBean)是否被使用 = " + isBeanNameInUse );

        // 移除Bean定义
        defaultListableBeanFactory.removeBeanDefinition("myBean");
        System.out.println("Bean 已经被移除");
    }
}
