package com.xt;


import com.xt.aop.MathCalculator;
import com.xt.config.MainConfigOfAOP;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class IOCTest_AOP {

    @Test
    public void test () {
        AnnotationConfigApplicationContext ioc = new AnnotationConfigApplicationContext(MainConfigOfAOP.class);
        MathCalculator mathCalculator = ioc.getBean(MathCalculator.class);
        System.out.println(mathCalculator);
        mathCalculator.div(12, 0);

        ioc.close();
    }
}
