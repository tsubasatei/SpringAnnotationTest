package com.xt.servlet;

import javax.servlet.AsyncContext;
import javax.servlet.ServletException;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

@WebServlet(value = "/async", asyncSupported = true)
public class AsyncServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1、支持异步处理 asyncSupported
        // 2、开启异步模式，获取到异步上下文
        System.out.println("主线程开始。。。" + Thread.currentThread().getName() + "==>" + System.currentTimeMillis());
        AsyncContext startAsync = req.startAsync();

        // 3、业务逻辑进行异步处理：开始异步处理
        startAsync.start(() -> {
            try {
                System.out.println("副线程开始。。。" + Thread.currentThread().getName() + "==>" + System.currentTimeMillis());
                sayHello();
                // 异步模式完成
                startAsync.complete();
                // 4. 获取响应
                ServletResponse response = startAsync.getResponse();
                response.getWriter().write("hello async...");
                System.out.println("副线程结束。。。" + Thread.currentThread().getName() + "==>" + System.currentTimeMillis());
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

    }

    public void sayHello() {
        System.out.println(Thread.currentThread().getName() + "...processing");
        // 暂停一会儿线程
        try { TimeUnit.SECONDS.sleep(3); } catch (InterruptedException e) { e.printStackTrace(); }
    }
}
