package com.example.demo.autoConfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 版权所有：宝润兴业科技股份有限公司
 * 类描述：根据依据类的存在与否，来创建这个类的bean，这个类可以是第三方类库
 * 创建时间：2018/9/5 19:43
 *
 * @author 朱超
 */
@Configuration
@EnableConfigurationProperties(HelloServiceProperties.class) //这是一个开启使用配置参数的注解，value值就是我们配置实体参数映射的ClassType，将配置实体作为配置来源。
@ConditionalOnClass(HelloService.class)
@ConditionalOnProperty(prefix = "spring.hello" , value = "enabled" , matchIfMissing = true)
public class HelloServiceAutoConfiguration {

    /**
     * 注解解释：
     *   @ConditionalOnClass 判断 HelloService这个类的路径是否存在，且当容器中没有这个bean的情况下自动配置这个bean
     *
     *   注册配置(想要配置生效，需要注册自动配置类)， 在src/main/resources下新建 META-INF/spring.factories
     */
    @Autowired
    private HelloServiceProperties helloServiceProperties;


    /**
     * 根据条件判断不存在HelloService时初始化新bean到SpringIoc
     * @return
     */
    @Bean
    @ConditionalOnMissingBean(HelloService.class)
    public HelloService helloService(){
        System.out.println(">>>The HelloService Not Found，Execute Create New Bean.");
        HelloService helloService = new HelloService();
        helloService.setMsg(helloServiceProperties.getMsg());
        return helloService;
    }

}
