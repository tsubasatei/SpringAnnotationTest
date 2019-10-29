package com.xt;


import com.xt.config.MainConfigOfLifeCycle;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class IOCTest_LifeCycle {

    @Test
    public void test () {
        AnnotationConfigApplicationContext ioc = new AnnotationConfigApplicationContext(MainConfigOfLifeCycle.class);
        System.out.println("容器创建完成 。。。");
//        Car car = ioc.getBean(Car.class);

        // 关闭容器
        ioc.close();
    }
}
