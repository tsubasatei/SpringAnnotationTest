package com.xt.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * 日志切面类
 *
 * @Aspect : 告诉 Spring 当前类是一个切面类
 */
@Component
@Aspect
public class LogAspects {

    /**
     * 抽取公共的切入点表达式
     * 1、本类引用
     * 2、其他的切面引用
     */
    @Pointcut("execution(* MathCalculator.*(..))")
    public void pointcut() {}

    /**
     * @Before 在目标方法之前切入：切入点表达式（指定在哪个方法切入）
     * JoinPoint 一定要出现在参数表的第一位
     * @param joinPoint
     */
    @Before("pointcut()")
    public void logStart(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        System.out.println(methodName + " 方法开始运行。。。参数列表是：" + Arrays.asList(joinPoint.getArgs()));
    }

    @After("pointcut()")
    public void logEnd(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        System.out.println(methodName + " 方法运行结束。。。");
    }

    @AfterReturning(value = "pointcut()", returning = "result")
    public void logReturn(JoinPoint joinPoint, Object result) {
        String methodName = joinPoint.getSignature().getName();
        System.out.println(methodName + " 方法正常返回。。。结果是：" + result);
    }

    @AfterThrowing(value = "pointcut()", throwing = "ex")
    public void logThrowing(JoinPoint joinPoint, Exception ex) {
        String methodName = joinPoint.getSignature().getName();
        System.out.println(methodName + " 方法异常。。。异常信息是：" + ex);
    }


}
