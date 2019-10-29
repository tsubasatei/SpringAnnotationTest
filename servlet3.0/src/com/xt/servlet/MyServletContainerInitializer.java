package com.xt.servlet;


import com.xt.service.HelloService;

import javax.servlet.*;
import javax.servlet.annotation.HandlesTypes;
import java.util.EnumSet;
import java.util.Set;

/**
 * 容器启动的时候会将 @HandlesTypes 指定的这个类型下面的子类（实现类、子接口等）传递过来
 * 传入感兴趣的类型
 */
@HandlesTypes(value={HelloService.class})
public class MyServletContainerInitializer implements ServletContainerInitializer {
    /**
     * 应用启动的时候，会运行 onStartup 方法
     * Set<Class<?>> set: 感兴趣的类型的所有子类型
     * ServletContext servletContext：代表当前 Web 应用的 ServletContext
     * 一个 Web 应用一个 ServletContext
     *
     * 1)、使用 ServletContext 注册 Web 组件 (Servlet、Filter、Listener)
     * 2)、使用编码的方式，在项目启动的时候给 ServletContext 里面添加组件
     *      必须在项目启动的时候来添加：
     *      1）、ServletContainerInitializer 得到 ServletContext
     *      2）、ServletContextListener 得到 ServletContext
     */
    @Override
    public void onStartup(Set<Class<?>> set, ServletContext servletContext) throws ServletException {
        System.out.println("传入的感兴趣的类型：");
        for(Class clazz : set) {
            System.out.println(clazz);
        }

        // 注册组件 Servlet
        ServletRegistration.Dynamic servletRegistration = servletContext.addServlet("userServlet", UserServlet.class);
        // 配置 Servlet 的映射信息
        servletRegistration.addMapping("/user");

        // 注册 Listener
        servletContext.addListener(UserListener.class);

        // 注册 Filter
        FilterRegistration.Dynamic filterRegistration = servletContext.addFilter("userFilter", UserFilter.class);
        // 配置 Filter 的映射信息
        filterRegistration.addMappingForUrlPatterns(EnumSet.of(DispatcherType.REQUEST), true, "/*");

    }
}
