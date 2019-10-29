package com.xt;

import com.xt.bean.Blue;
import com.xt.bean.Person;
import com.xt.config.MainConfig;
import com.xt.config.MainConfig2;
import com.xt.utils.BeanPrintUtils;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.Environment;

import java.util.Map;

public class IOCTest {
    ApplicationContext ioc = new AnnotationConfigApplicationContext(MainConfig2.class);

    @Test
    public void test02Import () {
        BeanPrintUtils.print(ioc);
        Blue blue = ioc.getBean(Blue.class);
        System.out.println(blue);

        Object bean = ioc.getBean("colorFactoryBean");
        Object bean2 = ioc.getBean("colorFactoryBean");
        System.out.println(bean);
        System.out.println(bean == bean2);

        Object bean3 = ioc.getBean("&colorFactoryBean");
        System.out.println(bean3.getClass().getName());
    }

    @Test
    public void test02Conditional () {
        ApplicationContext ioc = new AnnotationConfigApplicationContext(MainConfig2.class);
        Environment environment = ioc.getEnvironment();
        // 动态获取环境变量的值 ：Windows 10
        String property = environment.getProperty("os.name");
        System.out.println("os.name : " + property);
        String[] beanDefinitionNames = ioc.getBeanDefinitionNames();
        for (String name : beanDefinitionNames) {
            System.out.println(name);
        }

        Map<String, Person> personMap = ioc.getBeansOfType(Person.class);
        System.out.println(personMap);
    }

    @Test
    public void test02 () {
        ApplicationContext ioc = new AnnotationConfigApplicationContext(MainConfig2.class);
//        BeanPrintUtils.print(ioc);
        System.out.println("ioc 容器创建完成 。。。");
        Person person = (Person) ioc.getBean("person");
//        Person person2 = (Person) ioc.getBean("person");
//        System.out.println(person == person2);
    }

    @Test
    public void test01 () {
        ApplicationContext ioc = new AnnotationConfigApplicationContext(MainConfig.class);
        String[] beanDefinitionNames = ioc.getBeanDefinitionNames();
        for (String name : beanDefinitionNames) {
            System.out.println(name);
        }

    }
}
