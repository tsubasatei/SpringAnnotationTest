package com.xt.bean;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

@Component
public class Cat implements InitializingBean, DisposableBean {
    public void destroy() throws Exception {
        System.out.println("cat destroy...");
    }

    public void afterPropertiesSet() throws Exception {
        System.out.println("cat afterPropertiesSet");
    }

    public Cat() {
        System.out.println("cat constructor ... ");
    }
}
