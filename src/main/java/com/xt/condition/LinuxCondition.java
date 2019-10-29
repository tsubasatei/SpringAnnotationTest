package com.xt.condition;


import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * 判断是否 linux 系统
 */
public class LinuxCondition implements Condition {

    /**
     *
     * @param conditionContext ：判断条件能使用的上下文（环境）
     * @param annotatedTypeMetadata ：注释信息
     * @return
     */
    public boolean matches(ConditionContext conditionContext, AnnotatedTypeMetadata annotatedTypeMetadata) {

        // 1、能获取到 ioc 使用的 BeanFactory
        ConfigurableListableBeanFactory beanFactory = conditionContext.getBeanFactory();
        
        // 2、获取类加载器
        ClassLoader classLoader = conditionContext.getClassLoader();

        // 3、获取当前环境信息
        Environment environment = conditionContext.getEnvironment();

        // 4、获取到 bean 定义的注册类
        BeanDefinitionRegistry registry = conditionContext.getRegistry();

        // 可以判断容器中的 bean 注册情况，也可以给容器中注册 bean
        boolean definition = registry.containsBeanDefinition("person");

        // 是否 linux 系统
        if(environment.getProperty("os.name").contains("linux")){
            return true;
        }
        return false;
    }
}
