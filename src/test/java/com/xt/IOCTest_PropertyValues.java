package com.xt;


import com.xt.bean.Person;
import com.xt.config.MainConfigOfPropertyValues;
import com.xt.utils.BeanPrintUtils;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

public class IOCTest_PropertyValues {

    @Test
    public void test () {
        AnnotationConfigApplicationContext ioc = new AnnotationConfigApplicationContext(MainConfigOfPropertyValues.class);
        BeanPrintUtils.print(ioc);

        Person person = ioc.getBean(Person.class);
        System.out.println(person);

        ConfigurableEnvironment environment = ioc.getEnvironment();
        String property = environment.getProperty("person.nickName");
        System.out.println(property);

    }
}
