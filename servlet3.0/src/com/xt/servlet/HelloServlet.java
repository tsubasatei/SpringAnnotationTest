package com.xt.servlet;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

@WebServlet("/hello")
public class HelloServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println(Thread.currentThread().getName() + "...start");
        sayHello();
        resp.getWriter().write("hello servlet");
        System.out.println(Thread.currentThread().getName() + "...end");
    }

    public void sayHello() {
        System.out.println(Thread.currentThread().getName() + "...processing");
        // 暂停一会儿线程
        try { TimeUnit.SECONDS.sleep(3); } catch (InterruptedException e) { e.printStackTrace(); }
    }
}
