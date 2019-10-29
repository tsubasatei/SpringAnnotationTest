package com.xt.config;

import com.xt.bean.Car;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

/**
 * bean 的生命周期：
 *      bean 创建 -- 初始化 -- 销毁的过程
 * 容器管理 bean 的生命周期：
 *      可以自定义初始化和销毁方法：容器在 bean 进行到当前生命周期的时候来调用自定义的初始化和销毁方法
 *
 * 构造（对象创建）:
 *      单实例：在容器启动的时候创建对象
 *      多实例：在每次获取的时候创建对象
 * BeanPostProcessor.postProcessBeforeInitialization
 * 初始化 :
 *      对象创建完成，并赋值好，调用初始化方法 。。。
 * BeanPostProcessor.postProcessAfterInitialization
 * 销毁 :
 *      单实例 ：容器关闭的时候，调用销毁方法
 *      多实例 ：容器不会管理这个 bean，容器不会调用销毁方法
 *
 * 遍历得到容器中所有的 BeanPostProcessor：挨个执行 postProcessBeforeInitialization，
 * 一旦返回 null，跳出 for 循环，不会执行后面的 BeanPostProcessor.postProcessBeforeInitialization
 *
 * BeanPostProcessor 原理
 * org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory
 *      populateBean(beanName, mbd, instanceWrapper); 给 bean 进行属性赋值
 *      initializeBean(beanName, exposedObject, mbd);
 *      {
 *          applyBeanPostProcessorsBeforeInitialization(bean, beanName);
 *          invokeInitMethods(beanName, wrappedBean, mbd); 执行自定义初始化
 *          applyBeanPostProcessorsAfterInitialization(wrappedBean, beanName);
 *      }
 *
 *
 * 初始化方法：
 * 1)、指定初始化和销毁方法：
 *          通过 @Bean 指定 initMethod 和 destroyMethod  同 init-method=""  destroy-method=""
 *
 * 2)、通过让 Bean 实现 InitializingBean #afterPropertiesSet (定义初始化逻辑)
 *                     DisposableBean #destroy(定义销毁逻辑)
 *
 * 3)、使用 JSR250规范：需引入 maven依赖 javax.annotation-api
 *          @PostConstruct : 在 bean 创建完成并且属性赋值完成，来执行初始化方法
 *          @PreDestroy : 在容器销毁 bean 之前通知我们进行清理工作
 *
 * 4)、BeanPostProcessor[interface] : bean 的后置处理器
 *          在 bean 初始化前后进行一些处理工作
 *          postProcessBeforeInitialization : 在初始化之前工作
 *          postProcessAfterInitialization : 在初始化之后工作
 *
 * Spring 底层对 BeanPostProcessor 的使用：
 *      bean 赋值，注入其他组件，@Autowired，生命周期注解功能，@Async，XXX BeanPostProcessor
 */
@ComponentScan(value = "com.xt.bean")
@Configuration
public class MainConfigOfLifeCycle {

//    @Scope("prototype")
    @Bean(initMethod = "init", destroyMethod = "destroy")
    public Car car() {
        return new Car();
    }
}
