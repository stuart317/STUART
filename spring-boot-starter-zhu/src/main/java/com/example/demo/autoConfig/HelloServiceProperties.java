package com.example.demo.autoConfig;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * 版权所有：宝润兴业科技股份有限公司
 * 类描述： 模拟 自动配置
 * 创建时间：2018/9/5 19:24
 *
 * @author 朱超
 */
@ConfigurationProperties(prefix = "spring.hello")
public class HelloServiceProperties {

    private static final String MSG = " world";

    private String msg = MSG;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
