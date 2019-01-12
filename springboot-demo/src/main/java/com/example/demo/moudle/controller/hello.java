package com.example.demo.moudle.controller;

import com.example.demo.autoConfig.HelloService;
import com.example.demo.moudle.bean.User;
import com.example.demo.moudle.utils.property.AuthorSettings;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

/**
 * 版权所有：宝润兴业科技股份有限公司
 * 类描述：${DESCRIPTION}
 * 创建时间：2018/9/3 22:27
 *
 * @author 朱超
 */
@RestController
@RequestMapping("/hello")
public class hello {

    @Value("${test.param}")
    private String param;
    @Autowired
    private AuthorSettings authorSettings;
    @Autowired
    private HelloService helloService;

    @RequestMapping(name = "默认页面",value = "/{str}",method = RequestMethod.GET)
    public String index(@PathVariable String str, HttpServletRequest request){

        System.out.println(authorSettings.getName()+" ---- "+authorSettings.getAge());
        return "你的IP："+request.getRemoteHost()+"  hello world ----> "+str;
    }

    @RequestMapping("/test")
    public  @ResponseBody User hello(){
        User user = new User();
        user.setAge(18);
        user.setHobby("玩网络游戏呀");
        user.setName("斯图尔特");
        System.out.println("hello world");
        return user;
    }

    @RequestMapping("/say")
    public String sayhello(){
        System.out.println(helloService.sayHello());
        return helloService.sayHello();
    }
}
