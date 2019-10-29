package com.xt.config;

import com.xt.bean.Car;
import com.xt.bean.Color;
import com.xt.dao.BookDao;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

/**
 * 自动装配：
 *      Spring 利用依赖注入（DI），完成对 IOC 容器中各个组件的依赖关系赋值
 *
 * 1)、@Autowired 自动注入
 *      ①、默认优先按照类型去容器中找到对应的组件：applicationContext.getBean(BookDao.class); 找到就赋值
 *      ②、如果找到多个相同类型的组件，再将属性的名称作为组件的 id 去容器中查找 applicationContext.getBean("bookDao");
 *      ③、@Qualifier("bookDao"): 使用 @Qualifier 指定需要装配的组件的 id，而不是使用属性名
 *      ④、自动装配默认一定要将属性赋值好，没有就会报错；
 *         可以使用 @Autowired(required = false)
 *      ⑤、@Primary：让 Spring 进行自动装配的时候，默认使用首选的 bean；
 *                   也可以继续使用 @Qualifier 指定需要装配的 bean 的名字
 *      BookService{
 *          @Autowired
 *          BookDao bookDao;
 *      }
 *
 * 2)、Spring 还支持使用 @Resource(JSR250) 和 @Inject(JSR330)[java规范的注解]
 *      @Resource :
 *          可以和 @Autowired 一样实现自动装配功能，默认是按照组件名称进行装配的，可用 name 属性更改
 *          没有能支持 @Primary 功能，没有支持 @Autowired(required = false)
 *      @Inject :
 *          需要导入 javax.inject 的包，和 @Autowired 的功能一样。没有 @Autowired(required = false) 的功能
 *   @Autowired : Spring 定义的 ； @Resource 、 @Inject 都是 java 规范
 *
 *  AutowiredAnnotationBeanPostProcessor : 解析完成自动装配功能
 *
 * 3)、@Autowired : 可以标注在构造器、参数、方法、属性
 *      ①、标注在方法上 : @Bean + 方法参数，参数从容器中获取; 默认不写 @Autowired 效果是一样的，都能自动装配
 *      ②、标注在构造器上 : 如果组件只有一个有参构造器，这个有参构造器的 @Autowired 可以省略，参数位置的组件还是可以自动从容器中获取
 *      ③、标注在参数位置上
 *
 * 4)、自定义组件想要使用 Spring 容器底层的一些组件 （ApplicationContext、BeanFactory、XXX），
 *      只需要自定义组件实现 XXXAware，在创建对象的时候，会调用接口规定的方法注入相关的组件 Aware
 *      把 Spring 底层一些组件注入到自定义的 bean 中
 *      XXXAware : 功能使用 XXXProcessor
 *          ApplicationContextAware ==> ApplicationContextAwareProcessor
 */
@Configuration
@ComponentScan({"com.xt.controller", "com.xt.service", "com.xt.dao", "com.xt.bean"})
public class MainConfigOfAutoWired {

    @Primary
    @Bean("bookDao2")
    public BookDao bookDao() {
        BookDao bookDao = new BookDao();
        bookDao.setLabel("2");
        return bookDao;
    }

    /**
     * @Bean 标注的方法创建对象的时候，方法参数的值从容器中获取
     *
     * @param car
     * @return
     */
    @Bean
    public Color color(Car car) {
        Color color = new Color();
        color.setCar(car);
        return color;
    }
}
