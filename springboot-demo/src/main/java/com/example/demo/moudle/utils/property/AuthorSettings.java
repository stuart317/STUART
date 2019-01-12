package com.example.demo.moudle.utils.property;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * 版权所有：宝润兴业科技股份有限公司
 * 类描述：author 配置文件
 * 创建时间：2018/9/4 20:30
 *
 * @author 朱超
 */
@Component
@ConfigurationProperties(prefix = "box")
@PropertySource("classpath:config/author.properties")
public class AuthorSettings {
    /**
     * 通过 @ConfigurationProperties 加载properties的配置
     *      prefix 属性 指定  properties中key的前缀
     *      locations属性 在springboot 1.5以后 废弃了
     *    改用 PropertySource注解
     */
    private String name;

    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
