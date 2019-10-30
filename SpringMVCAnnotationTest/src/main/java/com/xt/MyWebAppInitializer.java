package com.xt;

import com.xt.config.AppConfig;
import com.xt.config.RootConfig;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * web 容器启动的时候创建对象，调用方法来初始化容器以及前端控制器
 */
public class MyWebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    // 获取根容器的配置类：Spring 的配置文件 父容器
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{RootConfig.class};
    }

    // 获取 web 容器的配置类：SpringMVC配置文件 子容器
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{AppConfig.class};
    }

    /**
     * 获取 DispatcherServlet 的映射信息
     *      /: 拦截所有的请求（包括静态资源 xx.js, xx.png）,但是不包括 *。jsp
     *      /*: 拦截所有的请求，连 *.jsp 页面都拦截，jsp 页面时 tomcat 的 jsp 引擎解析的
     * @return
     */
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }
}
