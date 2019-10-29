package com.xt.utils;

import org.springframework.context.ApplicationContext;

/**
 * 打印容器中组件的名字
 */
public class BeanPrintUtils {

    public static void print(ApplicationContext ioc) {
        String[] beanDefinitionNames = ioc.getBeanDefinitionNames();
        for (String name : beanDefinitionNames) {
            System.out.println(name);
        }
    }
}
