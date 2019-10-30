package com.xt.controller;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 拦截器
 */
public class MyFirstInterceptor implements HandlerInterceptor {
    // 目标方法执行之前
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("MyFirstInterceptor...preHandle" + request.getRequestURI());
        return true;
    }

    // 目标方法执行之后
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("MyFirstInterceptor...postHandle");
    }

    // 页面响应以后执行
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("MyFirstInterceptor...afterCompletion");
    }
}
