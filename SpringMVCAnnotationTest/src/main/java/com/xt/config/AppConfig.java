package com.xt.config;

import com.xt.controller.MyFirstInterceptor;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.config.annotation.*;

/**
 * SpringMVC 只扫描 Controller：子容器
 * useDefaultFilters=false：禁用默认的过滤规则
 */
@ComponentScan(value = "com.xt",  includeFilters = {
        @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = {Controller.class})
}, useDefaultFilters = false)
@Configuration
@EnableWebMvc
public class AppConfig implements WebMvcConfigurer {
    // 定制

    // 视图解析器
    public void configureViewResolvers(ViewResolverRegistry registry) {
        // 默认所有的页面都从 /WEB-INF/xxx.jsp
//        registry.jsp();
        registry.jsp("/WEB-INF/views/", ".jsp");
    }

    // 静态资源访问
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }

    // 拦截器
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new MyFirstInterceptor()).addPathPatterns("/**");
    }
}
