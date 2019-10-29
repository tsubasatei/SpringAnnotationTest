package com.xt;


import com.xt.config.MainConfigOfTx;
import com.xt.tx.UserService;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class IOCTest_Tx {

    @Test
    public void test () {
        AnnotationConfigApplicationContext ioc = new AnnotationConfigApplicationContext(MainConfigOfTx.class);
        UserService userService = ioc.getBean(UserService.class);
        userService.add();
    }
}
