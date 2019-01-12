package com.zc;

import com.alibaba.dubbo.config.spring.context.annotation.DubboComponentScan;
import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

// ② 注解方式
// 开启基于注解的dubbo功能（主要是包扫描@DubboComponentScan）
// 也可以在配置文件中使用dubbo.scan.base-package来替代   @EnableDubbo
@EnableDubbo
@SpringBootApplication
// ① 引入dubbo配置文件方式
//@ImportResource({"classpath:config/spring-dubbo.xml"})
public class ZcRestApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZcRestApplication.class, args);
    }

}

