package com.example.springbeandemo.BeanDemo;

import com.example.springbeandemo.Bean.myBean;
import org.springframework.beans.factory.config.BeanDefinitionHolder;
import org.springframework.beans.factory.support.BeanDefinitionReaderUtils;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.support.GenericBeanDefinition;

public class BeanDefinitionHolderDemo {
    public static void main(String[] args) {
        // 实现了 BeanDefinitionRegister
        DefaultListableBeanFactory defaultListableBeanFactory = new DefaultListableBeanFactory();

        // 创建 BeanDefinition
        GenericBeanDefinition genericBeanDefinition = new GenericBeanDefinition();
        genericBeanDefinition.setBeanClass(myBean.class);

        // 设置 Bean 名称
        String beanName = "myBean";

        // 设置别名
        String[] aliases = {"myBeanX" , "myBeanY"};

        // 创建一个 BeanDefinitionHolder，将 BeanDefinition 与名称关联起来
        BeanDefinitionHolder beanDefinitionHolder = new BeanDefinitionHolder(genericBeanDefinition, beanName, aliases);

        // 使用 BeanDefinitionReaderUtils 把 BeanDefinition 注册到容器 DefaultListableBeanFactory
        BeanDefinitionReaderUtils.registerBeanDefinition(beanDefinitionHolder, defaultListableBeanFactory);

        System.out.println("myBean = " + defaultListableBeanFactory.getBean("myBean"));
        System.out.println("myBeanX = " + defaultListableBeanFactory.getBean("myBeanX"));
        System.out.println("myBeanY = " + defaultListableBeanFactory.getBean("myBeanY"));
    }
}
