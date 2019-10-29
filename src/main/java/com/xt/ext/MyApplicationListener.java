package com.xt.ext;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class MyApplicationListener implements ApplicationListener {
    // 当容器中发布此事件以后，方法触发
    public void onApplicationEvent(ApplicationEvent applicationEvent) {
        System.out.println("当前的事件：" + applicationEvent);
    }
}
