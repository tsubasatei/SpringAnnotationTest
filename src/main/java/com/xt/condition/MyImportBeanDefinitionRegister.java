package com.xt.condition;

import com.xt.bean.Rainbow;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;


public class MyImportBeanDefinitionRegister implements ImportBeanDefinitionRegistrar {

    /**
     * AnnotationMetadata : 当前类的注释信息
     * BeanDefinitionRegistry : BeanDefinition 注册类
     *      把所有需要添加到容器中的 bean，调用
     *      BeanDefinitionRegistry.registerBeanDefinition 手工注册进来
     * @param annotationMetadata
     * @param beanDefinitionRegistry
     */
    public void registerBeanDefinitions(AnnotationMetadata annotationMetadata, BeanDefinitionRegistry beanDefinitionRegistry) {
        boolean red = beanDefinitionRegistry.containsBeanDefinition("com.xt.bean.Red");
        boolean blue = beanDefinitionRegistry.containsBeanDefinition("com.xt.bean.Blue");
        if (red && blue) {
            // 指定 bean 定义信息（bean 的类型， bean 的作用域 。。。）
            RootBeanDefinition rainbow = new RootBeanDefinition(Rainbow.class);

            // 注册一个 bean，指定 bean 名
            beanDefinitionRegistry.registerBeanDefinition("rainbow", rainbow);
        }

    }
}
