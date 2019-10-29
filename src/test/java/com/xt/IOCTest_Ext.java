package com.xt;

import com.xt.ext.ExtConfig;
import org.junit.Test;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class IOCTest_Ext {

    @Test
    public void test () {
        AnnotationConfigApplicationContext ioc = new AnnotationConfigApplicationContext(ExtConfig.class);
        // 发布事件
        ioc.publishEvent(new ApplicationEvent(new String("我发布的事件")) {
        });
        ioc.close();
    }
}
