package com.xt.aop;

import org.springframework.stereotype.Component;

/**
 * 计算器类
 * 业务逻辑类
 */
@Component
public class MathCalculator {

    public int div(int i, int j) {
        System.out.println("MathCalculator ... div ...");
        return i/j;
    }
}
