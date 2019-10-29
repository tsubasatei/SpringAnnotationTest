package com.xt;


import com.xt.bean.Person;
import com.xt.config.MainConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainTest {
    public static void main(String[] args) {

        // 配置文件的方式
        /*
        ApplicationContext ioc = new ClassPathXmlApplicationContext("bean.xml");
        Person person = (Person) ioc.getBean("person");
        System.out.println(person);
        */

        ApplicationContext ioc =  new AnnotationConfigApplicationContext(MainConfig.class);
        Person person = ioc.getBean(Person.class);
        System.out.println(person);

        person = (Person) ioc.getBean("person");
        System.out.println(person);

        String[] beanNamesForType = ioc.getBeanNamesForType(Person.class);
        for (String type : beanNamesForType) {
            System.out.println(type);
        }

    }
}
