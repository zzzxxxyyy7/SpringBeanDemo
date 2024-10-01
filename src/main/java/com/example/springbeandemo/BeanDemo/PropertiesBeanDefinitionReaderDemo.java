package com.example.springbeandemo.BeanDemo;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.support.PropertiesBeanDefinitionReader;
import org.springframework.core.io.ClassPathResource;

public class PropertiesBeanDefinitionReaderDemo {
    public static void main(String[] args) {
        DefaultListableBeanFactory defaultListableBeanFactory = new DefaultListableBeanFactory();
        PropertiesBeanDefinitionReader reader = new PropertiesBeanDefinitionReader(defaultListableBeanFactory);

        reader.loadBeanDefinitions(new ClassPathResource("bean-definitions.properties"));

        System.out.println("propertiesMyBean = " + defaultListableBeanFactory.getBean("propertiesMyBean"));
        System.out.println("propertiesMyBean = " + defaultListableBeanFactory.getBean("propertiesMyBean"));
    }
}
