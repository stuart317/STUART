package com.example.websocket.moudle.controller;

import com.example.websocket.moudle.message.StuartMessage;
import com.example.websocket.moudle.message.StuartResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

import java.security.Principal;

/**
 * 版权所有：宝润兴业科技股份有限公司
 * 类描述：websocket演示控制器
 * 创建时间：2018/9/24 17:45
 *
 * @author 朱超
 */
@Controller
public class WsController {

    //-----------------广播式-------------------------------

    @MessageMapping("/welcome")  //1 浏览器向服务器发送请求时，通过@MessageMapping映射/welcome这个地址，类似于@RequestMapping
    @SendTo("/topic/getResponse") //2 当服务端有消息时，会对订阅了@SendTo中路径的浏览器发送消息。
    public StuartResponse say(StuartMessage message) throws Exception{
        Thread.sleep(2000);
        return new StuartResponse("welcome ,"+message.getName()+" !!!");
    }


    //-----------------点对点式-------------------------------
    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate;//1 通过simpMessagingTemplate向浏览器发送消息

    @MessageMapping("/chat")
    public void handleChat(Principal principal,String msg){ //2 在springMVC中可直接获取principal，principal包含当前用户信息
        if("stuart".equals(principal.getName())){ //3 示例：如果发送人事 stuart则发给ws，如果是wa则发给stuart
            simpMessagingTemplate.convertAndSendToUser("ws","/queue/notifications",principal.getName()+" -send:"+msg);
        }else{
            //服务器向用户发送消息， 参数（接收消息的用户，浏览器订阅的值，消息本身）
            simpMessagingTemplate.convertAndSendToUser("stuart","/queue/notifications",principal.getName()+" -send:"+msg);
        }
    }
}
