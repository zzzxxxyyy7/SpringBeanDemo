package com.example.springbeandemo.BeanDemo;

import com.example.springbeandemo.Bean.myBean;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.annotation.ScannedGenericBeanDefinition;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.SimpleMetadataReaderFactory;

import java.io.IOException;

public class BeanDefinitionDemo {
    public static void main(String[] args) throws Exception {
        DefaultListableBeanFactory defaultListableBeanFactory = new DefaultListableBeanFactory();
        defaultListableBeanFactory.registerBeanDefinition("myBean" , createBeanDefinition());

        // 获取 Bean(设置了懒加载，获取的时候才执行 init)
        myBean myBean = defaultListableBeanFactory.getBean("myBean", com.example.springbeandemo.Bean.myBean.class);

        // 打印 Bean
        System.out.println("myBean = " + myBean);

        // 销毁 Bean
        defaultListableBeanFactory.destroySingleton("myBean");
    }

    private static BeanDefinition createBeanDefinition() throws IOException {
        // 创建一个 MetadataReaderFactory
        SimpleMetadataReaderFactory simpleMetadataReaderFactory = new SimpleMetadataReaderFactory();
        // 给 元数据阅读器工厂 传入指定的 ClassName 拿到对应元数据阅读器
        MetadataReader metadataReader = simpleMetadataReaderFactory.getMetadataReader(myBean.class.getName());

        // 设置 Bean 属性
        ScannedGenericBeanDefinition beanDefinition = new ScannedGenericBeanDefinition(metadataReader);

        // 设置作用域、懒加载、主 Bean、抽象类
        beanDefinition.setScope("singleton");
        beanDefinition.setLazyInit(true);
        beanDefinition.setPrimary(true);
        beanDefinition.setAbstract(false);

        // 设置 Bean 的初始化与销毁方法
        beanDefinition.setInitMethodName("init");
        beanDefinition.setDestroyMethodName("destroy");

        beanDefinition.setAutowireCandidate(true);
        beanDefinition.setRole(BeanDefinition.ROLE_APPLICATION);

        beanDefinition.setDescription("This is a custom bean definition");
        beanDefinition.setResourceDescription("Bean 描述");

        // 往 Bean 中添加初始化属性
        beanDefinition.getPropertyValues().add("name", "lex");
        beanDefinition.getPropertyValues().add("age", "18");

        return beanDefinition;
    }
}
