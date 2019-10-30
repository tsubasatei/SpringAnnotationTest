package com.xt.servlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * 监听项目的启动和停止
 */
public class UserListener implements ServletContextListener {
    // 监听 ServletContext 启动初始化
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("UserListener...contextInitialized");
    }

    // 监听 ServletContext 销毁
    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        ServletContext servletContext = sce.getServletContext();
        System.out.println("UserListener...contextDestroyed");
    }
}
