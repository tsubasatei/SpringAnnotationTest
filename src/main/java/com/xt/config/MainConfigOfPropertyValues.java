package com.xt.config;

import com.xt.bean.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * @PropertySource : 读取外部配置文件中的 k/v 保存到运行的环境变量中;
 * 加载完外部的配置文件以后使用 ${}取出配置文件的值
 *
 * @PropertySources : 包含多个 @PropertySource
 */
@PropertySource(value = {"classpath:/person.properties"})
@Configuration
public class MainConfigOfPropertyValues {

    @Bean
    public Person person() {
        return new Person();
    }
}
