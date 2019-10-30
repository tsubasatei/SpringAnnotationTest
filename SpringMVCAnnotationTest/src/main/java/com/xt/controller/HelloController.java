package com.xt.controller;

import com.xt.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    @Autowired
    private HelloService helloService;

    @ResponseBody
    @RequestMapping("/hello")
    public String hello() {
        String hello = helloService.sayHello("tomcat");
        return hello;
    }

    // WEB-INF/views/success.jsp
    @RequestMapping("/suc")
    public String success() {
        return "success";
    }
}
