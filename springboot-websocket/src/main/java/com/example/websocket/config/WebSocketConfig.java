package com.example.websocket.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

/**
 * 版权所有：宝润兴业科技股份有限公司
 * 类描述：广播式 （即服务器端有消息时，会将消息发给所有连接了当前endpoint的浏览器）
 * 创建时间：2018/9/24 17:27
 *
 * @author 朱超
 */
@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

    /**
     * 解释：
     * ① @EnableWebSocketMessageBroker 注解开启使用STOMP协议来传输基于（message broker）的消息，这时控制器支持使用@MessageMapping，就像使用@RequestMapping一样
     * ② 注册STOMP协议的节点（endpoint），并映射的指定的URL。
     * ③ 注册一个STOMP的endpoint ，并指定使用SockJS协议。
     * ④ 配置消息代理（message broker）
     * ⑤ 广播式应该配置一个/topic 消息代理。
     */

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint("/endpointStuart").withSockJS(); //广播式 用
        registry.addEndpoint("/endpointChat").withSockJS(); //点对点式 用
    }

    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        registry.enableSimpleBroker("queue","/topic"); //点对点式增加queue消息代理。
    }
}
