package com.example.websocket.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 版权所有：宝润兴业科技股份有限公司
 * 类描述：view配置
 * 创建时间：2018/9/24 18:39
 *
 * @author 朱超
 */
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    //配置viewController，为stuart.html提供便捷的路径映射
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/ws").setViewName("/stuart");
        registry.addViewController("/login").setViewName("/login");
        registry.addViewController("/chat").setViewName("/chat");
    }
}
