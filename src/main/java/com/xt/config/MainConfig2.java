package com.xt.config;

import com.xt.bean.Color;
import com.xt.bean.ColorFactoryBean;
import com.xt.bean.Person;
import com.xt.bean.Red;
import com.xt.condition.LinuxCondition;
import com.xt.condition.MyImportBeanDefinitionRegister;
import com.xt.condition.MyImportSelector;
import com.xt.condition.WindowsCondition;
import org.springframework.context.annotation.*;

/**
 * @Conditional ：类中组件统一设置，放在类上。
 *      表明满足当前条件，这个类中的所有 bean 注册才能生效
 *
 * @Import(要导入容器中的组件) : 容器中就会自动注册这个组件，id 默认是全类名
 *
 */
@Import({Color.class, Red.class, MyImportSelector.class, MyImportBeanDefinitionRegister.class})
@Conditional(value = {WindowsCondition.class})
@Configuration
public class MainConfig2 {

    /**
     * @Scope : 调整作用域。 默认是单实例的
     * singleton : 单实例的（默认值）
     *      ioc 启动会调用方法创建对象放到 ioc 容器中，
     *      以后每次获取就是直接从容器（ioc.get()）中拿
     * prototype : 多实例的
     *      ioc 容器启动并不会去调用方法创建对象放在容器中，
     *      每次获取的时候才会调用方法创建对象。
     * request : 同一次请求创建一个实例
     * session : 同一个 session 创建一个实例
     *
     * ConfigurableBeanFactory#SCOPE_PROTOTYPE
     * 	 * @see ConfigurableBeanFactory#SCOPE_SINGLETON
     * 	 * @see org.springframework.web.context.WebApplicationContext#SCOPE_REQUEST  request
     * 	 * @see org.springframework.web.context.WebApplicationContext#SCOPE_SESSION	 session
     *
     * @Lazy ：懒加载
     *      单实例 bean ：默认在容器启动的时候创建对象
     *      懒加载：容器启动不创建对象，第一次使用（获取） Bean，创建对象，并初始化
     *
     * @return
     */
//    @Scope("prototype")
    @Lazy
    @Bean
    public Person person() {
        System.out.println("给容器中添加 Person 。。。");
        return new Person(16, "张三");
    }

    /**
     * @Conditional({Condition[]}) : 按照一定的条件进行判断，满足条件给容器中注册 bean
     *
     * 如果系统是 windows，给容器中注册 bill
     * 如果系统是 linux，给容器中注册 linus
     *
     * @return
     */
    @Conditional(value = {WindowsCondition.class})
    @Bean("bill")
    public Person person01() {
        return new Person(46, "Bill Gates");
    }

    @Conditional(value = {LinuxCondition.class})
    @Bean("linus")
    public Person person02() {
        return new Person(37, "Linus");
    }

    /**
     * 给容器中注册组件的方式：
     * 1）、包扫描 + 组件标注注解（@Controller、@Service、@Repository、@Component）[自己写的类]
     * 2）、@Bean [导入第三方包里面的组件]
     * 3）、@Import [快速给容器中导入一个组件]
     *          1）、@Import(要导入容器中的组件)：容器中就会自动注册这个组件，id 默认是全类名
     *          2)、ImportSelector : 返回需要导入的组件的全类名数组
     *          3)、ImportBeanDefinitionRegister : 手工注册 bean 到容器中
     * 4）、使用 Spring 提供的 FactoryBean （工厂 bean）
     *          1)、默认获取到的是工厂 bean 调用 getObject 创建的对象
     *          2)、要获取工厂 bean 本身，需要给 id 前面加一个 &，如：&colorFactoryBean
     */
    @Bean
    public ColorFactoryBean colorFactoryBean() {
        return new ColorFactoryBean();
    }
}
