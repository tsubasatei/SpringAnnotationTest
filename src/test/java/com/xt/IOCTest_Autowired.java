package com.xt;


import com.xt.bean.Boss;
import com.xt.bean.Car;
import com.xt.bean.Color;
import com.xt.bean.Red;
import com.xt.config.MainConfigOfAutoWired;
import com.xt.config.MainConfigOfPropertyValues;
import com.xt.dao.BookDao;
import com.xt.service.BookService;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class IOCTest_Autowired {

    @Test
    public void test () {
        AnnotationConfigApplicationContext ioc = new AnnotationConfigApplicationContext(MainConfigOfAutoWired.class);

        BookService bookService = ioc.getBean(BookService.class);
        System.out.println(bookService);

        /* // 多种类型实例报错
        BookDao bookDao = ioc.getBean(BookDao.class);
        System.out.println(bookDao);
        */

        Boss boss = ioc.getBean(Boss.class);
        System.out.println(boss);

        Car car = ioc.getBean(Car.class);
        System.out.println(car);

        Color color = ioc.getBean(Color.class);
        System.out.println(color);

        Red red = ioc.getBean(Red.class);
        System.out.println(red);
        System.out.println(ioc);
        ioc.close();

    }
}
