package com.xt.bean;

import org.springframework.beans.factory.FactoryBean;

/**
 * 创建一个 Spring 定义的 FactoryBean
 */
public class ColorFactoryBean implements FactoryBean<Color> {

    /**
     * 返回一个 Color 对象，这个对象会添加到容器中
     * @return
     * @throws Exception
     */
    public Color getObject() throws Exception {
        System.out.println("ColorFactoryBean ...");
        return new Color();
    }

    public Class<?> getObjectType() {
        return Color.class;
    }

    /**
     * 是否单例
     * true ：这个 bean 是单实例，在容器中保存一份
     * false : 多实例，每次获取都会创建一个新的 bean
     * @return
     */
    public boolean isSingleton() {
        return true;
    }
}
