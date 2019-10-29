package com.xt;


import com.xt.config.MainConfigOfProfile;
import com.xt.utils.BeanPrintUtils;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.sql.DataSource;
import java.util.Map;

public class IOCTest_Profile {

    /**
     * 1、使用命令行动态参数 ：在虚拟机参数位置加载 -Dspring.profiles.active=test
     * 2、代码的方式激活某种环境
     */
    @Test
    public void test () {
//        AnnotationConfigApplicationContext ioc = new AnnotationConfigApplicationContext(MainConfigOfProfile.class);

        // 1、创建一个 AnnotationConfigApplicationContext
        AnnotationConfigApplicationContext ioc = new AnnotationConfigApplicationContext();
        // 2、设置需要激活的环境
        ioc.getEnvironment().setActiveProfiles("test", "dev");
        // 3、注册主配置类
        ioc.register(MainConfigOfProfile.class);
        // 4、启动刷新容器
        ioc.refresh();

        Map<String, DataSource> sourceMap = ioc.getBeansOfType(DataSource.class);
        System.out.println(sourceMap);

        BeanPrintUtils.print(ioc);

        ioc.close();
    }
}
