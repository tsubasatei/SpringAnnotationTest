package com.xt.config;

import com.xt.bean.Person;
import com.xt.dao.BookDao;
import org.springframework.context.annotation.*;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;


/**
 * 配置类 == 配置文件
 *
 * @Configuration : 告诉 Spring 这是一个配置类
 *
 * @ComponentScan :
 *      value 指定要扫描的包
 *      excludeFilters = Filter[] : 指定扫描的时候按照什么规则排除哪些组件
 *      includeFilters Filter[] : 指定扫描的时候只需要包含哪些组件
 *      useDefaultFilters : 值 false 配合 includeFilters 一起使用
 *
 * @ComponentScans : 可以包含多个 @ComponentScan
 *
 * FilterType.ANNOTATION ： 按照注解
 * FilterType.ASSIGNABLE_TYPE : 按照给定的类型
 * FilterType.ASPECTJ :使用 ASPECTJ 表达式
 * FilterType.REGEX ：使用正则指定
 * FilterType.CUSTOM ：使用自定义规则
 *
 */
@Configuration
/*
@ComponentScan(value = "com.xt",
        */
/*excludeFilters = {
            @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = {Controller.class})
        }*//*

        includeFilters = {
                @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = {Service.class, Repository.class})
        },
        useDefaultFilters = false
)
*/
@ComponentScans(value = {
        @ComponentScan(value = "com.xt",
                /*excludeFilters = {
                    @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = {Controller.class})
                }*/
                includeFilters = {
//                        @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = {Service.class}),
//                        @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, classes = {BookDao.class}),
                        @ComponentScan.Filter(type = FilterType.CUSTOM, classes = {MyTypeFilter.class})
                },
                useDefaultFilters = false
        )
})
public class MainConfig {

    /**
     * @Bean ： 给容器中注册一个 Bean
     * 类型 ：为返回值的类型
     * id ：默认是方法名
     * @return
     */
    @Bean("person")
    public Person person01 () {
        return new Person(20, "李四");
    }
}
